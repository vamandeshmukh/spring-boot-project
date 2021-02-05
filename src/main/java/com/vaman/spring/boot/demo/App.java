package com.vaman.spring.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// netstat -ano | findstr :8080 
// taskkill /PID 4236 /F 

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
