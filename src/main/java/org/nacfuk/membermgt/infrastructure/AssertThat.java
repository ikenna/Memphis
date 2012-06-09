package org.nacfuk.membermgt.infrastructure;

public class AssertThat extends org.springframework.util.Assert{

    public static void notNull(Object... objs){
        for (Object obj : objs) {
            org.springframework.util.Assert.notNull(obj);
        }
    }

}
