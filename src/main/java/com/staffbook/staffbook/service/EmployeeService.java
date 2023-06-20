package com.staffbook.staffbook.service;

import com.staffbook.staffbook.model.Employee;

import java.util.Map;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

//    Employee addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName, Integer salary, Integer department);

    Map<String, Employee> getAllEmployees();


}
