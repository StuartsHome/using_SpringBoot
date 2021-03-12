package com.company.website.using_SpringBoot;

import java.util.Date;

import com.company.website.using_SpringBoot.database.jdbc.Person;
import com.company.website.using_SpringBoot.database.jdbc.PersonJDBCDao;
import com.company.website.using_SpringBoot.jpa.PersonJpaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class JpaDatabaseApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
					SpringApplication.run(UsingSpringDatabaseApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting id 10005 -> {}", repository.insert(new Person(10005, "Hamid", "Birmingham", new Date())));
		logger.info("Updating id 10003 -> {}", repository.update(new Person(10003, "Adam", "Manchester", new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());
		
		/*

		logger.info("Deleting id 10002 -> {}", dao.deleteById(10002));
		
		*/


	}

}
