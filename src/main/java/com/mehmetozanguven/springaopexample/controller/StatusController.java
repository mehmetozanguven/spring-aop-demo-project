package com.mehmetozanguven.springaopexample.controller;

import com.mehmetozanguven.springaopexample.annotation.Retry;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {
    private static Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Retry
    @GetMapping("/status")
    public String getApplicationStatus(){
        int randomNumber = getRandomNumber();
        LOGGER.info("Status controller with randomNumber: {}", randomNumber);
        if (randomNumber % 2 != 0){
            throw new RuntimeException("Dummy exception to test retry");
        }
        return "application-is-working";
    }

    private int getRandomNumber(){
        return RandomUtils.nextInt(0, 10);
    }
}
