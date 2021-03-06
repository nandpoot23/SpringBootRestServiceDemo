package com.example.multiple.spring.rest.dao;

import java.util.List;

import com.example.multiple.spring.rest.types.CustomerAddressDetails;
import com.example.multiple.spring.rest.types.CustomerConfigIdentifier;
import com.example.multiple.spring.rest.types.CustomerDetails;
import com.example.multiple.spring.rest.types.CustomerHDetails;
import com.example.multiple.spring.rest.types.CustomerOfferIdentifier;
import com.example.multiple.spring.rest.types.CustomerOfferProfile;
import com.example.multiple.spring.rest.types.ItemConfiguration;
import com.example.multiple.spring.rest.types.ItemConfigurationIdentifier;
import com.example.multiple.spring.rest.types.MarketConfiguration;
import com.example.multiple.spring.rest.types.MarketConfigurationIdentifier;
import com.example.multiple.spring.rest.types.MarketEffectiveConfig;
import com.example.multiple.spring.rest.types.VendorConfig;
import com.example.multiple.spring.rest.types.VendorDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public interface CustomerDbService {

    public CustomerDetails queryCustConfigs(CustomerConfigIdentifier id);

    public String queryNameCustomer(CustomerConfigIdentifier id);

    public Integer queryRow();

    public boolean isUserExist(String empName);

    public CustomerAddressDetails queryCustAddress(String custName);

    public List<CustomerAddressDetails> queryCommonCustomerLocation(String location);

    public String queryCustEmail(String firstName);

    public ItemConfiguration getItemConfiguration(ItemConfigurationIdentifier itemConfigurationIdentifier);

    public MarketConfiguration getMarketConfiguration(MarketConfigurationIdentifier marketConfigurationIdentifier);

    public List<MarketConfiguration> getEffectiveMarketByDate(MarketEffectiveConfig marketEff, boolean active);

    public VendorDetails getVendorConfiguration(VendorConfig vendorConfig);

    public CustomerHDetails queryCustConfigsHibernate(int id);

    public List<CustomerOfferProfile> queryCustomerOffer(CustomerOfferIdentifier customerOfferIdentifier);

}
