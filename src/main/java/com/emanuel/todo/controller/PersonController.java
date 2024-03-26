package com.emanuel.todo.controller;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final IPersonService personService;


    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void createPerson(@RequestBody Person person){
        this.personService.createPerson(person.getName(), person.getLastName(), person.getUsername());
    }

    @GetMapping("{userName}")
    public PersonDto getPerson(@PathVariable("userName") String userName){
        return personService.getPerson(userName);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping
    public void updatePerson(@RequestBody PersonDto personDto){
        this.personService.updatePerson(personDto.getUsername(), personDto.getName(), personDto.getLastName());
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("{userName}")
    public void deletePerson(@PathVariable("userName") String userName){
        personService.deletePerson(userName);
    }

    @GetMapping
    public List<PersonDto> getAll(){
        return personService.getAll();
    }
}
