package com.study.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspectj {

    /**
     * 切点  是连接点的集合   joinPoint
     *
     * execution 连接点粒度到方法
     */
    @Pointcut("execution( * com.study.demo.dao.*.*(..))") // the pointcut expression
    private void pointCut() {} // the pointcut signature

    /**
     * within 连接点粒度到类
     */
    @Pointcut("within(com.study.demo.dao.IndexDao)") // the pointcut expression
    private void pointCutWithin() {} // the pointcut signature

    /**
     * 还可以多个切点组合起来
     */
    @Pointcut("pointCut() && pointCutWithin()")
    private void tradingOperation() {}


    /**
     * within(com.study.demo.dao.*)  切到dao包下的indexDao类
     * within(com.study.demo.dao.*)  切到dao包下类
     * within(com.study.demo.dao..*) 切到dao包下类以及dao层任意子包下类
     */
    @Pointcut("within(com.study.demo.dao.*)")
    public void inDataAccessLayer() {}

    /**
     * args(java.lang.String) 匹配方法形参有且只有一个是String的
     * args(java.lang.String，java.lang.Integer) 匹配形参第一个是String，第二个是Integer的
     */
    @Pointcut("args(java.lang.String)")
    public void pointCutArgs(){}

    /**
     * this 是指当前对象也称代理对象
     * 该切点是指横切代理对象等于com.study.demo.dao.Dao的类中所有方法
     */
    @Pointcut("this(com.study.demo.dao.Dao)")
    public void pointCutThis(){
    }

    /**
     * target 是指目标对象也是被代理对象
     * 该切点是指横切目标对象等于com.study.demo.dao.IndexDao的类中所有方法
     */
    @Pointcut("target(com.study.demo.dao.IndexDao)")
    public void pointCutTarget(){
    }

    /**
     * 横切方法上的注解  只要是方法上标注注解该注解就会被横切
     */
    @Pointcut("@annotation(com.study.demo.annotation.PengChen)")
    public void pointCutAnnotation(){
    }

    /**
     * 匹配目标对象类上有该注解的  只要是目标对象类上标注注解该注解就会被横切
     */
    @Pointcut("@target(com.study.demo.annotation.PengChen)")
    public void pointCutTargetAnnotation(){
    }

    /**
     * 匹配目标对象类上有该注解的  只要是目标对象类上标注注解该注解就会被横切
     */
    @Pointcut("@within(com.study.demo.annotation.PengChen)")
    public void pointCutWithinAnnotation(){
    }

    /**
     * 前置通知
     */
//    @Before("execution(public void com.study.demo.dao.*.*(..))")
//    public void beforeAdvice(JoinPoint joinPoint){
//        // 通过连接点获取一些信息
//        Object[] args = joinPoint.getArgs();
//        System.out.println(Arrays.toString(args));
//        System.out.println("beforeAdvice");
//    }

    /**
     * 后置通知
     */
//    @After("pointCutThis()")
//    public void afterAdvice(){
//        System.out.println("afterAdvice");
//    }

    /**
     * 环绕通知:可以利用环绕通知的特性实现类似前置，后置，异常，最终通知的效果
     * 环绕通知如果没有返回值返回，其目标方法的返回将被丢失
     */
//    @Around("execution(public * com.study.demo.dao.subDao.*.*(..))")
//    public void aroundAdviceWithNonReturn(ProceedingJoinPoint pjp){
//        // 环绕通知执行目前方法前的代码(类似前置通知)
//        System.out.println("aroundAdvice before");
//        long endTime = 0;
//        try {
//            // 执行目标方法
//            Object result = pjp.proceed();
//            // 环绕通知执行目前方法后的代码(类似后置通知)
//            System.out.println("aroundAdvice after");
//        } catch (Throwable throwable) {
//            // （类似异常通知）
//            System.out.println("aroundAdvice exception");
//        } finally {
//            // （类似最终通知）
//            System.out.println("aroundAdvice finally");
//        }
//    }


    /**
     * 有返回值的环绕通知:实现改变返回值
     */
    @Around("execution(public String com.study.demo.dao.subDao.*.*(..))")
    public Object aroundAdviceWithReturn(ProceedingJoinPoint pjp){
        // 环绕通知执行目前方法前的代码
        System.out.println("aroundAdviceWithReturn before");
        try {
            // 执行目标方法
            Object result = pjp.proceed();
            // 环绕通知执行目前方法后的代码
            System.out.println("aroundAdviceWithReturn after");
            System.out.println("环绕通知中获取到的目标执行方法的返回值：" + result);
            return result + "" + System.currentTimeMillis();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "";
        }
    }
}
