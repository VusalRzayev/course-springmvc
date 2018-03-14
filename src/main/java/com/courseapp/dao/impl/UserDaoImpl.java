package com.courseapp.dao.impl;

import com.courseapp.dao.UserDao;
import com.courseapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUser(String username, String password) {
        String sql="select * from user where username=? and password=?";
        List<User> users = jdbcTemplate.query(sql,new Object[]{username,"123"}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return users.get(0);
    }
}
