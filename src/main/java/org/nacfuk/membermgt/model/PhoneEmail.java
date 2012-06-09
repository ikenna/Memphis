package org.nacfuk.membermgt.model;

import com.google.common.collect.ImmutableMap;
import org.nacfuk.membermgt.infrastructure.AssertThat;

import java.util.Map;

public class PhoneEmail {
    private final String mobile;
    private final String phone;
    private final String email;

    public PhoneEmail(String mobile, String phone, String email) {
        AssertThat.notNull(mobile, phone, email);
        this.mobile = mobile;
        this.phone = phone;
        this.email = email;
    }

    public Map<String, String> asMap() {
        return ImmutableMap.of("mobile", mobile, "phone", phone, "email", email);
    }

    public String index() {
        return String.format(" %s %s %s ", mobile, phone, email);
    }
}
