package com.emanuel.todo.service;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.entity.Task;

import java.util.List;

public interface IPersonService {
    void createPerson(String name, String lastName, String username);
    PersonDto getPerson(String username);
    List<PersonDto> getAll();
    void updatePerson(String username, String name, String lastName);
    void deletePerson(String username);
    List<Task> getTasks(String username);
}
