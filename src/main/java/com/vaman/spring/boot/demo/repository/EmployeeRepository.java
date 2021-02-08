package com.vaman.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.vaman.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	// just a few methods  

}


// MongoRepository JpaRepository ... 