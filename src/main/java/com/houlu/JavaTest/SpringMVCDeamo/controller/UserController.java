package com.houlu.JavaTest.SpringMVCDeamo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类名称: UserController <br>
 * 类描述: <br>
 *
 * @author lu.hou
 * @version 1.0.0
 * @since 16/10/6 上午10:37
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest servletRequest;

    @RequestMapping("/userLogin")
    public String userLogin(ModelMap modelMap, @RequestParam(value = "username")String username, @RequestParam(value = "password")String password){
        System.out.println("用户名是:"+username);
        System.out.println("密码是:"+password);
        modelMap.addAttribute("ip",servletRequest.getRemoteAddr());
        return "test";
    }
}
