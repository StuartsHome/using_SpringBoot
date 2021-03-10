package com.company.website.using_SpringBoot.database.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJDBCDao {

    // Spring provides database connection
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<Person>(Person.class)); 
                // whenever using a Bean property Row Mapper, the bean needs a no parameter constructor
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject
        ("select * from person where id=?", new Object[]{ id },
        // create an array of objects and pass ID in.
                new BeanPropertyRowMapper<Person>(Person.class)); 
                
    }

    public int deleteById(int id) {
        return jdbcTemplate.update
        ("delete from person where id=?", new Object[]{ id }); 
        // create an array of objects and pass ID in.
    }
    
}
