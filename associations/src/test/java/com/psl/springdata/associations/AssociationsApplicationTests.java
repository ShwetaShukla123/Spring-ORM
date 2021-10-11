package com.psl.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.psl.springdata.associations.manytomany.repos.ProgrammerRepository;
import com.psl.springdata.associations.onetomany.repos.CustomerRepository;
import com.psl.springdata.associations.onetomanyentities.Customer;
import com.psl.springdata.associations.onetomanyentities.PhoneNumber;
import com.psl.springdata.associations.onetomanyentities.Programmer;
import com.psl.springdata.associations.onetomanyentities.Project;
import com.psl.springdata.associations.onetoone.entities.License;
import com.psl.springdata.associations.onetoone.entities.Person;
import com.psl.springdata.associations.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCustomer() {
		Customer customer = new Customer();
		customer.setName("John");
//		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPnumber("9072049621");
		ph1.setPtype("cell");
//		ph1.setCustomer(customer);
//		numbers.add(ph1);

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPnumber("9089729621");
		ph2.setPtype("home");
//		ph2.setCustomer(customer);
//		numbers.add(ph2);

//		customer.setNumbers(numbers);
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		repository.save(customer);
	}

	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = repository.findById(4L).get();
		System.out.println(customer.getName());
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> System.out.println(n.getPnumber()));
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = repository.findById(4L).get();
		customer.setName("John Bush");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> n.setPtype("Cell"));
		repository.save(customer);
	}

	@Test
	public void testDelete() {
		repository.deleteById(4L);
	}
	
//Many to Many Tests
	
	@Test
	public void testCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSalary(30000);
		HashSet<Project> projects = new HashSet<Project>();
		
		Project project = new Project();
		project.setName("Hibernate Project");
		
		projects.add(project);
		programmer.setProjects(projects);
		programmerRepository.save(programmer);
		
	}
	
	@Test
	@Transactional
	public void testFindProgrammer() {
		Programmer programmer = programmerRepository.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}
	
//One to One
	
	@Test
	public void testCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Clinton");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		person.setAge(35);
		license.setPerson(person);
		licenseRepository.save(license);
	}
}
