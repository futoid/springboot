package com.aliek.restdemo.service;

import java.util.List;

import com.aliek.restdemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
