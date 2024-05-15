package com.example.emsbackendservice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(com.example.emsbackendservice.service..*)")
    public void timeCapturingMethods() {
    }
    
     @Pointcut("within(com.example.emsbackendservice..*)")
    public void loggableMethods() {}

    @Around("timeCapturingMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        logger.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }

    @Before("loggableMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        logger.info("Entering method: {}", joinPoint.getSignature());
    }

    @After("loggableMethods()")
    public void logMethodExit(JoinPoint joinPoint) {
        logger.info("Exiting method: {}", joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "loggableMethods()", throwing = "exception")
    public void logMethodException(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: {} with cause = '{}'", joinPoint.getSignature(), exception.getCause() != null ? exception.getCause() : "NULL");
    }
}
