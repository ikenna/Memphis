package net.ikenna.memphis.model;

public class Contact {
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
}
