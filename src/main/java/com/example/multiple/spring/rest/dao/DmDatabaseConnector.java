package com.example.multiple.spring.rest.dao;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public class DmDatabaseConnector {

    private JdbcOperations jdbcTemplate;

    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
