package net.ikenna.memphis.model;


public class Address {
    private final String residentialAddress;

    public Address(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String index() {
        return String.format(" %s ", residentialAddress);
    }

    @Override
    public String toString() {
        return residentialAddress;
    }
}
