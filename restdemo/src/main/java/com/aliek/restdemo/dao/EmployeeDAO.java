package com.aliek.restdemo.dao;

import java.util.List;

import com.aliek.restdemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
}
