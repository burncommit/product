package com.example.product.aspect;

import com.example.product.exception.NoSearchProductException;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //    @Before("execution(* com.example.myuser.controller.Controller.get*(..))")
    @Before("execution(* com.example.myuser.controller.*.*(..))")
    public void beforeControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("@Before 메소드 : " + methodName + " 실행 ");
    }

    @Pointcut("execution(* com.example.myuser.controller.*.*(..))")
    private void controllerMethods() {}

    @After("controllerMethods()")
    public void afterControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("@After 메소드 : " + methodName + " 실행 ");
    }

    @Around("controllerMethods()")
    public Object aroundControllerMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before executing " + methodName);

        try {
            // 메서드 실행
            Object result = joinPoint.proceed();
            logger.info("After executing " + methodName);
            return result;
        } catch (NoSearchProductException ex) {
            // 원하는 예외를 발생시킬 때 로깅하거나 다시 던질 수 있습니다.
            logger.error("Exception in method " + methodName + ": " + ex.getMessage());
            throw ex; // 예외를 다시 던짐
        }
    }

    @AfterThrowing(pointcut = "execution(* com.example.myuser.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Exception in method " + methodName + ": " + ex.getMessage());
    }
}