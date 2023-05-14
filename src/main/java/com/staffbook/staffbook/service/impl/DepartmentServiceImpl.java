package com.staffbook.staffbook.service.impl;

import com.staffbook.staffbook.model.Employee;
import com.staffbook.staffbook.service.DepartmentService;
import com.staffbook.staffbook.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @Override

    public Employee getEmployeeMaxSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeMinSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getByDepartmentEmployee(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> departmentId == null || employee.getDepartment().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}
