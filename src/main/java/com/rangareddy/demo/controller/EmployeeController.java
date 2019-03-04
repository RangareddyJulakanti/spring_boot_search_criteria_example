package com.rangareddy.demo.controller;


import com.rangareddy.demo.criteria.EmployeeCriteria;
import com.rangareddy.demo.domain.model.Employee;
import com.rangareddy.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/search")
    public List<Employee> search(@RequestBody EmployeeCriteria employeeCriteria) {
        return employeeService.getEmployees(employeeCriteria);
    }

}