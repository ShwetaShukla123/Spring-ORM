package com.psl.eclipselink.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.psl.eclipselink.entity.Employee;

public class EmpDaoImpl implements EmpDao{
	
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EclipseLink_Demo");
	EntityManager entityManager = emFactory.createEntityManager();

	@Override
	public void createEmp(Employee emp) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EclipseLink_Demo");
		EntityManager entityManager = emFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();
	}

	@Override
	public Employee getEmployee(int id) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EclipseLink_Demo");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp = entityManager.find(Employee.class, id);
		entityManager.close();
		emFactory.close();
		return emp;
		
	}

	@Override
	public void deleteEmp(int id) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EclipseLink_Demo");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp = this.getEmployee(id);
		if (!entityManager.contains(emp)) {
		    emp = entityManager.merge(emp);
		}

		entityManager.remove(emp);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();
	}

	@Override
	public void updateEmp(Employee emp) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EclipseLink_Demo");
		EntityManager entityManager = emFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(emp);
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();
	}

}
