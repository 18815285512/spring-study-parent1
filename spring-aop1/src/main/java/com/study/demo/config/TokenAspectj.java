package com.study.demo.config;

import com.study.demo.annotation.ExtApiToken;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
@Aspect
public class TokenAspectj {

    @Autowired
    private SessionTokenUtil sessionTokenUtil;

    @Pointcut("execution(* com.study.demo.*.*(..))")
    private void extApiPointCut(){

    }

    @Pointcut("@annotation(com.study.demo.annotation.ExtApiToken)")
    private void extApiTokenPointCut(){

    }

    @Before("extApiTokenPointCut()")
    private void doBefore(JoinPoint joinPoint){

        ExtApiToken extApiToken = joinPoint.getSignature().getClass().getDeclaredAnnotation(ExtApiToken.class);

        if (extApiToken!=null) {
            extApiToken();
        }
    }

    private void extApiToken() {

    }
}
