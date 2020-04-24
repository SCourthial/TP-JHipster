package com.mycompany.myapp.aop.logging;

import io.github.jhipster.config.JHipsterConstants;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import java.util.Arrays;

@Aspect
@Component
public class MailLoggingAspect {
    private final Environment env;

    public MailLoggingAspect(Environment env) {
        this.env = env;
    }

    @Pointcut("within(com.mycompany.myapp.service.MailService)")
    public void inMailService(){}

    @Pointcut("execution(public * *(..))")
    public void executeAny(){}

    @Before("inMailService() && executeAny()")
    public void logBefore(JoinPoint joinPoint) {
        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
        try {
            if (log.isDebugEnabled()){
                log.debug("EnterMail: {}() with argument[s] = {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
            }
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }
    }

    @After("inMailService() && executeAny()")
    public void logAfter(JoinPoint joinPoint) {
        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
        try {
            if (log.isDebugEnabled()){
                log.debug("ExitMail: {}()", joinPoint.getSignature().getName());
            }
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }
    }
}