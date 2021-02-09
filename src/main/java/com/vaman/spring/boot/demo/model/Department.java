package com.vaman.spring.boot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@Column
	int id;

	@Column
	String name;

	@Column
	String location;

}
