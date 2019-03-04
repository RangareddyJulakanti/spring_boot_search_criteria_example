package com.rangareddy.demo.criteria;

import com.rangareddy.demo.domain.entity.EEmployee;
import org.springframework.data.jpa.domain.Specification;

import java.time.ZonedDateTime;

public class EmployeeSpecifications  {
    public static Specification<EEmployee> byFirstName(final String firstName) {
        return (root, query, cb) -> cb.equal(root.get("firstName"), firstName);
    }
    public static Specification<EEmployee> byFirstNameNotEqual(final String firstName) {
        return (root, query, cb) -> cb.notEqual(root.get("firstName"), firstName);
    }
    public static Specification<EEmployee> byLastName(final String lastName) {
        return (root, query, cb) -> cb.equal(root.get("lastName"), lastName);
    }
    public static Specification<EEmployee> byLastNameNotEquals(final String lastName) {
        return (root, query, cb) -> cb.notEqual(root.get("lastName"), lastName);
    }
    public static Specification<EEmployee> bySalary(final Double salary) {
        return (root, query, cb) -> cb.equal(root.get("salary"), salary);
    }
    public static Specification<EEmployee> bySalaryLessThan(final Double salary) {
        return (root, query, cb) -> cb.lt(root.get("salary"), salary);
    }
    public static Specification<EEmployee> bySalaryLessThanOREqual(final Double salary) {
        return (root, query, cb) -> cb.le(root.get("salary"), salary);
    }
    public static Specification<EEmployee> bySalaryGreaterThan(final Double salary) {
        return (root, query, cb) -> cb.gt(root.get("salary"), salary);
    }
    public static Specification<EEmployee> bySalaryGreaterThanOrEqual(final Double salary) {
        return (root, query, cb) -> cb.ge(root.get("salary"), salary);
    }
    public static Specification<EEmployee> bySalaryBetween(final Double salary1,final Double salary2) {
        return (root, query, cb) -> cb.between(root.get("salary").get("salary"), salary1,salary2);
    }

    public static Specification<EEmployee> byDateOfBirth(final ZonedDateTime dateOfBirth){
        return  ((root, query, cb) -> cb.equal(root.get("createdOn"),dateOfBirth));
    }
    public static Specification<EEmployee> byDateOfBirthBetween(final ZonedDateTime date1, final ZonedDateTime date2) {
        return (root, query, cb) -> cb.between(root.get("dateOfBirth").get("dateOfBirth"), date1, date2);
    }
}