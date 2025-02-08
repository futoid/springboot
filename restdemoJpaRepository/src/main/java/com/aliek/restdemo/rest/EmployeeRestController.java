package com.aliek.restdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliek.restdemo.dao.EmployeeRespository;
import com.aliek.restdemo.entity.Employee;
import com.aliek.restdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmployee =  employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found" + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee udpateEmployee (@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee (@PathVariable int employeeId) {
		
		Employee dbEmployee = employeeService.findById(employeeId);
		
		if(dbEmployee == null) {
			throw new RuntimeException("Employee Id not found - " +  employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}
