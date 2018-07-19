package com.example.demo.ascept;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZL
 * @date
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //面向切面 AOP
    @Before("execution(public * com.example.demo.contorller.GirlContorller.girlList(..))")
    public void log() {
        System.out.println("11111111");
    }

    @After(value = "log3()")
    public void log2() {
        System.out.println("22222222");
    }

    //面向切面 AOP
    @Pointcut("execution(public * com.example.demo.contorller.GirlContorller.girlList(..))")
    public void log3() {

    }

    @Before(value = "log3()")
    public void log4(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        //url
        logger.info("url={}", httpServletRequest.getRequestURL());
        //方法
        logger.info("method={}", httpServletRequest.getMethod());
        //ip
        logger.info("ip={}", httpServletRequest.getRemoteAddr());
        //参数 不要设置为localhost的这种
        logger.info("ip={}", httpServletRequest.getLocalAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log3()")
    public void log5() {
        logger.info("22");

    }
    @AfterReturning(pointcut="log3()",returning = "object")
    public void log6(Object object) {
      logger.info("response={}",object.toString());

    }

}
