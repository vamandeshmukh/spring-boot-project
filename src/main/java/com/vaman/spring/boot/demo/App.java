package com.vaman.spring.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// netstat -ano | findstr :8080 
// taskkill /PID 4236 /F 

/* 
 * Assignment - create department class (and departments table) and have pk-fk relationships between employees and departments
 * link - https://lh3.googleusercontent.com/proxy/6mNDHqCWs6s-cePgPJQQz4sPhiWe_IBElPJn1vbt-E-q3oSqYZoxtfoWUhjaYKQSrgKkXm8PwbrfLY2TlAjpMhCb0c70pZG__TC41qIqnw  
 * have at least 25 employees and at least 7 departments 
 * employees can work only in the departments that exist 
 * work in all the classes 
 */



/**
 * 
 * @author Vaman
 *
 */

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(App.class, args);
		System.out.println("End");
	}
}
