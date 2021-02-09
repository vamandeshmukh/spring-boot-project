package com.vaman.spring.boot.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column
	int id;

	@Column
	String name;

	@Column
	double salary; 

//	@Column
//	Department department;

//	@Column
//	department_id;

	public Employee() {
		super();
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
