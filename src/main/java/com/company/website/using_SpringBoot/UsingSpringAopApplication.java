package com.company.website.using_SpringBoot;

import com.company.website.using_SpringBoot.dao.business.Business1;
import com.company.website.using_SpringBoot.dao.business.Business2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class UsingSpringAopApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(UsingSpringAopApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());

		business1.calculateSomething();
		business2.calculateSomething();
	}

}