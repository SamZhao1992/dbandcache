package com.springboot.dbandcache.service;

import com.springboot.dbandcache.model.User;

public interface IUserService {
    User getUser(long id);
}
