package com.lhc.sneakers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
    @GetMapping(value="/login")
    public String login(){
        return "login/index";
    }
    @GetMapping(value="/register")
    public String register(){
        return "login/reg";
    }

    @GetMapping(value = "/admin")
    public String admin(){
        return "admin/index";
    }



}
