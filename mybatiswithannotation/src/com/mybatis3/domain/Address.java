package com.mybatis3.domain;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Address {
    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;

    }

    public void setStreet(String street) {
        this.street = street;
    }

    private Integer addrId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address(Integer addrId, String street, String city, String state, String zip, String country) {
        this.addrId = addrId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public Address() {}

    public Address(Integer addrId) {
        this.addrId = addrId;
    }

    @Override
    public String toString() {
        return "street="+street+", city="+city+", state="+state+", zip="+zip+", country=" + country;
    }
}
