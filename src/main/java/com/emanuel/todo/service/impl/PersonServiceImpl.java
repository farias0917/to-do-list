package com.emanuel.todo.service.impl;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.mapper.imp.PersonMapperImpl;
import com.emanuel.todo.repository.IPersonRepository;
import com.emanuel.todo.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository personRepository;
    private final PersonMapperImpl personMapper;

    public PersonServiceImpl(IPersonRepository personRepository, PersonMapperImpl personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person createPerson(PersonDto personDto) {

        Optional<Person> getPerson = this.personRepository.findPersonByUsername(personDto.getUsername());

        if (getPerson.isPresent())
            throw new RuntimeException("the username " + personDto.getUsername() + " already exist");
        else {
            Person person = personMapper.fromDtoToEntity(personDto);
            return personRepository.save(person);
        }

    }


    @Override
    public PersonDto getPerson(String username) {

        Optional<Person> findPerson = personRepository.findPersonByUsername(username);

        if (findPerson.isPresent()) {
            Person person = findPerson.get();
            return personMapper.fromEntityToDto(person);

        } else
            throw new RuntimeException("UserName '" + username + "' not found");
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = this.personRepository.findAll();


        return personList.stream().map(personMapper::fromEntityToDto).toList();


    }

    @Override
    public void updatePerson(PersonDto personDto) {
        Optional<Person> updatePerson = this.personRepository.findPersonByUsername(personDto.getUsername());

        if (updatePerson.isPresent()) {
            Person person = updatePerson.get();
            this.personMapper.fromDtoToEntity(personDto,person);
            this.personRepository.save(person);
        }

    }

    @Override
    public void deletePerson(String userName) {
        Optional<Person> findPerson = personRepository.findPersonByUsername(userName);

        if (findPerson.isPresent()) {
            Person deletePerson = findPerson.get();
            personRepository.delete(deletePerson);
        } else
            throw new RuntimeException("Person not Found");
    }

}
