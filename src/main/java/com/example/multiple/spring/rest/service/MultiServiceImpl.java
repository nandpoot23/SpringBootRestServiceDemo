package com.example.multiple.spring.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.multiple.spring.rest.dao.CustomerDbService;
import com.example.multiple.spring.rest.dao.MultiDbService;
import com.example.multiple.spring.rest.types.CustomerAddressDetails;
import com.example.multiple.spring.rest.types.CustomerConfigIdentifier;
import com.example.multiple.spring.rest.types.CustomerDetails;
import com.example.multiple.spring.rest.types.CustomerHDetails;
import com.example.multiple.spring.rest.types.CustomerOfferIdentifier;
import com.example.multiple.spring.rest.types.CustomerOfferProfile;
import com.example.multiple.spring.rest.types.EmpConfigIdentifier;
import com.example.multiple.spring.rest.types.EmpDetails;
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

@Component("MultiServiceImpl")
public class MultiServiceImpl implements MultiServiceInterface {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(MultiServiceImpl.class);

    @Autowired
    private MultiDbService multiDbService;

    @Autowired
    private CustomerDbService customerDbService;

    private static final boolean ACTIVE_FLAG = true;

    @Override
    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id) {

        if (id != null) {
            LOG.debug("MyServiceImpl::queryEmpConfigs  id : " + id.getId());
        }
        return multiDbService.queryEmpConfigs(id);
    }

    @Override
    public CustomerDetails queryCustConfigs(CustomerConfigIdentifier id) {

        if (id != null) {
            LOG.debug("MyServiceImpl::queryCustConfigs  id : " + id.getId());
        }

        return customerDbService.queryCustConfigs(id);
    }

    @Override
    public String queryNameCustomer(CustomerConfigIdentifier id) {

        if (id != null) {
            LOG.debug("MyServiceImpl::queryNameCustomer  id : " + id.getId());
        }

        return customerDbService.queryNameCustomer(id);

    }

    @Override
    public Integer queryRow() {

        return customerDbService.queryRow();
    }

    @Override
    public Boolean isUserExist(String empName) {

        return customerDbService.isUserExist(empName);
    }

    @Override
    public CustomerAddressDetails queryCustAddress(String custName) {

        if (custName != null) {
            LOG.debug("MyServiceImpl::queryCustAddress  custName : " + custName);
        }

        return customerDbService.queryCustAddress(custName);

    }

    @Override
    public List<CustomerAddressDetails> queryCommonCustomerLocation(String location) {

        if (location != null) {
            LOG.debug("MyServiceImpl::queryCommonCustomerLocation  location : " + location);
        }

        return customerDbService.queryCommonCustomerLocation(location);

    }

    @Override
    public String queryCustEmail(String firstName) {

        if (firstName != null) {
            LOG.debug("MyServiceImpl::queryCustEmail  firstName : " + firstName);
        }

        return customerDbService.queryCustEmail(firstName);

    }

    @Override
    public ItemConfiguration getItemConfiguration(ItemConfigurationIdentifier itemConfigurationIdentifier) {

        if (itemConfigurationIdentifier != null) {
            LOG.debug("MyServiceImpl::getItemConfiguration  itemId : " + itemConfigurationIdentifier.getItemId());
        }

        return customerDbService.getItemConfiguration(itemConfigurationIdentifier);

    }

    @Override
    public MarketConfiguration getMarketConfiguration(MarketConfigurationIdentifier marketConfigurationIdentifier) {

        if (marketConfigurationIdentifier != null) {
            LOG.debug("MyServiceImpl::getMarketConfiguration  marketId : "
                    + marketConfigurationIdentifier.getMarketId());
        }

        return customerDbService.getMarketConfiguration(marketConfigurationIdentifier);

    }

    @Override
    public List<MarketConfiguration> getEffectiveMarketByDate(MarketEffectiveConfig marketEff) {

        if (marketEff != null) {
            LOG.debug("MyServiceImpl::getEffectiveMarketByDate  marketEffectiveDate : " + marketEff.getEffectiveDate());
        }

        return customerDbService.getEffectiveMarketByDate(marketEff, ACTIVE_FLAG);

    }

    @Override
    public VendorDetails getVendorConfiguration(VendorConfig vendorConfig) {

        if (vendorConfig != null) {
            LOG.debug("MyServiceImpl::getVendorConfiguration  vendorId : " + vendorConfig.getVendorID());
        }

        return customerDbService.getVendorConfiguration(vendorConfig);

    }

    @Override
    public CustomerHDetails queryCustConfigsHibernate(int id) {

        if (id != 0) {
            LOG.debug("MyServiceImpl::queryCustConfigsHibernate  id : " + id);
        }

        return customerDbService.queryCustConfigsHibernate(id);

    }

    @Override
    public CustomerOfferProfile[] queryCustomerOffer(CustomerOfferIdentifier customerOfferIdentifier) {

        List<CustomerOfferProfile> profiles = new ArrayList<CustomerOfferProfile>();

        if (customerOfferIdentifier != null) {
            LOG.debug("MyServiceImpl::queryCustomerOffer  customerOfferIdentifier : "
                    + customerOfferIdentifier.getOfferNumber());

            profiles = customerDbService.queryCustomerOffer(customerOfferIdentifier);

        }

        return profiles.toArray(new CustomerOfferProfile[profiles.size()]);
    }

}
