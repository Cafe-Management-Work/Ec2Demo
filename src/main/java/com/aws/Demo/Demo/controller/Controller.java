package com.aws.Demo.Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {

    @GetMapping("/welcome")
    public String getMessage(){
        return "Hello Welcome to AWS CI&CD pipeline..";
    }
}
