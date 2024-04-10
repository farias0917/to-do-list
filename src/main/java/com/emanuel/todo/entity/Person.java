package com.emanuel.todo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@NoArgsConstructor
@Entity

public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    //@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Task> tasks;

    public Person(String name, String lastName, String username) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        //this.tasks = new ArrayList<>(tasks);
    }

   /* public void addTask(Task task) {
        tasks.add(task);
    }*/
}
