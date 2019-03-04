package com.rangareddy.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name="employee")
public class EEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;

    private String firstName;

    private String lastName;

    private Double salary;

    private ZonedDateTime dateOfBirth;
}