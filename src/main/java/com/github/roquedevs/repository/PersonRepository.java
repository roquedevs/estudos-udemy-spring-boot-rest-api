package com.github.roquedevs.repository;

import com.github.roquedevs.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);
}
