package com.github.roquedevs.service;

import com.github.roquedevs.exception.ResourceAlreadyExistException;
import com.github.roquedevs.exception.ResourceNotFoundException;
import com.github.roquedevs.model.Person;
import com.github.roquedevs.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    private static final Logger log = Logger.getLogger(PersonService.class.getName());

    public Person findById(Long id) {
        log.info("Finding person by id: " + id);
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
    }

    public List<Person> findAll() {
        log.info("Finding all persons");
        return repository.findAll();
    }

    public Person save(Person person) {
        log.info("Saving person: " + person);
        Person personFound = repository.findByEmail(person.getEmail());
        if (personFound != null) {
            throw new ResourceAlreadyExistException("Person with id: " + person.getId() + " already exists");
        }
        return repository.save(person);
    }

    public Person update(Person person) {
        log.info("Updating person: " + person);

        Person foundPerson = findById(person.getId());
        if (foundPerson == null) {
            throw new ResourceNotFoundException("Person not found with id: " + person.getId());
        }

        foundPerson.setFirstName(person.getFirstName());
        foundPerson.setLastName(person.getLastName());
        foundPerson.setEmail(person.getEmail());
        foundPerson.setPhone(person.getPhone());
        foundPerson.setAddress(person.getAddress());
        return repository.save(foundPerson);
    }

    public void delete(Long id) {
        log.info("Deleting person by id: " + id);
        repository.deleteById(id);
    }
}
