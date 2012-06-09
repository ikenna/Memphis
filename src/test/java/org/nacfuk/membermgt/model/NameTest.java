package org.nacfuk.membermgt.model;

import org.junit.Test;

public class NameTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCannotCreatedNameWithNullValues() throws Exception {
        new Name(null, null);
    }
}
