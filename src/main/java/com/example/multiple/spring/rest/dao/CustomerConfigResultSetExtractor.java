package com.example.multiple.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.multiple.spring.rest.types.CustomerDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class CustomerConfigResultSetExtractor implements ResultSetExtractor<List<CustomerDetails>> {

    public List<CustomerDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<CustomerDetails> empDetailList = new ArrayList<CustomerDetails>();

        while (rs.next()) {

            CustomerDetails empDetails = new CustomerDetails();
            empDetails.setId(rs.getInt("ID"));
            empDetails.setFirstName(rs.getString("FirstName"));
            empDetails.setLastName(rs.getString("LastName"));
            empDetails.setAddress(rs.getString("Address"));
            empDetails.setCity(rs.getString("City"));
            empDetailList.add(empDetails);
        }

        return empDetailList;
    }

}
