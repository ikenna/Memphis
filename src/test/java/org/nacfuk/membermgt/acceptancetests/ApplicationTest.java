package org.nacfuk.membermgt.acceptancetests;

import org.junit.Before;
import org.junit.Test;
import org.nacfuk.membermgt.model.SearchResults;
import org.nacfuk.membermgt.system.Application;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.internal.matchers.StringContains.containsString;

public class ApplicationTest {

    public Application system;

    @Before
    public void setUp() throws Exception {
        system = new Application();
    }

    @Test
    public void testShouldAddContact() throws Exception {
        int contactId = system.createContact()
                .firstName("Ikenna")
                .lastName("Nwaiwu")
                .mobile("07879343233")
                .phone("0124839234322")
                .emailAddress("something@something.com")
                .residentialAddress("293 Witchards, Basildon, UK")
                .submit();
        assertThat(system.getTotalNumberOfContacts(), equalTo(1));
        Map<String, String> contact = system.getContact(contactId);
        assertThat(contact.get("firstName"), is("Ikenna"));
        assertThat(contact.get("lastName"), is("Nwaiwu"));
        assertThat(contact.get("mobile"), is("07879343233"));
        assertThat(contact.get("phone"), is("0124839234322"));
        assertThat(contact.get("email"), is("something@something.com"));
        assertThat(contact.get("residentialAddress"), is("293 Witchards, Basildon, UK"));

        system.createContact().firstName("Gbenga").lastName("Abatan").submit();
        assertThat(system.getTotalNumberOfContacts(), equalTo(2));
    }

    @Test
    public void testShouldRetrieveContacts() throws Exception {
        system.createContact().firstName("Ikenna").lastName("Nwaiwu").submit();
        system.createContact().firstName("Gbenga").lastName("Abatan").submit();
        assertThat(system.getContactList(), containsString("\"firstName\":\"Ikenna\""));
        assertThat(system.getContactList(), containsString("\"lastName\":\"Abatan\""));
    }

    @Test
    public void testCanSearchContacts() throws Exception {
        system.createContact().firstName("Ikenna").lastName("Nwaiwu").submit();
        system.createContact().firstName("Gbenga").lastName("Abatan").residentialAddress("No 5 Bishop crescent").submit();
        SearchResults searchResults = system.searchForContact("Gbenga");
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.get(0).get("lastName"), is("Abatan"));

        searchResults = system.searchForContact("Bishop");
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.get(0).get("lastName"), is("Abatan"));
    }
}
