package com.psl.eclipselink.dao;

import com.psl.eclipselink.entity.Employee;

public interface EmpDao {
	
	public void createEmp(Employee emp);
	public Employee getEmployee(int id);
	public void deleteEmp(int id);
	public void updateEmp(Employee emp);

}
