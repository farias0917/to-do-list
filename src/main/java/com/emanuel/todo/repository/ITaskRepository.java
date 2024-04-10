package com.emanuel.todo.repository;

import com.emanuel.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskByTitle(String title);

}
