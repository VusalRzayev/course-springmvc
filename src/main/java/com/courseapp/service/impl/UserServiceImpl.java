package com.courseapp.service.impl;

import com.courseapp.dao.UserDao;
import com.courseapp.model.User;
import com.courseapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String username, String password) {
        return userDao.getUser(username,password);
    }
}
