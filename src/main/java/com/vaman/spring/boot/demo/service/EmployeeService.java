package com.vaman.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaman.spring.boot.demo.model.Employee;
import com.vaman.spring.boot.demo.repository.EmployeeRepository;

//defining the business logic

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

//getting all Employee record by using the method findaAll() of CrudRepository

	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees");
		List<Employee> employeesList = new ArrayList<Employee>();
		repository.findAll().forEach(emp -> employeesList.add(emp));
		return employeesList;
	}

//getting a specific record by using the method findById() of CrudRepository

	public Employee getEmployeeById(int id) {
		System.out.println("getEmployeeById");
		return repository.findById(id).get();
	}

//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) {
		System.out.println("saveOrUpdate");
		repository.save(employee);
	}

//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		System.out.println("delete");
		repository.deleteById(id);
	}

//updating a record
	public void update(Employee employee, int id) {
		System.out.println("update");
		repository.save(employee);
	}
}
