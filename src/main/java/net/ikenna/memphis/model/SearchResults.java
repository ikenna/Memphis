package net.ikenna.memphis.model;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SearchResults {

    List<Contact> results = newArrayList();

    public Contact get(int index) {
        return results.get(index);
    }

    public void add(Contact contact) {
        results.add(contact);
    }

    public int size() {
        return results.size();
    }
}
