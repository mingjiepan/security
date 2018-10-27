package com.mjie.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author panmingjie
 * @date 2018/10/27 08:42
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String contextPath = httpServletRequest.getContextPath();
        System.out.println("登录成功");
        httpServletResponse.sendRedirect(contextPath + "/loginSuccess");
    }
}
