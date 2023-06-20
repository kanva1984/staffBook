package com.staffbook.staffbook.service;

import com.staffbook.staffbook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeMaxSalary(Integer departmentId);

    Employee getEmployeeMinSalary(Integer departmentId);

    Map<Integer, List<Employee>> getByDepartmentEmployee(Integer departmentId);

}
