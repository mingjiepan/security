package com.mjie.security.web.common.service.impl;

import com.mjie.security.web.common.entities.MyUser;
import com.mjie.security.web.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panmingjie
 * @date 2018/10/26 21:38
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser myUser = userService.getUserByName(s);

        if (myUser != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));

            return new User(myUser.getUsername(), myUser.getPassword(), grantedAuthorities);
        }
        throw new UsernameNotFoundException("User name " + s + " not find");
    }
}
