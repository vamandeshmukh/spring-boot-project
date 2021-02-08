package com.vaman.spring.boot.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vaman.spring.boot.demo.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/emp")
	private List<Employee> getAllEmployees() {

		return null;
	}

//	@RequestMapping("/emp") // endpoint / API  / REST APIs
//	public String emp() {
//		System.out.println("emp");
//		return new Employee(102, "Monu", 10.5).toString();
//	}

}
