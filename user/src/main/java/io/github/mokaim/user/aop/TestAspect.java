package io.github.mokaim.user.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

  @Pointcut("execution(* io.github.mokaim.user.web.AuthController.hello(..))")
  public void pointCut(){ }

  @Around("pointCut()")
  public Object beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println(
            Arrays.toString(joinPoint.getArgs())
    );



    Object proceed = joinPoint.proceed();
    System.out.println(
       proceed.getClass()
    );

    return joinPoint.proceed();
  }
}
