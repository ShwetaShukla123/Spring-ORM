package com.psl.eclipselink.test;

import com.psl.eclipselink.entity.Employee;
import com.psl.eclipselink.service.EmpService;

public class Test {

	public static void main(String[] args) {
		
		EmpService empService = new EmpService();
		
//		Employee emp = new Employee();
//		emp.setId(101);
//		emp.setName("Shreya");
//		emp.setSalary(40000);
//		//create
//		empService.createEmployee(emp);
//		
		//retrieve
		Employee emp2 = empService.getEmployee(101);
		emp2.setSalary(50000);
		
		//update
		empService.updateEmployee(emp2);
		
		//delete operation
		empService.deleteEmployee(101);
	}
}
