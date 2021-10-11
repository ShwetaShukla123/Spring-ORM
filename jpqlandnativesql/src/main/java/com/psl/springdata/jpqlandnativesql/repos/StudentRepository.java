package com.psl.springdata.jpqlandnativesql.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psl.springdata.jpqlandnativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
//	@Query("from Student")  //select * from student2
//	List<Student> findAllStudents();
	
	@Query("Select st.firstName, st.lastName from Student st")  //select st.fname, st.lname from student2 st
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName=:firstName")
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score between :min and :max")
	List<Student> findAllStudentByGivenScore(@Param("min") int min, @Param("max") int max);
	
	@Modifying
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentsByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student")  
	List<Student> findAllStudents(Pageable pageable);
	
	//native sql queries
	@Query(value ="select * from student2", nativeQuery = true)
	List<Student> findAllStudentsNQ();
	
	@Query(value ="select * from student2 where fname = :firstName", nativeQuery = true)
	List<Student> findAllStudentsByFirstNameNQ(@Param("firstName") String firstName);
}
