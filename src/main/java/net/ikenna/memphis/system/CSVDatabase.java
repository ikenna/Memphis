package net.ikenna.memphis.system;

import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.SearchResults;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class CSVDatabase implements Database {
    private final CsvEngine csvEngine;

    public CSVDatabase() {
        csvEngine = new CsvEngine("members.csv");
    }


    public List<Contact> getAllContacts() {
        List<Contact> contacts = newArrayList();
        for (CsvRecord csvRecord : getCsvRecords()) {
            Contact contact = createContactFromCsvRecord(csvRecord);
            contacts.add(contact);
        }
        return contacts;
    }

    private Contact createContactFromCsvRecord(CsvRecord csvRecord) {
        return new ContactBuilder()
                .firstName(csvRecord.get(0))
                .lastName(csvRecord.get(1))
                .mobile(csvRecord.get(2))
                .phone(csvRecord.get(3))
                .emailAddress(csvRecord.get(4))
                .residentialAddress(csvRecord.get(5))
                .createContact();
    }

    public List<CsvRecord> getCsvRecords() {
        return csvEngine.read();
    }

    public void add(Contact contact) {
        CsvRecord record = new CsvRecord()
                .add(contact.getName().getFirst())
                .add(contact.getName().getLast())
                .add(contact.getPhoneNumber().getMobile())
                .add(contact.getPhoneNumber().getPhone())
                .add(contact.getPhoneNumber().getEmail())
                .add(contact.getAddress().toString());
        csvEngine.writeNext(record);
    }

    @Override
    public SearchResults searchForContacts(String searchQuery) {
        SearchResults results = new SearchResults();
        for (CsvRecord csvRecord : getCsvRecords()) {
            List<String> strings = Arrays.asList(csvRecord.getEntries());
            for (String string : strings) {
                if (string.contains(searchQuery)) {
                    Contact contact = createContactFromCsvRecord(csvRecord);
                    results.add(contact);
                }

            }
        }
        return results;
    }
}
