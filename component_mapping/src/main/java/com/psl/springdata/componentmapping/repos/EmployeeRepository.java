package com.psl.springdata.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
