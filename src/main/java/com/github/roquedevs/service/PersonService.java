package com.github.roquedevs.service;

import com.github.roquedevs.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final AtomicLong counter = new AtomicLong();
    private static final Logger log = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        log.info("Finding person by id: " + id);
        return mockPerson(0);
    }

    public List<Person> findAll() {
        log.info("Finding all persons");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person save(Person person) {
        log.info("Saving person: " + person);
        return person;
    }

    public Person update(Person person) {
        log.info("Updating person: " + person);
        return person;
    }

    public void delete(String id) {
        log.info("Deleting person by id: " + id);
    }

    private Person mockPerson(Integer id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("John " + id);
        person.setLastName("Doe " + id);
        person.setEmail("john.doe" + id + "@example.com");
        person.setPhone("(11) 23456-7890");
        person.setAddress("Avenue de Saint Petersburg, Paris - France");
        return person;
    }
}
