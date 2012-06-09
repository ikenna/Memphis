package org.nacfuk.membermgt.model;

import com.google.common.collect.ImmutableMap;
import org.nacfuk.membermgt.infrastructure.AssertThat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Map;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        AssertThat.notNull(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toJson() {
        return  String.format("{\"firstName\":\"%s\", \"lastName\":\"%s\"}", firstName, lastName);
    }

    public Map<String, String> asMap() {
        return ImmutableMap.of("firstName", firstName, "lastName", lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String index() {
        return String.format(" %s %s ", firstName, lastName);
    }
}
