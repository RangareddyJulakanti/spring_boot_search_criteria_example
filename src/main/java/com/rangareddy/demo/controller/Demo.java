package com.rangareddy.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rangareddy.demo.criteria.EmployeeCriteria;
import com.rangareddy.demo.criteria.SearchParameter;

import java.time.ZonedDateTime;

public class Demo
{
    public static void main(String[] args) throws JsonProcessingException {
     /* EmployeeCriteria employeeCriteria=  EmployeeCriteria.builder()
                .firstName(new SearchParameter.StringParameter<>(SearchParameter.Parameter.Operator.Equals,"ranga"))
                .lastName(new SearchParameter.StringParameter<>(SearchParameter.Parameter.Operator.NotEquals,"reddy"))
                .salary(new SearchParameter.DoubleParameter<>(500000.00,2000000.00))
                .dateOfBirth(new SearchParameter.RangeParameter<>(ZonedDateTime.now(),ZonedDateTime.now().minusYears(30)))
                .build();
        System.out.println(new ObjectMapper().writeValueAsString(employeeCriteria));*/

    }
}
