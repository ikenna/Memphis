package net.ikenna.memphis.system;

import net.ikenna.memphis.model.Address;
import net.ikenna.memphis.model.Contact;
import net.ikenna.memphis.model.Name;
import net.ikenna.memphis.model.PhoneEmail;

public class ContactBuilder {
    private String firstName = "";
    private String lastName = "";
    private String mobile = "";
    private String phone = "";
    private String email = "";
    private String residentialAddress = "";


    public ContactBuilder() {
    }

    public ContactBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public Contact createContact() {
        Name name = new Name(firstName, lastName);
        PhoneEmail phoneEmail = new PhoneEmail(mobile, phone, email);
        Address address = new Address(residentialAddress);
        return new Contact(name, phoneEmail, address);
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
