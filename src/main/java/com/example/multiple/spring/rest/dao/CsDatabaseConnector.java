package com.example.multiple.spring.rest.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class CsDatabaseConnector {

    private JdbcOperations jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
