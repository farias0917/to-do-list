package com.emanuel.todo.service;

import com.emanuel.todo.entity.Person;
import com.emanuel.todo.entity.Task;

import java.util.List;
import java.util.Optional;

public interface IPersonService {
    void createPerson(String name, String lastName, String username);
    Optional<Person> getPerson(String username);
    List<Person> getAll();
    void updatePerson(String username, String name, String lastName);
    void deletePerson(String username);
    List<Task> getTasks(String username);
}
