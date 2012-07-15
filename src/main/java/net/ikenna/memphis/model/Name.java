package net.ikenna.memphis.model;


import static com.google.common.base.Preconditions.checkNotNull;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        checkNotNull(firstName);
        checkNotNull(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
