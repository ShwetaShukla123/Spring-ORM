package com.psl.eclipselink.service;


import com.psl.eclipselink.dao.EmpDao;
import com.psl.eclipselink.dao.EmpDaoImpl;
import com.psl.eclipselink.entity.Employee;

public class EmpService {
	
	EmpDao empDao = new EmpDaoImpl();
	
	public void createEmployee(Employee emp) {
		empDao.createEmp(emp);
	}
	
	public void updateEmployee(Employee emp) {
		empDao.updateEmp(emp);
	}
	
	public Employee getEmployee(int id) {
		Employee emp = empDao.getEmployee(id);
		return emp;
	}
	
	public void deleteEmployee(int id) {
		empDao.deleteEmp(id);
	}

}
