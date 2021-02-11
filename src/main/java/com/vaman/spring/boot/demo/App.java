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
// another (consumer app) - to consume these web services 

@SpringBootApplication
public class App {

	private final static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		log.info("Start");
		SpringApplication.run(App.class, args);
		log.info("End");

	}
}
