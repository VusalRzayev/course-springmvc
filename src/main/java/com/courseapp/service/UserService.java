package com.courseapp.service;

import com.courseapp.model.User;

public interface UserService {
    public User getUser(String username, String password);
}
