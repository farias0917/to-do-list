package com.emanuel.todo.service;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.entity.Task;

import java.util.List;

public interface IPersonService {
    Person createPerson(PersonDto personDto);
    PersonDto getPerson(String username);
    List<PersonDto> getAll();
    void updatePerson(PersonDto personDto);
    void deletePerson(String username);
}
