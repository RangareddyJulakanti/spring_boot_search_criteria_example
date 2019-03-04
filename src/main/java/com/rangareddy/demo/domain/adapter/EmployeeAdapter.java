package com.rangareddy.demo.domain.adapter;

import com.rangareddy.demo.domain.entity.EEmployee;
import com.rangareddy.demo.domain.model.Employee;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class EmployeeAdapter {
    public   Function<EEmployee,Employee> entityToModel(){
        return (EEmployee entity)->{
            return Employee
                    .builder()
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .salary(entity.getSalary())
                    .build();
        };
    }

    public  Function<Employee,EEmployee> modelToEntity(){
        return (Employee model)->{
            EEmployee entity= new EEmployee();
            entity.setEmpId(model.getEmpId());
            entity.setSalary(model.getSalary());
            entity.setFirstName(model.getFirstName());
            entity.setLastName(model.getLastName());
            entity.setDateOfBirth(model.getDateOfBirth());
            return entity;
        };
    }
}
