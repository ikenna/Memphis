package org.nacfuk.membermgt.model;

import com.google.common.collect.ImmutableMap;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Map;

import static org.nacfuk.membermgt.libs.MapBuilder.newMapBuilder;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Address {
    private final String residentialAddress;

    public Address(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public Map<String, String> asMap() {
        return newMapBuilder().map("residentialAddress", residentialAddress);
    }

    public String index() {
        return String.format(" %s ", residentialAddress);
    }
}
