package com.vaman.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vaman.spring.boot.demo.model.Employee;
import com.vaman.spring.boot.demo.service.EmployeeService;

//mark class as RestController

@RestController
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	// autowire the EmployeeService class
	@Autowired
	EmployeeService service;

	@GetMapping("/")
	private String baseUrl() {
		logger.info("baseUrl controller");
		return "welcome";
	}

	
// creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/employees")
	private List<Employee> getAllEmployees() {
		logger.info("getAllEmployees controller");
		return service.getAllEmployees();
	}

// creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/employee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		logger.info("getEmployee controller");

		return service.getEmployeeById(id);
	}

// creating a post mapping to post details of Employee

	@PostMapping("/department/{departmentId}/employee") // http://localhost:8090/department/5/employee
	public Employee createEmployee(@PathVariable(value = "departmentId") int departmentId,
			@RequestBody Employee employee) {

		System.out.println("createEmployee controller");

		service.saveEmployee(departmentId, employee);

		return employee;
	}

	// creating put mapping that updates the Employee detail

	// update only name
	@PutMapping("/employee/{id}")
	private Employee updateEmployee(@PathVariable(value = "id") int id, @RequestBody Employee employee) {
		System.out.println("updateEmployee controller");
		service.update(employee, id);
		return employee;
	}

// creating a delete mapping that deletes a specified Employee

	@DeleteMapping("/employee/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		System.out.println("deleteEmployee controller");
		service.delete(id);
	}

}
