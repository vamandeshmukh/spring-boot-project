package com.vaman.spring.boot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@RequestMapping("/hi")
	public String hi() {
		System.out.println("hi");
		return "Hi";
	}

//	@RequestMapping("/emp")
//	public Employee emp() {
//		System.out.println("hi");
//		return new Employee();
//	}

}
