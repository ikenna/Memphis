package net.ikenna.memphis.model;

import com.google.common.collect.ComparisonChain;

public class Contact implements Comparable<Contact> {
    private final Name name;
    private final PhoneEmail phoneEmail;
    private final Address address;

    public Contact(Name name, PhoneEmail phoneEmail, Address address) {
        this.name = name;
        this.phoneEmail = phoneEmail;
        this.address = address;
    }


    public Name getName() {
        return name;
    }


    public PhoneEmail getPhoneNumber() {
        return phoneEmail;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", phoneEmail=" + phoneEmail +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Contact other) {
        return ComparisonChain.start()
                .compare(name.getFirst(), other.getName().getFirst())
                .compare(name.getLast(), other.getName().getLast())
                .compare(phoneEmail.getMobile(), other.phoneEmail.getMobile())
                .result();
    }
}
