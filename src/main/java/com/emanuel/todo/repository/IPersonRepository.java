package com.emanuel.todo.repository;

import com.emanuel.todo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByUsername(String username);
}
