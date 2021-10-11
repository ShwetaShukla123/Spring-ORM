package com.psl.eclipselink.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.psl.eclipselink.entity.Employee;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPQLdemo");
		EntityManager entityManager = emFactory.createEntityManager();
		
		Query query = entityManager.createQuery("Select e " + "from Employee e " + "where e.salary " + "Between 30000 and 40000");
		List<Employee> list=(List<Employee>)query.getResultList();

	      for( Employee e:list ){
	         System.out.print(e.toString());
	      }
	}

}
