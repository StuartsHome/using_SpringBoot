package com.company.website.using_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class UsingSpringDatabaseApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
					SpringApplication.run(UsingSpringDatabaseApplication.class, args);

		// prints all the beans
		// for (String name : applicationContext.getBeanDefinitionNames()) {
		// 	System.out.println(name);
		// }
	}

}
