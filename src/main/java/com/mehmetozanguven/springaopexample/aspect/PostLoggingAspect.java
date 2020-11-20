package com.mehmetozanguven.springaopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PostLoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostLoggingAspect.class);

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void logBeforePostMethod(JoinPoint joinPoint){
        LOGGER.info("POST method called: {}", joinPoint.getSignature());
    }
}
