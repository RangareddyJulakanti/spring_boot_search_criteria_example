package com.rangareddy.demo.repository;

import com.rangareddy.demo.domain.entity.EEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EEmployee,Integer>,JpaSpecificationExecutor<EEmployee> {
}
