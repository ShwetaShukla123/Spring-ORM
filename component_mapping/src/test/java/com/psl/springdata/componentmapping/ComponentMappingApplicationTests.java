package com.psl.springdata.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.springdata.componentmapping.entities.Address;
import com.psl.springdata.componentmapping.entities.Employee;
import com.psl.springdata.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentMappingApplicationTests {
	
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateEmployee() {
		
		Employee emp = new Employee();
		emp.setId(11);
		emp.setName("Shweta");
		
		Address address = new Address();
		address.setCity("Kanpur");
		address.setState("Up");
		address.setStreetaddress("Yogendra Vihar");
		address.setZipcode("2392938");
		address.setCountry("India");
		emp.setAddress(address);
		
		repository.save(emp);
	}
}