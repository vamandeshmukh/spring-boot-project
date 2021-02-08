package com.vaman.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaman.spring.boot.demo.model.Employee;
import com.vaman.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees service");

		List<Employee> empList = new ArrayList<>();

		repository.findAll().forEach(emp -> empList.add(emp)); // add objects to list

		// empList = (List<Employee>) repository.findAll(); // add objects to list
		return empList;
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) {
		System.out.println("saveOrUpdate");
		repository.save(employee);
	}

}
