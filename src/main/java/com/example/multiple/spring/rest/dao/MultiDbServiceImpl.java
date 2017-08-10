package com.example.multiple.spring.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.multiple.spring.rest.types.EmpConfigIdentifier;
import com.example.multiple.spring.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@Repository("MultiDbServiceImpl")
public class MultiDbServiceImpl implements MultiDbService {

    private static final Logger LOG = LoggerFactory.getLogger(MultiDbServiceImpl.class);

    @Autowired
    private DmDatabaseConnector dmDatabaseConnector;

    public DmDatabaseConnector getDmDatabaseConnector() {
        return dmDatabaseConnector;
    }

    public void setDmDatabaseConnector(DmDatabaseConnector dmDatabaseConnector) {
        this.dmDatabaseConnector = dmDatabaseConnector;
    }

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id) {

        List<EmpDetails> configList = new ArrayList<EmpDetails>();
        List<Integer> args = new ArrayList<Integer>();
        args.add(id.getId());

        String query = "select * from employee where id = ?";

        try {
            configList = dmDatabaseConnector.getJdbcTemplate().query(query, args.toArray(),
                    new EmpConfigResultSetExtractor());
            LOG.debug(" Query for queryEmpConfigs : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting emp configurations  ", e);
        }

        if (!configList.isEmpty()) {

            return configList.get(0);
        } else {
            return null;
        }
    }

}
