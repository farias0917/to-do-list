package com.emanuel.todo.mapper.imp;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements Mapper<Person, PersonDto> {
    @Override
    public PersonDto fromEntityToDto(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .lastName(person.getLastName())
                .username(person.getUsername())
                .build();
    }


    /**
     * We don´t use the builder method because the entity doesn´t have it
     * @param personDto
     * @return Person
     */
    @Override
    public Person fromDtoToEntity(PersonDto personDto) {
        Person person = new Person();
        person.setName(textFormatter(personDto.getName()));
        person.setLastName(textFormatter(personDto.getLastName()));
        person.setUsername(personDto.getUsername());

        return person;
    }

    @Override
    public Person fromDtoToEntity(PersonDto personDto, Person person) {
        person.setName(textFormatter(personDto.getName()));
        person.setLastName(textFormatter(personDto.getLastName()));
        person.setUsername(personDto.getUsername());

        return person;
    }

    private String textFormatter(String text) {
        return text.substring(0, 1)
                .toUpperCase()
                .concat(text.substring(1));
    }
}
