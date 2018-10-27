package com.mjie.security.web.common.service.impl;

import com.mjie.security.web.common.entities.MyUser;
import com.mjie.security.web.common.mapper.UserMapper;
import com.mjie.security.web.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author panmingjie
 * @date 2018/10/25 20:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public MyUser getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public MyUser getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
