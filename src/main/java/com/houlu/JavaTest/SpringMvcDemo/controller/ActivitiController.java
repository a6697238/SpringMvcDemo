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
@RequestMapping("/activiti")
public class ActivitiController {

    @RequestMapping("/show")
    public String userLogin(){
        System.out.println("ACTIVITI SHOW");
        return "process-editor/modeler";
    }



}
