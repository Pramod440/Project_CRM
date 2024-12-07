package com.crm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  // @SpringBootApplication annotation is the starting point of the application,it is also an alias for @Configuration, @EnableAutoConfiguration.
public class CrmApplication {     //Configuration class

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
	/*@Bean annotation is used to explicitly declare a bean that will be managed by the Spring IoC container,It's typically
                             used within @Configuration classes to define beans that can be used throughout your application. */

}
