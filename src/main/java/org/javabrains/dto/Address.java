package org.javabrains.dto;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Created by Karen on 07-Jul-17.
 */

@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String pincode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
