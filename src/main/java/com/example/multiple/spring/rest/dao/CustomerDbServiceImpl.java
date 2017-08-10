package com.example.multiple.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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
import com.example.multiple.spring.rest.util.DataEncryptor;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@Repository("CustomerDbServiceImpl")
public class CustomerDbServiceImpl implements CustomerDbService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDbServiceImpl.class);

    private static final String OBJECT_DOES_NOT_EXIST_EXCEPTION_MESSAGE = "No vendor with the specified characteristics exists";

    @Autowired
    private CsDatabaseConnector csDatabaseConnector;

    @Autowired
    private DataEncryptor dataEncryptor;

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    /**
     * The character value for <code>false</code>.
     */
    protected static final String NO = "N";

    /**
     * The character value for <code>true</code>.
     */
    protected static final String YES = "Y";

    public CsDatabaseConnector getCsDatabaseConnector() {
        return csDatabaseConnector;
    }

    public void setCsDatabaseConnector(CsDatabaseConnector csDatabaseConnector) {
        this.csDatabaseConnector = csDatabaseConnector;
    }

    public DataEncryptor getDataEncryptor() {
        return dataEncryptor;
    }

    public void setDataEncryptor(DataEncryptor dataEncryptor) {
        this.dataEncryptor = dataEncryptor;
    }

    @Override
    public CustomerDetails queryCustConfigs(CustomerConfigIdentifier id) {

        List<CustomerDetails> configList = new ArrayList<CustomerDetails>();
        List<Integer> args = new ArrayList<Integer>();
        args.add(id.getId());

        String query = "select * from customer where id = ?";

        try {
            configList = csDatabaseConnector.getJdbcTemplate().query(query, args.toArray(),
                    new CustomerConfigResultSetExtractor());
            LOG.debug(" Query for queryCustConfigs : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting customer configurations  ", e);
        }

        if (!configList.isEmpty()) {

            return configList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public String queryNameCustomer(CustomerConfigIdentifier id) {

        String query = "SELECT FIRSTNAME FROM CUSTOMER WHERE ID = ?";

        String name = csDatabaseConnector.getJdbcTemplate().queryForObject(query, new Object[] { id.getId() },
                String.class);

        return name;

    }

    @Override
    public Integer queryRow() {

        String sql = "SELECT COUNT(*) FROM CUSTOMER";

        int count = csDatabaseConnector.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public boolean isUserExist(String custName) {

        String sql = "SELECT count(*) FROM CUSTOMER WHERE FIRSTNAME = ?";
        boolean result = false;

        int count = csDatabaseConnector.getJdbcTemplate().queryForObject(sql, new Object[] { custName }, Integer.class);

        if (count > 0) {
            result = true;
        }

        return result;
    }

    @Override
    public CustomerAddressDetails queryCustAddress(String custName) {

        String QUERY_BY_ADDRESS = "select firstName, Address from customer where firstName = ?";
        Object params[] = { custName };

        return csDatabaseConnector.getJdbcTemplate().query(QUERY_BY_ADDRESS, params,
                new ResultSetExtractor<CustomerAddressDetails>() {
                    @Override
                    public CustomerAddressDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
                        CustomerAddressDetails customerDetails = null;
                        while (rs.next()) {
                            customerDetails = new CustomerAddressDetails();
                            customerDetails.setFirstName(rs.getString("FirstName"));
                            customerDetails.setAddress(rs.getString("Address"));
                        }
                        return customerDetails;
                    }
                });
    }

    @Override
    public List<CustomerAddressDetails> queryCommonCustomerLocation(String location) {

        String QUERY_BY_ADDRESS_COMMON = "select firstName, Address from customer where Address = ?";

        return csDatabaseConnector.getJdbcTemplate().query(QUERY_BY_ADDRESS_COMMON, new Object[] { location },
                new ResultSetExtractor<List<CustomerAddressDetails>>() {
                    @Override
                    public List<CustomerAddressDetails> extractData(ResultSet rs) {
                        List<CustomerAddressDetails> operatorList = new ArrayList<CustomerAddressDetails>();
                        try {
                            while (rs.next()) {
                                CustomerAddressDetails operator = new CustomerAddressDetails();
                                operator.setFirstName(rs.getString("FirstName"));
                                operator.setAddress(rs.getString("Address"));
                                operatorList.add(operator);
                            }
                        } catch (EmptyResultDataAccessException e) {
                            LOG.info("Empty data for location for corp #" + location, e);
                            return null;
                        } catch (Exception e) {
                            LOG.warn("Error while calling mysql db for Operator for corp #" + location, e);
                            return null;
                        }
                        return operatorList;
                    }
                });

    }

    @Override
    public String queryCustEmail(String firstName) {

        String QUERY_BY_EMAIL = "select Email from customerEmail where FirstName = ?";

        return csDatabaseConnector.getJdbcTemplate().query(QUERY_BY_EMAIL, new Object[] { firstName },
                new ResultSetExtractor<String>() {
                    @Override
                    public String extractData(ResultSet rs) {
                        String operator = null;
                        try {
                            while (rs.next()) {
                                operator = rs.getString("Email");
                            }
                        } catch (EmptyResultDataAccessException e) {
                            LOG.info("Empty data for Operator for Email #" + firstName, e);
                            return null;
                        } catch (Exception e) {
                            LOG.warn("Error while calling oracle db for Operator for Email #" + firstName, e);
                            return null;
                        }
                        return operator;
                    }
                });

    }

    @Override
    public ItemConfiguration getItemConfiguration(ItemConfigurationIdentifier itemConfigurationIdentifier) {

        List<ItemConfiguration> configs = new ArrayList<ItemConfiguration>();
        List<String> args = new ArrayList<String>();
        args.add(dataEncryptor.decode(itemConfigurationIdentifier.getItemId()));

        String query = "select * from item where ItemID = ?";
        try {
            configs = csDatabaseConnector.getJdbcTemplate().query(query, args.toArray(),
                    new ItemConfigResultSetExtractor());
            LOG.debug(" Query for getItemConfiguration : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting item configurations  ", e);
        }

        if (!configs.isEmpty()) {
            return configs.get(0);
        } else {
            return null;
        }
    }

    @Override
    public MarketConfiguration getMarketConfiguration(MarketConfigurationIdentifier marketConfigurationIdentifier) {

        List<MarketConfiguration> configs = new ArrayList<MarketConfiguration>();
        List<Long> args = new ArrayList<Long>();
        args.add(marketConfigurationIdentifier.getMarketId());

        String query = "select * from market where MarketId = ?";
        try {
            configs = csDatabaseConnector.getJdbcTemplate().query(query, args.toArray(),
                    new MarketConfigResultSetExtractor());
            LOG.debug(" Query for getMarketConfiguration : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting market configurations  ", e);
        }

        if (!configs.isEmpty()) {
            return configs.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<MarketConfiguration> getEffectiveMarketByDate(MarketEffectiveConfig marketEff, boolean active) {

        List<MarketConfiguration> configs = new ArrayList<MarketConfiguration>();

        String query = "select * from Market where ActiveFlag = ? AND ActiveStartDate = ? ";

        try {
            configs = csDatabaseConnector.getJdbcTemplate().query(query,
                    new Object[] { this.booleanToYesNo(active), marketEff.getEffectiveDate() },
                    new MarketConfigResultSetExtractor());

            LOG.debug(" Query for getMarketConfiguration : " + query);

        } catch (Exception e) {
            LOG.error("Exception while getting market configurations  ", e);
        }

        if (!configs.isEmpty()) {
            return configs;
        } else {
            return null;
        }

    }

    @Override
    public VendorDetails getVendorConfiguration(VendorConfig vendorConfig) {

        Map<String, VendorDetails> headEndMap = new HashMap<>();

        String query = "select VendorID, VendorName, VendorCode, VendorType, VendorValue from Vendor";

        if (headEndMap.isEmpty()) {
            headEndMap = csDatabaseConnector.getJdbcTemplate().query(query.toString(), new VendorResultSetExtractor());
        }

        if (!headEndMap.containsKey(vendorConfig.getVendorID())) {
            throw new DataRetrievalFailureException(OBJECT_DOES_NOT_EXIST_EXCEPTION_MESSAGE);
        }

        return headEndMap.get(vendorConfig.getVendorID());

    }

    @Override
    public CustomerHDetails queryCustConfigsHibernate(int id) {
        CustomerHDetails customerHDetails = null;
        if (StringUtils.isEmpty(session) || !session.isOpen()) {
            session = getSession();
        }
        customerHDetails = (CustomerHDetails) session.get(CustomerHDetails.class, id);

        return customerHDetails;
    }

    @Override
    public List<CustomerOfferProfile> queryCustomerOffer(CustomerOfferIdentifier customerOfferIdentifier) {

        List<CustomerOfferProfile> configs = new ArrayList<CustomerOfferProfile>();

        String query = "select CustomerOfferID, OfferNumber, CustomerID, EffectiveDate, IsSynchronized from Offer";

        try {
            configs = csDatabaseConnector.getJdbcTemplate().query(query, new CustomerOfferProfileResultSetExtractor());

            LOG.debug(" Query for queryCustomerOffer : " + query);

        } catch (Exception e) {
            LOG.error("Exception while getting offer configurations  ", e);
        }

        if (!configs.isEmpty()) {
            return configs;
        } else {
            return null;
        }

    }

    private String booleanToYesNo(boolean value) {
        String yesNo = YES;

        if (value) {
            yesNo = YES;
        } else {
            yesNo = NO;
        }

        return yesNo;
    }

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

}