package com.staffbook.staffbook.controller;

import com.staffbook.staffbook.model.Employee;
import com.staffbook.staffbook.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class StaffBookController {

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в книгу сотрудников!";
    }

    final private EmployeeService employeeService;

    public StaffBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    private Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/add")
    private Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    private void removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    private Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
}
