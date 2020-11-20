package com.mehmetozanguven.springaopexample.controller;

import com.mehmetozanguven.springaopexample.request.LoginRequest;
import com.mehmetozanguven.springaopexample.service.LoginService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String loginCustomer(LoginRequest loginRequest){

        loginService.loginCustomer(loginRequest);
        return "login-request";
    }


}
