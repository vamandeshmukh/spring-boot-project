package com.vaman.spring.boot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vaman.spring.boot.demo.model.Department;
import com.vaman.spring.boot.demo.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DepartmentController {

	private final Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService service;

	@GetMapping("/departments")
	private List<Department> getAllDepartments() {
		log.info("getAllDepartments controller");
		return service.getAllDepartments();
	}

	@GetMapping("/department/{id}")
	private Department getDepartment(@PathVariable("id") int id) {
		log.info("getDepartment controller");
		return service.getDepartmentById(id);
	}

	@PostMapping("/department")
	private int createDepartment(@RequestBody Department Department) {
		log.info("createDepartment controller");
		service.createDepartment(Department);
		return Department.getId();
	}

	@PutMapping("/department/{id}")
	private Optional<Department> update(@PathVariable("id") int id, @RequestBody Department Department) {
		log.info("update controller");
		return service.update(Department, id);
	}

	@DeleteMapping("/department/{id}")
	private void deleteDepartment(@PathVariable("id") int id) {
		log.info("deleteDepartment controller");
		service.delete(id);
	}
}
