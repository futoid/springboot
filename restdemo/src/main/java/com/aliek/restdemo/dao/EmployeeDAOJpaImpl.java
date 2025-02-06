package com.aliek.restdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aliek.restdemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	//define field for entityManager
	EntityManager entityManger;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		// TODO Auto-generated constructor stub
		entityManger = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		//create a query
		TypedQuery<Employee> theQuery = entityManger.createQuery("from Employee", Employee.class);
		
		//execute query and get result
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	
	}
}
