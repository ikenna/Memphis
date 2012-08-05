package net.ikenna.memphis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static com.google.common.collect.Sets.newTreeSet;

public class SearchResults {

    private TreeSet<Contact> results = newTreeSet();

    public Contact get(int index) {
        return new ArrayList<Contact>(results).get(index);
    }

    public void add(Contact contact) {
        results.add(contact);
    }

    public int size() {
        return results.size();
    }

    public void addAll(List<Contact> contacts) {
        results.addAll(contacts);
    }
}
