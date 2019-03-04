package com.rangareddy.demo.domain.model;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class Employee {
    private Integer empId;

    private String firstName;

    private String lastName;

    private Double salary;

    private ZonedDateTime dateOfBirth;
}
