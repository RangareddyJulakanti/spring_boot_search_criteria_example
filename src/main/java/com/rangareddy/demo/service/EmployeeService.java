package com.rangareddy.demo.service;


import com.rangareddy.demo.criteria.EmployeeCriteria;
import com.rangareddy.demo.criteria.EmployeeSpecifications;
import com.rangareddy.demo.domain.adapter.EmployeeAdapter;
import com.rangareddy.demo.domain.entity.EEmployee;
import com.rangareddy.demo.domain.model.Employee;
import com.rangareddy.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.rangareddy.demo.criteria.SearchParameter.Parameter.Operator.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeAdapter employeeAdapter;
    @PostConstruct
    public void init(){
        EEmployee e1=new EEmployee ();
        e1.setFirstName ("ranga");
        e1.setLastName ( "julakanti" );
        e1.setSalary ( 100000.50 );
        e1.setDateOfBirth ( ZonedDateTime.now ().minusYears ( 30 ) );
        employeeRepository.save ( e1 );
    }

    public List<Employee> getEmployees(EmployeeCriteria employeeCriteria) {
        List<Specification<EEmployee>> specifications=new ArrayList<> (  );
        firstNameSpecification(employeeCriteria, specifications);
        lastNameSpecification(employeeCriteria, specifications);
        salarySpecification(employeeCriteria, specifications);
        final Specification<EEmployee> first = specifications.remove(0);
        Specifications<EEmployee> where = Specifications.where(first);
        for (Specification<EEmployee> specification : specifications) {
            where = where.and(specification);
        }
        List<EEmployee> eEmployee = employeeRepository.findAll(where);
        return eEmployee.stream().map(employeeAdapter.entityToModel()).collect(Collectors.toList());
    }

    private void firstNameSpecification(EmployeeCriteria employeeCriteria, List<Specification<EEmployee>> specifications) {
        switch (employeeCriteria.getFirstName().getOperator()) {
            case Equals:
                specifications.add(EmployeeSpecifications.byFirstName(employeeCriteria.getFirstName().getValue()));
                break;
            case NotEquals:
                specifications.add(EmployeeSpecifications.byFirstNameNotEqual(employeeCriteria.getFirstName().getValue()));
                break;
        }
    }

    private void lastNameSpecification(EmployeeCriteria employeeCriteria, List<Specification<EEmployee>> specifications) {
        switch (employeeCriteria.getLastName().getOperator()) {
            case Equals:
                specifications.add(EmployeeSpecifications.byLastName(employeeCriteria.getLastName().getValue()));
                break;
            case NotEquals:
                specifications.add(EmployeeSpecifications.byLastNameNotEquals(employeeCriteria.getLastName().getValue()));
                break;
        }
    }

    private void salarySpecification(EmployeeCriteria employeeCriteria, List<Specification<EEmployee>> specifications) {
        if(Objects.isNull (employeeCriteria.getSalary()))
            return;
        switch (employeeCriteria.getSalary().getOperator()) {
            case Equals:
                specifications.add(EmployeeSpecifications.bySalary(employeeCriteria.getSalary().getValue()));
                break;
            case GreaterThan:
                specifications.add(EmployeeSpecifications.bySalaryGreaterThan(employeeCriteria.getSalary().getValue()));
                break;
            case LessThan:
                specifications.add(EmployeeSpecifications.bySalaryLessThan(employeeCriteria.getSalary().getValue()));
                break;
            case Range:
                specifications.add(EmployeeSpecifications.bySalaryBetween(employeeCriteria.getSalary().getValue(), employeeCriteria.getSalary().getValue2()));
                break;
        }
    }
}