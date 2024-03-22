package com.emanuel.todo.service.impl;

import com.emanuel.todo.entity.Person;
import com.emanuel.todo.entity.Task;
import com.emanuel.todo.repository.IPersonRepository;
import com.emanuel.todo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public void createPerson(String name, String lastName, String username) {
        Person person = new Person(name, lastName, username, List.of());
        personRepository.save(person);
    }

    @Override
    public Optional<Person> getPerson(String username) {
        if (personRepository.findPersonByUsername(username).isPresent()){
            return personRepository.findPersonByUsername(username);
        }
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void updatePerson(String username, String name, String lastName) {
        Optional<Person> person = personRepository.findPersonByUsername(username);

        if (person.isPresent()){
            person.get().setName(name);
            person.get().setLastName(lastName);
            personRepository.save(person.get());
        } else {
            throw new RuntimeException("Person not found");
        }
    }

    @Override
    public void deletePerson(String username) {

    }

    @Override
    public List<Task> getTasks(String username) {
        return null;
    }
}
