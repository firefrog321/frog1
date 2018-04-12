package com.demo.controller;

import com.demo.domain.User;
import com.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Mr.Deng
 * Created on 2018/4/12 17:06
 **/
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(User user, Model model) {

        if(loginService.loginValidate(user)){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }else {
            //todo
            return "index";
        }

        return "index";
    }
}