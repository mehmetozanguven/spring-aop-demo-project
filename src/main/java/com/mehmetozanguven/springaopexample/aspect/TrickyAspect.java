package com.mehmetozanguven.springaopexample.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrickyAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrickyAspect.class);


    @After("execution(* trickyMethod(..))")
    public void trickyMethodAdvice(){
        LOGGER.info("Tricky after advice called");
    }
}
