package com.example.multiple.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.multiple.spring.rest.types.CustomerOfferProfile;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class CustomerOfferProfileResultSetExtractor implements ResultSetExtractor<List<CustomerOfferProfile>> {

    @Override
    public List<CustomerOfferProfile> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<CustomerOfferProfile> profileList = new ArrayList<CustomerOfferProfile>();

        while (rs.next()) {
            CustomerOfferProfile customerOfferProfile = new CustomerOfferProfile();
            customerOfferProfile.setCustomerOfferID(rs.getString("CustomerOfferID"));
            customerOfferProfile.setOfferNumber(rs.getString("OfferNumber"));
            customerOfferProfile.setCustomerID(rs.getString("CustomerID"));
            customerOfferProfile.setEffectiveDate(rs.getDate("EffectiveDate"));
            customerOfferProfile.setIsSynchronized(rs.getString("IsSynchronized"));
            profileList.add(customerOfferProfile);

        }

        return profileList;
    }

}
