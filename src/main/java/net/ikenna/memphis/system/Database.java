package net.ikenna.memphis.system;

import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.SearchResults;

import java.util.List;

interface Database {
    List<Contact> getAllContacts();

    void add(Contact contact);

    SearchResults searchForContacts(SearchQuery searchQuery);
}
