package com.example.multiple.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.multiple.spring.rest.types.VendorDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class VendorResultSetExtractor implements ResultSetExtractor<Map<String, VendorDetails>> {

    @Override
    public Map<String, VendorDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

        Map<String, VendorDetails> vendorMap = new HashMap<>();

        while (rs.next()) {

            VendorDetails vendorDetails = new VendorDetails();
            vendorDetails.setVendorID(rs.getString("VendorID"));
            vendorDetails.setVendorName(rs.getString("VendorName"));
            vendorDetails.setVendorCode(rs.getString("VendorCode"));
            vendorDetails.setVendorType(rs.getString("VendorType"));
            vendorDetails.setVendorValue(rs.getString("VendorValue"));
            vendorMap.put(vendorDetails.getVendorID(), vendorDetails);
        }

        return vendorMap;
    }

}
