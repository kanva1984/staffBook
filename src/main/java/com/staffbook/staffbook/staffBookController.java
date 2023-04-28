package com.staffbook.staffbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffbook")
public class staffBookController {

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в книгу сотрудников!";
    }



//    @GetMapping(path = "/name")
//    public String name(
//        @RequestParam("number") Integer number){
//        final Employee employee;
//        employee = EmployeeService.getName(number);
//        return employee;
//    }
    @GetMapping(path = "/name/add")
    public String addName(
            @RequestParam("firstname") String firstname, @RequestParam("lastName") String lastName){

        return "test";
    }

}
