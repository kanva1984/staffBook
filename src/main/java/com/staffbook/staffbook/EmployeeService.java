package com.staffbook.staffbook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {
    //    Integer[] numbersArray = {1, 2, 3,};
//    List<Integer> numbersList = new ArrayList<>(List.of(9, 2, 3, 5));
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



    public Employee addEmployee(String firstname, String lastName) {
        employees.add(String firstname, String lastName);
    }

}
