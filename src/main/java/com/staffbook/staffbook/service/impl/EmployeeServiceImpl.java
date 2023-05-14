package com.staffbook.staffbook.service.impl;

import com.staffbook.staffbook.exepetions.EmployeeAlreadyAddedException;
import com.staffbook.staffbook.exepetions.EmployeeNotFoundException;
import com.staffbook.staffbook.exepetions.EmployeeStorageIsFullException;
import com.staffbook.staffbook.model.Employee;
import com.staffbook.staffbook.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE = 10;

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище сотрудников переполнено!");
        }
        employees.put(
                employeeKey,
                new Employee(firstName, lastName)
        );
        return employees.get(employeeKey);
    }


    @Override
    public void removeEmployee(String firstName, String lastName) {

        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Нет такого сотрудника!");
        }
        employees.remove(employeeKey);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        String employeeKey = getEmployeeKey(firstName, lastName);

        employees.containsKey(employeeKey);

        return employees.get(employeeKey);

    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }
}
