package com.example.multiple.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.multiple.spring.rest.types.MarketConfiguration;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class MarketConfigResultSetExtractor implements ResultSetExtractor<List<MarketConfiguration>> {

    private static final Logger LOG = LoggerFactory.getLogger(MarketConfigResultSetExtractor.class);

    @Override
    public List<MarketConfiguration> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<MarketConfiguration> configList = new ArrayList<MarketConfiguration>();

        while (rs.next()) {

            if (rs.getString("MarketId") != null) {

                MarketConfiguration marketConfiguration = new MarketConfiguration();
                marketConfiguration.setMarketId(Long.parseLong(rs.getString("MarketId")));
                marketConfiguration.setTermTextId(rs.getLong("TermTextId"));

                marketConfiguration.setCorpCd(rs.getString("CorpCd"));
                marketConfiguration.setMyAgt(rs.getString("MyAgt"));
                marketConfiguration.setMrktName(rs.getString("MrktName"));
                marketConfiguration.setTermTextTitle(rs.getString("TermTextTitle"));
                marketConfiguration.setDescription(rs.getString("Description"));
                marketConfiguration.setAccountNumber(rs.getString("AccountNumber"));
                marketConfiguration.setCustomerId(rs.getString("CustomerId"));
                marketConfiguration.setCustomerStatus(rs.getString("CustomerStatus"));

             // Will be useful when we have to set the Calendar type
                
/*              DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String trmTxtBeginDt = rs.getString("ActiveStartDate");
                String trmTxtEndDt = rs.getString("ActiveEndDate"); */

                marketConfiguration.setActiveBeginDate(rs.getDate("ActiveStartDate"));
                marketConfiguration.setActiveEndDate(rs.getDate("ActiveEndDate"));

                // we can use the rs.getTimestamp("LAST_UPDATED_TS")

/*              try {
                if (trmTxtBeginDt != null && !"".equalsIgnoreCase(trmTxtBeginDt.trim())) {
                    marketConfiguration.setActiveBeginDate(dateToCalendar((Date) formatter.parse(trmTxtBeginDt)));
                }
                if (trmTxtEndDt != null && !"".equalsIgnoreCase(trmTxtEndDt.trim())) {
                    marketConfiguration.setActiveEndDate(dateToCalendar((Date) formatter.parse(trmTxtEndDt)));
                }
            } catch (ParseException e) {
                LOG.info("ParseException in extractData : " + e.getMessage());
            }*/


                if ("Y".equalsIgnoreCase(rs.getString("ActiveFlag"))) {
                    marketConfiguration.setActive(true);
                } else {
                    marketConfiguration.setActive(false);
                }

                marketConfiguration.setVersion(rs.getDouble("Version"));
                LOG.info("Printing the response.........");
                configList.add(marketConfiguration);
            }
        }

        return configList;
    }

/*  private Calendar dateToCalendar(Date date) {
  
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
} */
 
    
// For Convert String value to Calendar
    
/*  private Calendar getCalendar(Date date) {
  
    Calendar calendar = Calendar.getInstance();
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    format.format(date);
    calendar = format.getCalendar();
    return calendar;
} */


}