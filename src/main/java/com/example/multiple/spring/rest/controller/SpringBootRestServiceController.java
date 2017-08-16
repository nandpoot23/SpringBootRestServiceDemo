package com.example.multiple.spring.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.multiple.spring.rest.service.MultiServiceInterface;
import com.example.multiple.spring.rest.types.CustomerAddressDetails;
import com.example.multiple.spring.rest.types.CustomerConfigIdentifier;
import com.example.multiple.spring.rest.types.CustomerDetails;
import com.example.multiple.spring.rest.types.CustomerEmail;
import com.example.multiple.spring.rest.types.CustomerHDetails;
import com.example.multiple.spring.rest.types.CustomerLocation;
import com.example.multiple.spring.rest.types.CustomerName;
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

@RestController
@RequestMapping(value = "/multipleCustomer/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringBootRestServiceController {

    @Autowired
    @Qualifier("MultiServiceImpl")
    private MultiServiceInterface multiService;

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootRestServiceController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String greetingTime() {

        LOG.info("External service starting .........");
        System.out.println(" ****** Welcome to our World! ******* ");
        return "Spring in Action (Manning), Cloud Native Java, Learning Spring Boot";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/empConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmpDetails> getEmpConfiguration(@RequestBody EmpConfigIdentifier id) {

        EmpDetails response = multiService.queryEmpConfigs(id);
        return new ResponseEntity<EmpDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDetails> getCustConfiguration(@RequestBody CustomerConfigIdentifier id) {

        CustomerDetails response = multiService.queryCustConfigs(id);
        return new ResponseEntity<CustomerDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/myCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getNameCustomer(@RequestBody CustomerConfigIdentifier id) {

        String response = multiService.queryNameCustomer(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/qeRow")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Integer> queryRow() {

        Integer response = multiService.queryRow();
        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userExist", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> isUserExist(@RequestBody EmpDetails empName) {

        Boolean response = multiService.isUserExist(empName.getFirstName());
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custAddress", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerAddressDetails> getCustAddress(@RequestBody CustomerName custName) {

        CustomerAddressDetails response = multiService.queryCustAddress(custName.getCustName());
        return new ResponseEntity<CustomerAddressDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custAddressCommon", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerAddressDetails>> getCustAddressCommon(
            @RequestBody CustomerLocation commonCustLocation) {

        List<CustomerAddressDetails> response = multiService.queryCommonCustomerLocation(commonCustLocation
                .getLocation());
        return new ResponseEntity<List<CustomerAddressDetails>>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custEmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getCustEmail(@RequestBody CustomerEmail custEmail) {

        String response = multiService.queryCustEmail(custEmail.getFirstName());
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/itemConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ItemConfiguration> getItemConfiguration(@RequestBody ItemConfigurationIdentifier itemId) {

        ItemConfiguration response = multiService.getItemConfiguration(itemId);
        return new ResponseEntity<ItemConfiguration>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/marketConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MarketConfiguration> getMarketConfiguration(
            @RequestBody MarketConfigurationIdentifier marketId) {

        MarketConfiguration response = multiService.getMarketConfiguration(marketId);
        return new ResponseEntity<MarketConfiguration>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/marketEffective", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MarketConfiguration>> getMarketByEffectiveDate(
            @RequestBody MarketEffectiveConfig marketEff) {

        List<MarketConfiguration> response = multiService.getEffectiveMarketByDate(marketEff);
        return new ResponseEntity<List<MarketConfiguration>>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vendorConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VendorDetails> getVendorConfiguration(@RequestBody VendorConfig venderConfig) {

        VendorDetails response = multiService.getVendorConfiguration(venderConfig);
        return new ResponseEntity<VendorDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custDetailsHibernate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerHDetails> getCustHibnerte(@RequestBody CustomerConfigIdentifier id) {

        CustomerHDetails response = multiService.queryCustConfigsHibernate(id.getId());
        return new ResponseEntity<CustomerHDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/CustOffer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerOfferProfile[]> getCustomerOffer(
            @RequestBody CustomerOfferIdentifier customerOfferIdentifier) {

        CustomerOfferProfile[] response = multiService.queryCustomerOffer(customerOfferIdentifier);
        return new ResponseEntity<CustomerOfferProfile[]>(response, HttpStatus.OK);
    }

}