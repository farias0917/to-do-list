package com.emanuel.todo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Data
@NoArgsConstructor
@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

    @Column(unique = true)
    private String username;

    @ManyToMany
    private List<Task> tasks;

    public Person(String name, String lastName, String username, List<Task> tasks) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.tasks = new List<Task>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Task> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Task task) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Task> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Task> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Task get(int index) {
                return null;
            }

            @Override
            public Task set(int index, Task element) {
                return null;
            }

            @Override
            public void add(int index, Task element) {

            }

            @Override
            public Task remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Task> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Task> listIterator(int index) {
                return null;
            }

            @Override
            public List<Task> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }

}
