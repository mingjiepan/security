package com.mjie.security.web.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author panmingjie
 * @date 2018/10/25 20:48
 */
@Controller
@Slf4j
public class LoginController {

    /**
     * 返回登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录成功执行方法
     * @return
     */
    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(principal + "登录成功");
        return "index";
    }

    @GetMapping("/loginFailure")
    public String loginFail() {
        log.info("登录失败");
        return "error";
    }
}
