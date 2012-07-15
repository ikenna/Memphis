package net.ikenna.memphis.util;

public class Preconditions {
    public static void checkNotNullArguments(Object... values) {
        for (Object value : values) {
            com.google.common.base.Preconditions.checkNotNull(value);
        }
    }
}
