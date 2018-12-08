package com.aan.housemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.aan.housemanager")
public class HouseManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HouseManagerApplication.class, args);
	}
}
