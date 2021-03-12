package com.company.website.using_SpringBoot.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJDBCDao {

    // Spring provides database connection
    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {
       // @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setDob(rs.getTimestamp("dob"));
        }

        @Override
        public int[] getRowsForPaths(TreePath[] path) {
            // TODO Auto-generated method stub
            return null;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
            new PersonRowMapper<Person>(Person.class));
                //new BeanPropertyRowMapper<Person>(Person.class)); 
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
    }
    
    public int insert(Person person) {
        return jdbcTemplate.update(
            "insert into person (id, name, location, dob) "
                + "values(?, ?, ?, ?)",
                    new Object[] {
                        person.getId(), person.getName(),
                        person.getLocation(), new Timestamp(person.getDob().getTime()) }); 
    }

    public int update(Person person) {
        return jdbcTemplate.update(
            "update person "
            + "set name = ?, location = ?, dob = ? "
            + "where id = ?",
                    new Object[]{
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getDob().getTime()),
                        person.getId() }); 
    }
}
