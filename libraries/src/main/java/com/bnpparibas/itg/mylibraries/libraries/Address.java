package com.bnpparibas.itg.mylibraries.libraries;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.StringTokenizer;

@Embeddable
public class Address {
    @Column(name = "ADDRESS_ID")
    private int number;
    @Column(name = "ADDRESS_STREET")
    private String street;
    @Column(name = "ADDRESS_POSTALCODE")
    private int postalCode;
    @Column(name = "ADDRESS_CITY")
    private String city;

    private Address() {}

    public Address(int number, String street, int postalCode, String city) {
        this.number = number;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
