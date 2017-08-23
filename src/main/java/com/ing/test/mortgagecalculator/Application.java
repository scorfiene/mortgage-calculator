package com.ing.test.mortgagecalculator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**************************************************************************
 * This class marks the starting point for the application with the main 
 * method
 * 
 * @author Hari
 *
 **************************************************************************/
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages= {"com.ing.test.mortgagecalculator"})
public class Application {
	
	public static void main (String [] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
