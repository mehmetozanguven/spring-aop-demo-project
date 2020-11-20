package com.mehmetozanguven.springaopexample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryAspect.class);

    @Around("@annotation(com.mehmetozanguven.springaopexample.annotation.Retry)")
    public Object retryTheExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try{
            return proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            LOGGER.error("Error when calling method: {}, retrying again...", proceedingJoinPoint.getSignature().getName());
            return proceedingJoinPoint.proceed();
        }
    }
}
