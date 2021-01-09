package com.wn32.controller;

import com.wn32.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("login")
    public String userLogin(User user){

        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPwd());
            try{
            subject.login(token);
                return "index";
            }catch (AuthenticationException e){
                System.out.println(e.getMessage());
            }

        }
        return "redirect:/login.html";
    }
}
