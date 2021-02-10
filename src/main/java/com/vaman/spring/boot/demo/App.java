package com.vaman.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Vaman Deshmukh
 *
 */

// exception handling - in service classes 
// logging - add logs to all the classes wherever applicable 

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(App.class);
		logger.info("Start");
		SpringApplication.run(App.class, args);
		logger.info("End");

	}
}
