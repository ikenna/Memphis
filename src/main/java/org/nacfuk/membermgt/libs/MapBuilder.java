package org.nacfuk.membermgt.libs;

import java.util.HashMap;
import java.util.Map;


public class MapBuilder<S, T> extends HashMap<S, T> {

    public MapBuilder<S, T> map(S key, T value) {
        put(key, value);
        return this;
    }


    public MapBuilder<S, T> putAllMap(Map<S, T> m) {
        super.putAll(m);
        return this;
    }

    public static MapBuilder newMapBuilder() {
        return new MapBuilder();
    }
}






