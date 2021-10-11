package com.psl.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.psl.springdata.jpqlandnativesql.entities.Student;
import com.psl.springdata.jpqlandnativesql.repos.StudentRepository;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setScore(80);
		repository.save(student);

		Student student2 = new Student();
		student2.setFirstName("Bill");
		student2.setLastName("Gates");
		student2.setScore(85);
		repository.save(student2);

		Student student3 = new Student();
		student3.setFirstName("Shweta");
		student3.setLastName("Shukla");
		student3.setScore(81);
		repository.save(student3);
	}

//	@Test
//	public void testFindAllStudents() {
//		System.out.println(repository.findAllStudents());
//	}
	
	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> list = repository.findAllStudentsPartialData();
		for(Object[] obj : list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(repository.findAllStudentsByFirstName("Shweta"));
	}
	
	@Test
	public void testFindAllStudentsByGivenScore() {
		System.out.println(repository.findAllStudentByGivenScore(81, 90));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentByFirstName() {
		repository.deleteStudentsByFirstName("Bill");
	}
	
	@Test
	public void testFindAllStudents() {
		System.out.println(repository.findAllStudents(PageRequest.of(1, 4)));
	}
	
	@Test
	public void testFindAllStudentsSorted() {
		System.out.println(repository.findAllStudents(PageRequest.of(1, 5, Direction.ASC, "id")));
	}
	
	@Test
	public void testFindAllStudentsSortedDesc() {
		System.out.println(repository.findAllStudents(PageRequest.of(1, 5, Direction.DESC, "id")));
	}
	
	@Test
	public void testFindAllStudentsNQ() {
		System.out.println(repository.findAllStudentsNQ());
	}
	
	@Test
	public void testFindAllStudentsByFirstNameNQ() {
		System.out.println(repository.findAllStudentsByFirstNameNQ("Shweta"));
	}
}
