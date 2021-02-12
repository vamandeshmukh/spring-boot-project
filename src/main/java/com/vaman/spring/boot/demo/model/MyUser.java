package com.vaman.spring.boot.demo.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// caution: "MyUser" may need to be changed to "MyUser" user / users 

public class MyUser implements Serializable {

	private final Logger log = LoggerFactory.getLogger(MyUser.class);

	private static final long serialVersionUID = 1L;

//	private int id;
	private String username;
	private String password;

	public MyUser() {
		super();
		log.info("MyUser default constructor");
	}

	public MyUser(String username, String password) {
		log.info("MyUser parameterized constructor");
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		log.info("getUsername");
		return username;
	}

	public void setUsername(String username) {
		log.info("setUsername");
		this.username = username;
	}

	public String getPassword() {
		log.info("getPassword");
		return password;
	}

	public void setPassword(String password) {
		log.info("setPassword");
		this.password = password;
	}
}