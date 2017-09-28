package com.whl.aspect;

/**
 * @Author: Whling
 * @Date: Created in 16:56 2016/12/31
 * @Modified By:
 * @Description:
 */

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: Whling
 * @Date: Created in 21:16 2016/12/26
 * @Modified By:
 * @Description:
 */
@Component
@Aspect  //指定当前类为切面类
public class Aop {
    //public void start(){
    //    System.out.println("事务前");
    //}
    //public void end(){
    //    System.out.println("事务后");
    //}

    //通过spring的aop来实现功能扩展
    // 指定切入点表单式： 拦截哪些方法； 即为哪些类生成代理对象
    @Pointcut("execution(* com.whl.service..*.*(..))")
    public void point(){}

    @Before("point()")
    public void start(){
        System.out.println("日志处理：获取******");
    }

    @After("point()")
    public void end(){
        System.out.println("日志处理：写入*******");
    }
    @AfterThrowing("point()")
    public void afterThrowing(){
        System.out.println("异常处理");
    }
    @AfterReturning("point()")
    public void afterReturning(){
        System.out.println("返回结果");
    }
    //@Around("point()")
    //public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    //    System.out.println("环绕前");
    //    proceedingJoinPoint.proceed();
    //    System.out.println("环绕后");
    //}
}
