package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
	  private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	 //comment before 0
	 @Before("execution(* com.example.demo.services.*.*(..))")
	    public void logBeforeExecution() {
		 logger.info("Method execution started...");
	    }

	    @After("execution(* com.example.demo.services.*.*(..))")
	    public void logAfter(JoinPoint joinPoint) {
	        String methodName = joinPoint.getSignature().getName();
	        String className = joinPoint.getTarget().getClass().getSimpleName();
	        logger.info("Méthode {} de la classe {} exécutée avec succès.", methodName, className);
	    }
}
