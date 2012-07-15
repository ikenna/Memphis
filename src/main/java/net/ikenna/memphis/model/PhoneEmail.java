package net.ikenna.memphis.model;


import net.ikenna.memphis.util.Preconditions;

public class PhoneEmail {
    private final String mobile;

    private final String phone;
    private final String email;

    public PhoneEmail(String mobile, String phone, String email) {
        Preconditions.checkNotNullArguments(mobile, phone, email);
        this.mobile = mobile;
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
