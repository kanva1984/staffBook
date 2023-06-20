package com.staffbook.staffbook.service.impl;

import com.staffbook.staffbook.model.Employee;
import com.staffbook.staffbook.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Oleg", "Sidorov", 100000, 1));
        add(new Employee("Ivan", "Ivanov", 110000, 1));
        add(new Employee("Marina", "Petrova", 90000, 1));
    }};

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ShouldReturnEmployeeWithMaxSalary() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getAllEmployees()).willReturn(employeeMap);
        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeMaxSalary(departmentId);
        //then
        assertEquals(employees.get(1), employeeWithMaxSalary);
    }
    @Test
    void ShouldReturnNullWhenNoEmployeesInDepartment1() {
        //given
        final int departmentId = 2;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getAllEmployees()).willReturn(employeeMap);
        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeMinSalary(departmentId);
        //then
        assertNull(employeeWithMaxSalary);
    }

    @Test
    void ShouldReturnEmployeeWithMinSalary() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getAllEmployees()).willReturn(employeeMap);
        //when
        Employee employeeWithMinSalary = departmentService.getEmployeeMinSalary(departmentId);
        //then
        assertEquals(employees.get(2), employeeWithMinSalary);
    }
    @Test
    void ShouldReturnNullWhenNoEmployeesInDepartment() {
        //given
        final int departmentId = 2;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getAllEmployees()).willReturn(employeeMap);
        //when
        Employee employeeWithMinSalary = departmentService.getEmployeeMinSalary(departmentId);
        //then
        assertNull(employeeWithMinSalary);
    }
    @Test
    void getByDepartmentEmployee() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getAllEmployees()).willReturn(employeeMap);
        //when
        Map<Integer, List<Employee>> employeesByDepartment = departmentService.getByDepartmentEmployee(departmentId);
        //then
        assertEquals(employeeMap, employeesByDepartment);
    }
}
