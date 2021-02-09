package com.vaman.spring.boot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vaman.spring.boot.demo.model.Department;
import com.vaman.spring.boot.demo.service.DepartmentService;

//mark class as Controller

@RestController
public class DepartmentController {

	// autowire the DepartmentService class
	@Autowired
	DepartmentService service;

// creating a get mapping that retrieves all the Department detail from the database
	@GetMapping("/departments")
	private List<Department> getAllDepartments() {
		System.out.println("getAllDepartments controller");
		return service.getAllDepartments();
	}

// creating a get mapping that retrieves the detail of a specific Department
	@GetMapping("/department/{id}")
	private Department getDepartment(@PathVariable("id") int id) {
		System.out.println("getDepartment controller");
		return service.getDepartmentById(id);
	}

// creating post mapping that post the Department detail in the database
	@PostMapping("/department")
	private int createDepartment(@RequestBody Department Department) {
		System.out.println("createDepartment controller");
		service.createDepartment(Department);
		return Department.getId();
	}

// creating put mapping that updates the Department detail
	@PutMapping("/department/{id}")
	private Optional<Department> update(@PathVariable("id") int id, @RequestBody Department Department) {
		System.out.println("update controller");
		return service.update(Department, id);
//		return Department;
	}

	// creating a delete mapping that deletes a specified Department
	@DeleteMapping("/department/{id}")
	private void deleteDepartment(@PathVariable("id") int id) {
		System.out.println("deleteDepartment controller");
		service.delete(id);
	}

}
