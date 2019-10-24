package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import org.springframework.util.StringUtils;

import java.util.Set;

public class Address {
    private int number;
    private String street;
    private int postalCode;
    private String city;

    private Address() {}

    public Address(int number, String street, int postalCode, String city) {
        this.number = number;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public void validate(Set<String>errors){
        if (this == null){
            errors.add(ErrorCodes.LIBRARY_MUST_HAVE_AN_ADDRESS);
        }
        if (StringUtils.isEmpty(this.street)){
            errors.add(ErrorCodes.ADDRESS_MUST_HAVE_A_STREET);
        }
        if(StringUtils.isEmpty(this.city)){
            errors.add(ErrorCodes.ADDRESS_MUST_HAVE_A_CITY);
        }
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
