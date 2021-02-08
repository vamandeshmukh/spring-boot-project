package com.vaman.spring.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaman.spring.boot.demo.model.Employee;
import com.vaman.spring.boot.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/emp")
	private List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees controller");
		service.getAllEmployees();
		return service.getAllEmployees();
	}

//	@RequestMapping("/emp") // endpoint / API  / REST APIs
//	public String emp() {
//		System.out.println("emp");
//		return new Employee(102, "Monu", 10.5).toString();
//	}

}
