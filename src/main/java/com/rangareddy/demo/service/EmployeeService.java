package com.rangareddy.demo.service;


import com.rangareddy.demo.criteria.EmployeeCriteria;
import com.rangareddy.demo.criteria.EmployeeSpecifications;
import com.rangareddy.demo.domain.adapter.EmployeeAdapter;
import com.rangareddy.demo.domain.entity.EEmployee;
import com.rangareddy.demo.domain.model.Employee;
import com.rangareddy.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rangareddy.demo.criteria.SearchParameter.Parameter.Operator.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeAdapter employeeAdapter;

    public List<Employee> getEmployees(EmployeeCriteria employeeCriteria) {
        Specification<EEmployee> specification = Specification.where(null);
        firstNameSpecification(employeeCriteria, specification);
        lastNameSpecification(employeeCriteria, specification);
        salarySpecification(employeeCriteria, specification);
        List<EEmployee> eEmployee = employeeRepository.findAll(specification);
        return eEmployee.stream().map(employeeAdapter.entityToModel()).collect(Collectors.toList());
    }

    private void firstNameSpecification(EmployeeCriteria employeeCriteria, Specification<EEmployee> specification) {
        switch (employeeCriteria.getFirstName().getOperator()) {
            case Equals:
                specification.and(EmployeeSpecifications.byFirstName(employeeCriteria.getFirstName().getValue()));
                break;
            case NotEquals:
                specification.and(EmployeeSpecifications.byFirstNameNotEqual(employeeCriteria.getFirstName().getValue()));
                break;
        }
    }

    private void lastNameSpecification(EmployeeCriteria employeeCriteria, Specification<EEmployee> specification) {
        switch (employeeCriteria.getLastName().getOperator()) {
            case Equals:
                specification.and(EmployeeSpecifications.byLastName(employeeCriteria.getLastName().getValue()));
                break;
            case NotEquals:
                specification.and(EmployeeSpecifications.byLastNameNotEquals(employeeCriteria.getLastName().getValue()));
                break;
        }
    }

    private void salarySpecification(EmployeeCriteria employeeCriteria, Specification<EEmployee> specification) {
        switch (employeeCriteria.getSalary().getOperator()) {
            case Equals:
                specification.and(EmployeeSpecifications.bySalary(employeeCriteria.getSalary().getValue()));
                break;
            case GreaterThan:
                specification.and(EmployeeSpecifications.bySalaryGreaterThan(employeeCriteria.getSalary().getValue()));
                break;
            case LessThan:
                specification.and(EmployeeSpecifications.bySalaryLessThan(employeeCriteria.getSalary().getValue()));
                break;
            case Range:
                specification.and(EmployeeSpecifications.bySalaryBetween(employeeCriteria.getSalary().getValue(), employeeCriteria.getSalary().getValue2()));
                break;
        }
    }
}