package com.company.website.using_SpringBoot;

import com.company.website.using_SpringBoot.database.jdbc.PersonJDBCDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class UsingSpringDatabaseApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJDBCDao dao;

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
					SpringApplication.run(UsingSpringDatabaseApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting id 10002 -> {}", dao.deleteById(10002));

	}

}
