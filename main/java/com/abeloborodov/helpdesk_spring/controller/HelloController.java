package com.abeloborodov.helpdesk_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello HelpDeeeeesk!";
    }

    @GetMapping("/about")
    public String about() {
        return "My first Spring project";
    }

}
