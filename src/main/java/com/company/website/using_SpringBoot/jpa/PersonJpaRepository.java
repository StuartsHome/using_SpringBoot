package com.company.website.using_SpringBoot.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.company.website.using_SpringBoot.database.jdbc.Person;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findAll(int id) {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
    
    public Person update(Person person) {
        return entityManager.merge(person);
    }
    public Person insert(Person person) {
        return entityManager.merge(person);
    }
    
    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }

}
