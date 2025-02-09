package com.aliek.restdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliek.restdemo.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
 //
}
