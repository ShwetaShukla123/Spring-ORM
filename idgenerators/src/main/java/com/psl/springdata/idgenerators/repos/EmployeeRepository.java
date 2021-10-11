package com.psl.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.idgenerators.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
