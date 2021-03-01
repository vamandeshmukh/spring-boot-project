package com.vaman.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaman.spring.boot.demo.model.MyUser;
import com.vaman.spring.boot.demo.security.JwtUtil;
import com.vaman.spring.boot.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

	// test method, delete afterwards


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/hello")
	public String hello() {
		log.info("hello");
		return "Hello";
	}

	@PostMapping("/login") // 1
	public String login(@RequestBody MyUser myUser) {
		log.info("login");
		if (myUser.getUsername().equals(userDetailsService.loadUserByUsername(myUser.getUsername()).getUsername())
				&& myUser.getPassword().equals(userDetailsService.loadUserByUsername(null).getPassword())) {
			log.info("user authenticated");
			return jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(myUser.getUsername()));
		} else {
			return "thisIsNotTheValidToken";
		}
//		try {
//			authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(myUser.getUsername(), myUser.getPassword()));
//			log.info("user authenticated");
//			return jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(myUser.getUsername()));
//		} catch (BadCredentialsException bce) {
//			log.error(bce.getMessage());
//		} catch (AuthenticationException ae) {
//			log.error(ae.getMessage());
//		}
//		return "thisIsNotTheValidToken";

	}

}