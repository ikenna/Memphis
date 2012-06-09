package org.nacfuk.membermgt.model;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static org.nacfuk.membermgt.libs.MapBuilder.newMapBuilder;

public class Contact {
    private final Name name;
    private final PhoneEmail phoneEmail;
    private final Address address;

    public Contact(Name name, PhoneEmail phoneEmail, Address address) {
        this.name = name;
        this.phoneEmail = phoneEmail;
        this.address = address;
    }

    public String toJson() {
        return name.toJson();
    }

    public Map<String, String> asMap() {
        return newMapBuilder()
                .putAllMap(name.asMap())
                .putAllMap(phoneEmail.asMap())
                .putAllMap(address.asMap());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", phoneEmail=" + phoneEmail +
                ", address=" + address +
                '}';
    }

    public boolean indexContains(String searchQuery) {
        String[] split = searchQuery.split("\\s");
        for (String token : split) {
            if(index().contains(token)){
                return true;
            }
        }
        return false;
    }

    public String index() {
        return name.index() + phoneEmail.index() + address.index();
    }


}
