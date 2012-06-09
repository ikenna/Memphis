package org.nacfuk.membermgt.infrastructure;

public class EmptyStringIfNull {
    public static String emptyStringIfNull(String value) {
        return value == null ? "" : value;
    }
}
