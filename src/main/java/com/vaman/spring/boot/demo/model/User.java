package com.vaman.spring.boot.demo.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// caution: "User" may need to be changed to "MyUser" user / users 

public class User implements Serializable {

	private final Logger log = LoggerFactory.getLogger(User.class);

	private static final long serialVersionUID = 1L;

//	private int id;
	private String username;
	private String password;

	public User() {
		super();
		log.info("User default constructor");
	}

	public User(String username, String password) {
		log.info("User parameterized constructor");
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