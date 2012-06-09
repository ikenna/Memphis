package org.nacfuk.membermgt.model;

import java.util.ArrayList;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class SearchResults extends ArrayList<Map<String, String>> {
    @Override
    public Map<String, String> get(int index) {
        if (size() == 0) {
            return newHashMap();
        } else {
            return super.get(index);
        }
    }

}
