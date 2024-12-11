package tn.esprit.springprojet1.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Slf4j
public class AOPConfig {
    @Before("execution(* tn.esprit.springprojet1.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* tn.esprit.springprojet1.services.*.*(..))")
    public void logMethodAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterReturning("execution(public void tn.esprit.springprojet1.services.*.*(..))")
    public void tresbien(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Treés bien !");
    }

}
