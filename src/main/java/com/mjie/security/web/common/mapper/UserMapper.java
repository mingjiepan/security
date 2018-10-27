package com.mjie.security.web.common.mapper;

import com.mjie.security.web.common.entities.MyUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author panmingjie
 * @date 2018/10/25 20:38
 */
public interface UserMapper {
    MyUser getUser(@Param("id") int id);

    MyUser getUserByName(@Param("name") String name);
}
