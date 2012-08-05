package net.ikenna.memphis.system;

import com.google.common.collect.ImmutableList;
import com.mongodb.*;
import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.SearchResults;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static net.ikenna.memphis.system.MongoFields.*;

public class MongoDatabase implements Database {

    private static final String membersCollection = "members";

    @Override
    public List<Contact> getAllContacts() {
        DB db = getDB();
        db.requestStart();
        DBCollection members = db.getCollection(membersCollection);
        DBCursor dbCursor = members.find();
        ArrayList<Contact> contacts = createContacts(dbCursor);
        dbCursor.close();
        db.requestDone();
        return contacts;
    }

    private ArrayList<Contact> createContacts(DBCursor dbCursor) {
        ArrayList<Contact> contacts = newArrayList();
        while (dbCursor.hasNext()) {
            DBObject dbObject = dbCursor.next();
            Contact contact = new ContactBuilder()
                    .firstName(dbObject.get(firstName.name()).toString())
                    .lastName(dbObject.get(lastName.name()).toString())
                    .emailAddress(dbObject.get(email.name()).toString())
                    .mobile(dbObject.get(mobile.name()).toString())
                    .phone(dbObject.get(phone.name()).toString())
                    .residentialAddress(dbObject.get(address.name()).toString())
                    .createContact();
            contacts.add(contact);
        }
        return contacts;
    }

    private DB getDB() {
        return MyMongo.INSTANCE.mongo.getDB(MongoFields.nacf_db.name());
    }

    @Override
    public void add(Contact contact) {
        DB db = getDB();
        db.requestStart();
        DBCollection members = db.getCollection(membersCollection);
        BasicDBObject doc = new BasicDBObject();
        doc.put(firstName.name(), contact.getName().getFirst());
        doc.put(lastName.name(), contact.getName().getLast());
        doc.put(email.name(), contact.getPhoneNumber().getEmail());
        doc.put(mobile.name(), contact.getPhoneNumber().getMobile());
        doc.put(phone.name(), contact.getPhoneNumber().getPhone());
        doc.put(address.name(), contact.getAddress().toString());
        doc.put(searchTags.name(), createIndexOfTagsToSearchOn(contact));
        members.insert(doc);
        db.requestDone();
    }

    private List<String> createIndexOfTagsToSearchOn(Contact contact) {
        return ImmutableList.<String>builder()
                .add(contact.getName().getFirst())
                .add(contact.getName().getLast())
                .add(contact.getPhoneNumber().getMobile())
                .add(contact.getPhoneNumber().getPhone())
                .addAll(splitAddress(contact))
                .build();
    }

    private List<String> splitAddress(Contact contact) {
        return newArrayList(contact.getAddress().toString().split("\\s"));
    }

    @Override
    public SearchResults searchForContacts(SearchQuery searchQuery) {
        SearchResults results = new SearchResults();
        DB db = getDB();
        DBCollection membersCollection = db.getCollection(MongoDatabase.membersCollection);
        for (SearchToken token : searchQuery.getSearchTokens()) {
            DBObject query = new BasicDBObjectBuilder().add(searchTags.name(), token.toString()).get();
            DBCursor dbCursor = membersCollection.find(query);
            ArrayList<Contact> contacts = createContacts(dbCursor);
            results.addAll(contacts);
            dbCursor.close();
        }
        db.requestDone();
        return results;
    }

}

