package com.mjie.security.web.common.service;

import com.mjie.security.web.common.entities.MyUser;

/**
 * @author panmingjie
 * @date 2018/10/25 20:48
 */
public interface UserService {
    MyUser getUser(int id);

    MyUser getUserByName(String name);
}
