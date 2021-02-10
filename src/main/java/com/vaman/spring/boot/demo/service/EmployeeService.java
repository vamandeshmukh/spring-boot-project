package com.vaman.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaman.spring.boot.demo.model.Employee;
import com.vaman.spring.boot.demo.repository.DepartmentRepository;
import com.vaman.spring.boot.demo.repository.EmployeeRepository;

//defining the business logic

@Service
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

//	@Autowired
	Employee employeeDummy = new Employee();

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

//getting all Employee record by using the method findaAll() of CrudRepository

	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees service");
		List<Employee> employeesList = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp -> employeesList.add(emp));
		return employeesList;
	}

//getting a specific record by using the method findById() of CrudRepository

	public Employee getEmployeeById(int id) {
		System.out.println("getEmployeeById service");
		try {
			return employeeRepository.findById(id).get();
		} catch (Exception ex) {
			logger.error(id + " does not exist.");
			return employeeDummy;
		}
	}

// create a new employee record by using the custom method in the Repository

	public Employee saveEmployee(int departmentId, Employee employee) {
		System.out.println("saveEmployee service");
		departmentRepository.findById(departmentId).map(department -> {
			employee.setDepartment(department);
			return employee;
		});
		return employeeRepository.save(employee);
	}

// updating a record

	public Optional<Employee> update(Employee employee, int id) {
		System.out.println("update service");
		return employeeRepository.findById(id).map(emp -> { // add more logic
			emp.setName(employee.getName()); // write all fields updates
			return employeeRepository.save(emp);
		});
	}

// deleting the specific record by using the method deleteById() of CrudRepository

	public int delete(int id) {
		System.out.println("delete service");
		employeeRepository.deleteById(id);
		return id;
	}

}
