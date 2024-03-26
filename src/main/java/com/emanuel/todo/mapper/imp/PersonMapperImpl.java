package com.emanuel.todo.mapper.imp;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements Mapper<Person, PersonDto> {
    @Override
    public PersonDto fromEntityToDto(Person person) {

        PersonDto personDto = new PersonDto(
                person.getName(), person.getLastName(), person.getUsername(), person.getTasks()
        );

        return personDto;
    }

    @Override
    public Person fromDtoToEntity(PersonDto personDto) {
        Person person = new Person(
                personDto.getName(), personDto.getLastName(), personDto.getUsername(),personDto.getTasks()
        );

        return person;
    }
}
