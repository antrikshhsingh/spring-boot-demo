package com.antriksh.employeeservice.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.antriksh.employeeservice.controller.*.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        log.info("Method executed: " + joinPoint.getSignature());
    }
}
