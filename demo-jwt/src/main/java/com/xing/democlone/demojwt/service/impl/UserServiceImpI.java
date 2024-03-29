package com.xing.democlone.demojwt.service.impl;


import com.xing.democlone.demojwt.dao.UserDao;
import com.xing.democlone.demojwt.entity.User;
import com.xing.democlone.demojwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpI implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User userdb = userDao.login(user);
        if (userdb != null) {
            Map<String, String> map = new HashMap<>();
            map.put("name", userdb.getUsername());
            return userdb;
        }
        throw new RuntimeException("登录失败");
    }
}
