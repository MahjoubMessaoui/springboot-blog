package com.mahjoubhamza.springboot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * mim
 * 08/08/2019
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }
}
