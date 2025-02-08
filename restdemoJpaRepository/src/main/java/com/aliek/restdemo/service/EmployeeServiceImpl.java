package com.aliek.restdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliek.restdemo.dao.EmployeeRespository;
import com.aliek.restdemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRespository employeeRespository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRespository theEmployeeDAO) {
		// TODO Auto-generated constructor stub
		employeeRespository = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRespository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();		
		}
		else {
			 throw new RuntimeException("Did not find employee id -" + theId);
		}
		
		
		return theEmployee;
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRespository.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRespository.deleteById(theId);
	}
}
