package com.example.SpringsecurityWork.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Auth {
    @GetMapping()
    public String returnname(){
        return "Hello";
    }
}
