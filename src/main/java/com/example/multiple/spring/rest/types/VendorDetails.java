package com.example.multiple.spring.rest.types;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class VendorDetails {

    private String vendorID;
    private String vendorName;
    private String vendorCode;
    private String vendorType;
    private String vendorValue;

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorValue() {
        return vendorValue;
    }

    public void setVendorValue(String vendorValue) {
        this.vendorValue = vendorValue;
    }

}
