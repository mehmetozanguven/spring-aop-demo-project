package com.mehmetozanguven.springaopexample.controller;

import com.mehmetozanguven.springaopexample.annotation.InjectResponseCookie;
import com.mehmetozanguven.springaopexample.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @InjectResponseCookie(cookieValue = "injectResponseCookie")
    @GetMapping("/customer-by-id/{id}")
    public String findCustomerById(HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        customerService.findCustomerById(Long.parseLong(id));
        logAllCookies(request);
        return "customer-by-id-" + id;
    }

    private void logAllCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Arrays.stream(cookies).forEach(cookie -> LOGGER.info("Cookie name: {}, cookie value: {}", cookie.getName(), cookie.getValue()) );
    }


    @GetMapping("/tricky")
    public String callTrickyDirectly(){
        customerService.callTrickyMethodDirectly();
        return "direct call";
    }

    @GetMapping("/tricky-in")
    public String callTrickyInDirectly(){
        customerService.callingTrickyMethodInDirectly();
        return "indirect call";
    }
}
