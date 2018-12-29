package com.spring.tests.employeeservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tests.employeeservices.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
