package com.hutieugo.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/Hello")
    public String sayHello() {
        return "Hello, Welcome to the hutieugo!";
    }
    
}
