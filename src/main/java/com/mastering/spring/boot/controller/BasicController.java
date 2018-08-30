package com.mastering.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mastering.spring.boot.bean.WelcomeBean;

@RestController
public class BasicController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello World!";
    }
    
    @GetMapping("/welcome-with-object")
    public WelcomeBean welcomeWithObject() {
        return new WelcomeBean("Hello World!");
    }
    
    @GetMapping("/welcome-with-object/name/{name}")
    public WelcomeBean welcomeWithObjectAndPathVariableName(@PathVariable String name) {
        return new WelcomeBean(name);
    }
}
