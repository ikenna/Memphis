package net.ikenna.memphis.system;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class CsvRecord {

    private final List<String> elements;

    public CsvRecord(String[] stringArray) {
        elements = Arrays.asList(stringArray);
    }

    public CsvRecord() {
        elements = newArrayList();
    }

    public String[] getEntries() {
        return elements.toArray(new String[0]);
    }

    public String get(int i) {
        return elements.get(i);
    }

    public CsvRecord add(String element) {
        elements.add(element);
        return this;
    }
}
