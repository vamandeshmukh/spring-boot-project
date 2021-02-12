package com.deloitte.spring.boot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTests {

	@DisplayName("Test Hello")
	@Test
	void testGet() {
		assertEquals("Hello", "Hello");
	}

}
