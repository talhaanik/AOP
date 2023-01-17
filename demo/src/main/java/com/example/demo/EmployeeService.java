package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public Employee createEmployee(String name, Integer empId) {

        Employee emp = new Employee();
        emp.setName(name);
        emp.setId(empId);
        return emp;
    }

    public void deleteEmployee(Integer empId) {

    }
}
