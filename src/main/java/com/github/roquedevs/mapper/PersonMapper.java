package com.github.roquedevs.mapper;

import com.github.roquedevs.dto.PersonDTO;
import com.github.roquedevs.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPerson(PersonDTO personDTO);

    PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonDTOList(List<Person> persons);
}
