package com.example.multiple.spring.rest.types;

import java.util.Date;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class MarketConfiguration {

    /**
     * The unique identifier for the market.
     */
    private Long marketId;

    /**
     * The unique identifier for the term.
     */
    private Long termTextId;

    /**
     * The corp code for the market.
     */
    private String corpCd;

    /**
     * The My Agent for the market.
     */
    private String myAgt;

    /**
     * The name for the market.
     */
    private String mrktName;

    /**
     * The date/time when the term text becomes active.
     */
    private Date activeBeginDate;

    /**
     * The date/time when the term text expires.
     */
    private Date activeEndDate;

    /**
     * <code>true</code> if the term text is active; otherwise,
     * <code>false</code>.
     */
    private Boolean active;

    private String termTextTitle;

    /**
     * A description for the term text.
     */
    private String description;

    /**
     * The version for the term text.
     */
    private double version;

    private String accountNumber;

    private String customerId;

    private String customerStatus;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getTermTextId() {
        return termTextId;
    }

    public void setTermTextId(Long termTextId) {
        this.termTextId = termTextId;
    }

    public String getCorpCd() {
        return corpCd;
    }

    public void setCorpCd(String corpCd) {
        this.corpCd = corpCd;
    }

    public String getMyAgt() {
        return myAgt;
    }

    public void setMyAgt(String myAgt) {
        this.myAgt = myAgt;
    }

    public String getMrktName() {
        return mrktName;
    }

    public void setMrktName(String mrktName) {
        this.mrktName = mrktName;
    }

    public Date getActiveBeginDate() {
        return activeBeginDate;
    }

    public void setActiveBeginDate(Date activeBeginDate) {
        this.activeBeginDate = activeBeginDate;
    }

    public Date getActiveEndDate() {
        return activeEndDate;
    }

    public void setActiveEndDate(Date activeEndDate) {
        this.activeEndDate = activeEndDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTermTextTitle() {
        return termTextTitle;
    }

    public void setTermTextTitle(String termTextTitle) {
        this.termTextTitle = termTextTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

}
