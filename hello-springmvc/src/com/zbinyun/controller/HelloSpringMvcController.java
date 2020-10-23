package com.zbinyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringMvcController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
