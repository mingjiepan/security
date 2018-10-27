package com.mjie.security.web.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.event.AuthenticationFailureServiceExceptionEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    /**
     * 登录成功执行方法
     * @return
     */
    @PostMapping("/loginSuccess")
    public String loginSuccess() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(principal + "登录成功");
        return "index";
    }

    @PostMapping("/loginFailure")
    public String loginFailure() {
        log.info("登录失败");
        return "redirect:/login";
    }
}
