package com.mehmetozanguven.springaopexample.service;

import com.mehmetozanguven.springaopexample.request.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Override
    public void loginCustomer(LoginRequest loginRequest) {
        // some repository operation and return login customer
    }
}
