package com.vaman.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vaman.spring.boot.demo.App;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

	private final static Logger log = LoggerFactory.getLogger(App.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername");
		return new User("user@deloitte.com", "password", new ArrayList<>());
	}
}