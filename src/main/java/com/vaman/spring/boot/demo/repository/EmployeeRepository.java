package com.vaman.spring.boot.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.vaman.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	// just a few methods  
	
	// findbyEmail // findByAaadhaar // 

}

// MongoRepository JpaRepository ... 
