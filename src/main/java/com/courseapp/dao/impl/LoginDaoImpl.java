package com.courseapp.dao.impl;

import com.courseapp.dao.LoginDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDaoImpl implements LoginDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
