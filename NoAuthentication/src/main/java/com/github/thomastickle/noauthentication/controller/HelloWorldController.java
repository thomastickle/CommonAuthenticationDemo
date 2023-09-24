package com.github.thomastickle.noauthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "helloworld";
    }
}
