package com.example.demoaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DemoaopApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(DemoaopApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		employeeService.createEmployee("anik","3009");
		employeeService.deleteEmployee("3009");
	}

}
