package net.ikenna.memphis.system;

import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.SearchResults;

public class Application {

    private ContactSystem contactSystem = new ContactSystem();

    public ContactBuilder getContactBuilder() {
        return new ContactBuilder();
    }

    public Integer getTotalNumberOfContacts() {
        return contactSystem.getTotalNumberOfContacts();
    }

    public Contact getContact(int contactId) {
        return contactSystem.getContact(contactId);
    }


    public SearchResults searchForContact(String searchQuery) {
        return contactSystem.searchForContact(searchQuery);
    }

    public ContactSystem getContactSystem() {
        return contactSystem;
    }
}
