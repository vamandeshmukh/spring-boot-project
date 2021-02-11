package com.vaman.spring.boot.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;


// this class has no use 
public class MyNoOpPasswordEncoder implements PasswordEncoder {

	static PasswordEncoder getInstance() {
		return new MyNoOpPasswordEncoder();
	}

	@Override
	public String encode(CharSequence rawPassword) {

		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		return false;
	}

}