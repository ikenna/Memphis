package org.nacfuk.membermgt.system;

import org.nacfuk.membermgt.model.Contact;
import org.nacfuk.membermgt.model.SearchResults;

import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.Map;

public class Application {

    private ContactSystem contactSystem = new ContactSystem();

    public ContactBuilder createContact() {
        return contactSystem.createContact();
    }

    public Integer getTotalNumberOfContacts() {
        return contactSystem.getTotalNumberOfContacts();
    }

    public Map<String, String> getContact(int contactId) {
        return contactSystem.getContact(contactId);
    }

    public String getContactList() {
        return contactSystem.getContactList();
    }

    public SearchResults searchForContact(String searchQuery) {
        return contactSystem.searchForContact(searchQuery);
    }
}
