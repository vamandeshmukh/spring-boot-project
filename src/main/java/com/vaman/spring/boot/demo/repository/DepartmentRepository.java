package com.vaman.spring.boot.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.vaman.spring.boot.demo.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
