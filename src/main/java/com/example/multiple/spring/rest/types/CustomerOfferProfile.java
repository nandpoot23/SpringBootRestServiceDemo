package com.example.multiple.spring.rest.types;

import java.util.Date;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class CustomerOfferProfile implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String customerOfferID;
    private String offerNumber;
    private String customerID;
    private Date effectiveDate;
    private String isSynchronized;

    public String getCustomerOfferID() {
        return customerOfferID;
    }

    public void setCustomerOfferID(String customerOfferID) {
        this.customerOfferID = customerOfferID;
    }

    public String getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getIsSynchronized() {
        return isSynchronized;
    }

    public void setIsSynchronized(String isSynchronized) {
        this.isSynchronized = isSynchronized;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
