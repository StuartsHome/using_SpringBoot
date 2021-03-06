package com.company.website.using_SpringBoot.database.jdbc;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person")
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {

    @Id // primaryKey
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private Date dob;

    // whenever using a Bean property Row Mapper in PersonJDBCDao, the bean needs a no parameter constructor
    public Person() {

    }
    public Person(int id, String name, String location, Date dob) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.dob = dob;
    }
    public Person(String name, String location, Date dob) {
        super();
        this.name = name;
        this.location = location;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    @Override
    public String toString() {
        //return "Person [dob=" + dob + ", id=" + id + ", location=" + location + ", name=" + name + "]";
        return String.format("\nPerson [id=%s, name=%s, location=%s, dob=%s]", id, name, location, dob);
    }
    

    
    
    
}
