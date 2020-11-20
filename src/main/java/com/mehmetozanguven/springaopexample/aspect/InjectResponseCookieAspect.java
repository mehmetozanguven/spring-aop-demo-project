package com.mehmetozanguven.springaopexample.aspect;

import com.mehmetozanguven.springaopexample.annotation.InjectResponseCookie;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;

@Aspect
@Component
public class InjectResponseCookieAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(InjectResponseCookieAspect.class);

    @After(value = "com.mehmetozanguven.springaopexample.aspect.SystemPointcut.controllerLayer() && " +
            "@annotation(injectResponseCookie)")
    public void injectResponseCookie(InjectResponseCookie injectResponseCookie){
        HttpServletResponse response = getResponse();
        Cookie cookie = new Cookie(generateRandomCookieName(), injectResponseCookie.cookieValue());
        response.addCookie(cookie);
        LOGGER.info("Annotation value: {}", injectResponseCookie.cookieValue());
    }

    private HttpServletResponse getResponse(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        return ((ServletRequestAttributes)requestAttributes).getResponse();
    }

    private String generateRandomCookieName(){
        return RandomStringUtils.randomAlphabetic(6);
    }
}
