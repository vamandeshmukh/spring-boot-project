package com.vaman.spring.boot.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vaman.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	// just a few methods

//	@Modifying
//	@Query("UPDATE employees SET name = ?1, salary = ?2, department_id = ?3 WHERE id = ?4")
//	void setEmployeeById(String name, double salary, int department_id, int id);

	Page<Employee> findByDepartmentId(int departmentId, Pageable pageable);

	Optional<Employee> findByIdAndDepartmentId(int id, int departmentId);

}
