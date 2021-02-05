package com.vaman.spring.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vaman.spring.boot.demo.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping("/emp") // endpoint / API  / REST APIs
	public String emp() {
		System.out.println("emp");
		return new Employee(102, "Monu", 10.5).toString();
	}

	@RequestMapping("/empObj")
	public String empObj() {
		Employee emp = new Employee(101, "Sonu", 10.5);
		System.out.println(emp.toString());
		Gson gson = new Gson();
		String empJson = gson.toJson(emp);
		return empJson;
	}
}
