package com.example.service;

import com.example.dao.UserDao;

public class UserServiceImpl implements UserService {

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;
    @Override
    public void query() {
       // System.out.println(this.getClass().getSimpleName());
        userDao.query();
    }

}
