package com.houlu.JavaTest.SpringMvcDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/userUpload")
    public String userUpload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap modelMap) {
        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        modelMap.addAttribute("ip",servletRequest.getRemoteAddr());
        return "test";
    }

}
