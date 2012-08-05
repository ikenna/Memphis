package net.ikenna.memphis.system;


import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.SearchResults;

import java.util.List;

public class ContactSystem {

    public Database database = new MongoDatabase();

    public int getTotalNumberOfContacts() {
        return database.getAllContacts().size();
    }

    public int addContact(Contact contact) {
        database.add(contact);
        return database.getAllContacts().size();
    }


    public Contact getContact(int contactId) {
        return database.getAllContacts().get(contactId - 1);
    }

    public SearchResults searchForContact(String searchQuery) {
        return database.searchForContacts(new SearchQuery(searchQuery));
    }


    public void addContacts(Contact... contacts) {
        for (Contact contact : contacts) {
            addContact(contact);
        }
    }

    public List<Contact> getAllContacts() {
        return database.getAllContacts();
    }
}

