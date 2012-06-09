package org.nacfuk.membermgt.system;

import org.nacfuk.membermgt.model.Contact;
import org.nacfuk.membermgt.model.SearchResults;

import java.util.*;

public class ContactSystem {

    private final List<Contact> contacts = new ArrayList();

    public int getTotalNumberOfContacts() {
        return contacts.size();
    }

    int addContact(Contact contact) {
        contacts.add(contact);
        return contacts.size();
    }

    public ContactBuilder createContact() {
        return new ContactBuilder(this);
    }

    public String getContactList() {
        StringBuilder json = new StringBuilder("{\"");
        for (Contact contact : contacts) {
            json.append(contact.toJson());
        }
        return json.append("\"}").toString();
    }

    public Map<String, String> getContact(int contactId) {
        Contact contact = contacts.get(contactId-1);
        return contact.asMap();
    }

    public SearchResults searchForContact(String searchQuery) {
        SearchResults results = new SearchResults();
        for (Contact contact : contacts) {
            if(contact.indexContains(searchQuery)){
                  results.add(contact.asMap());
            }
        }
        return results;
    }
}
