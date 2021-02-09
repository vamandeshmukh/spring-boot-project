package com.vaman.spring.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vaman.spring.boot.demo.model.Employee;
import com.vaman.spring.boot.demo.service.EmployeeService;

//mark class as Controller
@RestController
public class EmployeeController {

	// autowire the EmployeeService class
	@Autowired
	EmployeeService service;

// creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/emp")
	private List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees controller");
		return service.getAllEmployees();
	}

// creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/emp/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		System.out.println("getEmployee");
		return service.getEmployeeById(id);
	}

// creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/emp/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		System.out.println("deleteEmployee");
		service.delete(id);
	}

// creating post mapping that post the Employee detail in the database
	@PostMapping("/emp")
	private int saveEmployee(@RequestBody Employee Employee) {
		System.out.println("saveEmployee");
		service.saveOrUpdate(Employee);
		return Employee.getId();
	}

// creating put mapping that updates the Employee detail
	@PutMapping("/emp")
	private Employee update(@RequestBody Employee Employee) {
		System.out.println("update");
		service.saveOrUpdate(Employee);
		return Employee;
	}
}
