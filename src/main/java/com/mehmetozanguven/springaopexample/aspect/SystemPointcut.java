package com.mehmetozanguven.springaopexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcut {

    @Pointcut("within(com.mehmetozanguven.springaopexample.controller..*)")
    public void controllerLayer() {}

    @Pointcut("within(com.mehmetozanguven.springaopexample.service..*)")
    public void serviceLayer() {}

    @Pointcut("within(com.mehmetozanguven.springaopexample.repository..*)")
    public void repositoryLayer() {}
}
