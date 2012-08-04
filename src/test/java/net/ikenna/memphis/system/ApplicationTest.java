package net.ikenna.memphis.system;

import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.SearchResults;
import org.apache.commons.io.FileUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ApplicationTest {

    public Application application;

    @Before
    public void setUp() throws Exception {
        application = new Application();
        FileUtils.deleteQuietly(new File("members.csv"));
    }

    @Test
    public void testShouldAddContact() throws Exception {
        Contact contact1 = application.getContactBuilder()
                .firstName("Ikenna")
                .lastName("Nwaiwu")
                .mobile("07879343233")
                .phone("0124839234322")
                .emailAddress("something@something.com")
                .residentialAddress("293 Witchards, Basildon, UK")
                .createContact();
        int contactId = application.getContactSystem().addContact(contact1);

        assertThat(application.getTotalNumberOfContacts(), CoreMatchers.equalTo(1));

        Contact contact = application.getContact(contactId);
        assertThat(contact.getName().getFirst(), is("Ikenna"));
        assertThat(contact.getName().getLast(), is("Nwaiwu"));
        assertThat(contact.getPhoneNumber().getMobile(), is("07879343233"));
        assertThat(contact.getPhoneNumber().getPhone(), is("0124839234322"));
        assertThat(contact.getPhoneNumber().getEmail(), is("something@something.com"));
        assertThat(contact.getAddress().toString(), is("293 Witchards, Basildon, UK"));

        Contact contact2 = application.getContactBuilder().firstName("Gbenga").lastName("Abatan").createContact();
        application.getContactSystem().addContact(contact2);
        assertThat(application.getTotalNumberOfContacts(), CoreMatchers.equalTo(2));
    }


    @Test
    public void testCanSearchContacts() throws Exception {
        Contact contact1 = application.getContactBuilder().firstName("Ikenna").lastName("Nwaiwu").createContact();
        Contact contact2 = application.getContactBuilder().firstName("Gbenga").lastName("Abatan").residentialAddress("No 5 Bishop crescent").createContact();
        application.getContactSystem().addContacts(contact1, contact2);

        SearchResults searchResults = application.searchForContact("Gbenga");
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.get(0).getName().getLast(), is("Abatan"));

        searchResults = application.searchForContact("Bishop");
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.get(0).getName().getLast(), is("Abatan"));
    }

    @Test
    public void testListAllContacts() throws Exception {
        Contact contact1 = application.getContactBuilder().firstName("Ikenna").lastName("Nwaiwu").createContact();
        Contact contact2 = application.getContactBuilder().firstName("Gbenga").lastName("Abatan").residentialAddress("No 5 Bishop crescent").createContact();
        application.getContactSystem().addContacts(contact1, contact2);

        List<Contact> contactList = application.getContactSystem().getAllContacts();

        assertThat(contactList.size(), is(2));


    }
}
