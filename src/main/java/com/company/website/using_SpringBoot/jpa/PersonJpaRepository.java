package com.company.website.using_SpringBoot.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.company.website.using_SpringBoot.database.jdbc.Person;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
    
}
