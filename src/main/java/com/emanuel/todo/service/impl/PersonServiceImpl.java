package com.emanuel.todo.service.impl;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.entity.Task;
import com.emanuel.todo.mapper.imp.PersonMapperImpl;
import com.emanuel.todo.repository.IPersonRepository;
import com.emanuel.todo.service.IPersonService;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository personRepository;
    private final PersonMapperImpl personMapper;
    
    public PersonServiceImpl(IPersonRepository personRepository, PersonMapperImpl personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }
    @Override
    public void createPerson(String name, String lastName, String username) {
        String nameFormater = name.substring(0,1).toUpperCase().concat(name.substring(1, name.length()));
        String lastNameFormater = lastName.substring(0,1).toUpperCase().concat(lastName.substring(1, lastName.length()));

        Person person = new Person(nameFormater, lastNameFormater, username, List.of());
        Optional<Person> getPerson = this.personRepository.findPersonByUsername(username);

        if (getPerson.isPresent())
            throw new RuntimeException("UserName " + username + " already exist");
        else
            this.personRepository.save(person);

    }


    @Override
    public PersonDto getPerson(String username) {

        Optional<Person> findPerson = personRepository.findPersonByUsername(username);

        if (findPerson.isPresent()){
            Person person = findPerson.get();

            PersonDto personDto = personMapper.fromEntityToDto(person);
            return personDto;
        }else
            throw new RuntimeException("UserName '" + username + "' not found");
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = this.personRepository.findAll();
        List<PersonDto> personDtoList = personList.stream().map(person -> personMapper.fromEntityToDto(person)).collect(Collectors.toList());

        return personDtoList;
    }

    @Override
    public void updatePerson(String username, String name, String lastName) {
        Optional<Person> updatePerson = this.personRepository.findPersonByUsername(username);

        if (updatePerson.isPresent()){
            Person person = updatePerson.get();
            person.setName(name);
            person.setLastName(lastName);
            this.personRepository.save(person);
        } else throw new RuntimeException("Person not found");

    }

    @Override
    public void deletePerson(String username) {
        Optional<Person> findPerson = personRepository.findPersonByUsername(username);

        if (findPerson.isPresent()) {
            Person deletePerson = findPerson.get();
            personRepository.delete(deletePerson);
        } else
            throw  new RuntimeException("Person not Found");
    }

    @Override
    public List<Task> getTasks(String username) {
        return null;
    }
}
