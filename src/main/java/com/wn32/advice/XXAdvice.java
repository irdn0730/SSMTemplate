package com.wn32.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class XXAdvice {
    @Pointcut(value = "execution(public * com.wn32.service.*.*(..))")
    public void point1(){
        System.out.println("被增强了");//仅仅是个切点，并不输出
    }
    @Before(value = "point1()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"前置增强了");
    }
}
