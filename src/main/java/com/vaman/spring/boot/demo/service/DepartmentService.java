package com.vaman.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaman.spring.boot.demo.model.Department;
import com.vaman.spring.boot.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		System.out.println("getAllDepartments service");
		List<Department> departmentsList = new ArrayList<Department>();
		departmentRepository.findAll().forEach(dept -> departmentsList.add(dept));
		return departmentsList;
	}

	public Department getDepartmentById(int id) {
		System.out.println("getDepartmentById service");
		return departmentRepository.findById(id).get();
	}

	public void createDepartment(Department department) {
		System.out.println("createDepartment service");
		departmentRepository.save(department);
	}

	public Optional<Department> update(Department department, int id) {
		System.out.println("update service");
		return departmentRepository.findById(id).map(dept -> {
			dept.setId(dept.getId()); // check here
			dept.setName(department.getName());
			dept.setCity(department.getCity());
			return departmentRepository.save(dept);
		});
	}

	public void delete(int id) {
		System.out.println("delete service");
		departmentRepository.deleteById(id);
	}

}
