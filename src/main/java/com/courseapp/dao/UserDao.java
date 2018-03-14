package com.courseapp.dao;

import com.courseapp.model.User;

public interface UserDao {

    public User getUser(String username,String password);

}
