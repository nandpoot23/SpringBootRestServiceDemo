package com.example.multiple.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.multiple.spring.rest.types.ItemConfiguration;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class ItemConfigResultSetExtractor implements ResultSetExtractor<List<ItemConfiguration>> {

    public List<ItemConfiguration> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<ItemConfiguration> itemConfigList = new ArrayList<ItemConfiguration>();

        while (rs.next()) {

            ItemConfiguration itemConfiguration = new ItemConfiguration();
            itemConfiguration.setItemID(rs.getString("ItemID"));
            itemConfiguration.setItemName(rs.getString("ItemName"));
            itemConfiguration.setItemCode(rs.getString("ItemCode"));
            itemConfiguration.setItemType(rs.getString("ItemType"));
            itemConfiguration.setItemValue(rs.getString("ItemValue"));
            itemConfigList.add(itemConfiguration);
        }

        return itemConfigList;
    }

}
