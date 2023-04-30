package com.staffbook.staffbook.service.impl;

import com.staffbook.staffbook.exepetions.EmployeeAlreadyAddedException;
import com.staffbook.staffbook.exepetions.EmployeeNotFoundException;
import com.staffbook.staffbook.exepetions.EmployeeStorageIsFullException;
import com.staffbook.staffbook.model.Employee;
import com.staffbook.staffbook.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE = 10;
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivanov", "Ivan"),
            new Employee("Markov", "Andrey"),
            new Employee("Petrov", "Pjotr"),
            new Employee("Salikhov", "Timur"),
            new Employee("Goncharov", "Ivan"),
            new Employee("Chekhov", "Anton"),
            new Employee("Zolotkova", "Alisa"),
            new Employee("Salikhov", "Rodion"),
            new Employee("Nikitina", "Pavla")

    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище сотрудников переполнено!");
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException("Нет такого сотрудника!");
        }
        employees.remove(employee);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException("Нет такого сотрудника!");
        }
        for (Employee value : employees) {
            if (value.equals(employee)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
