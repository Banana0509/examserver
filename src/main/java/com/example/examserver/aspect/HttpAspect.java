package com.example.examserver.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//import java.util.logging.Logger;

/**
 * http统一记录拦截 AOP
 */
@Aspect
@Component
public class HttpAspect {

    private final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    /**
     * 拦截girlList函数 @Before("execution(public * com.example.examserver.controller.GirlController.girlList(..))")
     */
    @Pointcut("execution(public * com.example.examserver.controller.GirlController.*(..))")
    public void log(){
       // System.out.println(111111);
    }

    /**
     * 拦截GirlController所有函数
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
       // System.out.println("logAll GirlController");
        logger.info("doBefore");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //class method
        logger.info("class method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //params
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()") //重用log的拦截条件
    public void doAfter(){
        logger.info("doAfter");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        //logger.info("response={}",object.toString());
    }
}
