package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
    @Before(value = "execution(*  com.example.demo.EmployeeService.*(..)) and args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, Integer empId) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Creating Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(*  com.example.demo.EmployeeService.*(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, Integer empId) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("----------Print----arg ----list");
        for (Object o :
                joinPoint.getArgs()) {
            System.out.println(o);
        }
        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }

    @Pointcut("execution(public *  com.example.demo.*.*(..)) && args(req,..)")
    private void anyPublicOperation(Employee req) {
        System.out.println("any public -----");
    }

    @Before("anyPublicOperation(req)")
    public void validateAccount(Employee req) {
        System.out.println(req);
        System.out.println("run before any public -----");
    }
}
