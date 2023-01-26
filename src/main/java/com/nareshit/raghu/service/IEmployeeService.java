package com.nareshit.raghu.service;

import java.util.List;

import com.nareshit.raghu.entity.EmployeeEntity;

public interface IEmployeeService {
	
	Integer saveEmployee(EmployeeEntity e);
	void updateEmployee(EmployeeEntity e);
	void deleteEmployee(Integer Id);
	EmployeeEntity getoneemployee(Integer Id);
	List<EmployeeEntity> getAllEmployee();
	 
	
}
