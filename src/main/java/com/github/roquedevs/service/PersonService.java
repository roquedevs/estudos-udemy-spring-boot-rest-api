package com.github.roquedevs.service;

import com.github.roquedevs.dto.PersonDTO;
import com.github.roquedevs.exception.ResourceAlreadyExistException;
import com.github.roquedevs.exception.ResourceNotFoundException;
import com.github.roquedevs.mapper.PersonMapper;
import com.github.roquedevs.model.Person;
import com.github.roquedevs.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id: " + id);

        var person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));

        return mapper.toPersonDTO(person);
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all persons");
        var people = repository.findAll();
        return mapper.toPersonDTOList(people);
    }

    public PersonDTO save(PersonDTO personDTO) {
        logger.info("Saving person: " + personDTO);
        Person person = repository.findByEmail(personDTO.email());
        if (person != null) throw new ResourceAlreadyExistException("Person already exists with id: " + personDTO.id());
        return mapper.toPersonDTO(repository.save(mapper.toPerson(personDTO)));
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating person: " + personDTO);

        var person = mapper.toPerson(findById(personDTO.id()));
        if (person == null) throw new ResourceNotFoundException("Person not found with id: " + personDTO.id());

        person.setFirstName(personDTO.firstName());
        person.setLastName(personDTO.lastName());
        person.setEmail(personDTO.email());
        person.setPhone(personDTO.phone());
        person.setAddress(personDTO.address());

        return mapper.toPersonDTO(repository.save(person));
    }

    public void delete(Long id) {
        logger.info("Deleting person by id: " + id);
        Person person = mapper.toPerson(findById(id));
        repository.delete(person);
    }
}
