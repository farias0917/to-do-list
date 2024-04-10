package com.emanuel.todo.controller;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final IPersonService personService;


    public PersonController(IPersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<Map<String, Object>> createPerson(@RequestBody PersonDto personDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            this.personService.createPerson(personDto);
            response.put("message", "User has been created!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.put("message", "Internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updatePerson(@RequestBody PersonDto personDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            this.personService.updatePerson(personDto);
            response.put("message", "User has been updated!");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (RuntimeException e){
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("{userName}")
    public PersonDto getPerson(@PathVariable("userName") String userName) {
        return personService.getPerson(userName);
    }


    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("{userName}")
    public ResponseEntity<Map<String, Object>> deletePerson(@PathVariable("userName") String userName) {
        Map<String, Object> response = new HashMap<>();
        try {
            personService.deletePerson(userName);
            response.put("message", "User has been deleted!");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public List<PersonDto> getAll() {
        return personService.getAll();
    }
}
