package com.courseapp.service.impl;

import com.courseapp.dao.LoginDao;
import com.courseapp.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
