package com.vaman.spring.boot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vaman.spring.boot.demo.model.Department;
import com.vaman.spring.boot.demo.service.DepartmentService;


@RestController
public class DepartmentController {


	@Autowired
	DepartmentService service;

	@GetMapping("/departments")
	private List<Department> getAllDepartments() {
		System.out.println("getAllDepartments controller");
		return service.getAllDepartments();
	}

	@GetMapping("/department/{id}")
	private Department getDepartment(@PathVariable("id") int id) {
		System.out.println("getDepartment controller");
		return service.getDepartmentById(id);
	}

	@PostMapping("/department")
	private int createDepartment(@RequestBody Department Department) {
		System.out.println("createDepartment controller");
		service.createDepartment(Department);
		return Department.getId();
	}

	@PutMapping("/department/{id}")
	private Optional<Department> update(@PathVariable("id") int id, @RequestBody Department Department) {
		System.out.println("update controller");
		return service.update(Department, id);
	}

	@DeleteMapping("/department/{id}")
	private void deleteDepartment(@PathVariable("id") int id) {
		System.out.println("deleteDepartment controller");
		service.delete(id);
	}

}
