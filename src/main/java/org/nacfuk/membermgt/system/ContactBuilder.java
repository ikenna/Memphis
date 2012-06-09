package org.nacfuk.membermgt.system;

import org.nacfuk.membermgt.infrastructure.EmptyStringIfNull;
import org.nacfuk.membermgt.model.Address;
import org.nacfuk.membermgt.model.Name;
import org.nacfuk.membermgt.model.Contact;
import org.nacfuk.membermgt.model.PhoneEmail;

import static org.nacfuk.membermgt.infrastructure.EmptyStringIfNull.emptyStringIfNull;

public class ContactBuilder {
    private String firstName = "";
    private String lastName = "";
    private String mobile = "";
    private String phone = "";
    private String email = "";
    private String residentialAddress = "";

    private final ContactSystem contactSystem;

    public ContactBuilder(ContactSystem contactSystem) {
        this.contactSystem = contactSystem;
    }

    public ContactBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int submit() {
        Name name = new Name(firstName, lastName);
        PhoneEmail phoneEmail = new PhoneEmail(mobile, phone, email);
        Address address = new Address(residentialAddress);
        return contactSystem.addContact(new Contact(name, phoneEmail, address));
    }

    public ContactBuilder mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactBuilder emailAddress(String email) {
        this.email = email;
        return this;
    }

    public ContactBuilder residentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
        return this;
    }
}
