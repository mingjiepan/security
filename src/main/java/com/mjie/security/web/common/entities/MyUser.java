package com.mjie.security.web.common.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author panmingjie
 * @date 2018/10/25 20:39
 */
@Setter
@Getter
@ToString
public class MyUser implements Serializable {
    private int id;
    private String username;
    private String password;
}
