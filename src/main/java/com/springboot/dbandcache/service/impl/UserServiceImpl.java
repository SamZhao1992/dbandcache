package com.springboot.dbandcache.service.impl;

import com.springboot.dbandcache.dao.UserDao;
import com.springboot.dbandcache.model.User;
import com.springboot.dbandcache.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(long id){
        return userDao.selectByPrimaryKey(id);
    }
}
