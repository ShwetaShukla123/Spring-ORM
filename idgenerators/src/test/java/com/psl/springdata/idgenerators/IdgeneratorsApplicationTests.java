package com.psl.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.springdata.idgenerators.entities.Employee;
import com.psl.springdata.idgenerators.repos.EmployeeRepository;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository empRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateEmployee() {
		Employee emp = new Employee();
		emp.setName("Ravi");
		empRepo.save(emp);
	}
}
