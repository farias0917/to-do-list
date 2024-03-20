package com.emanuel.todo.repository;

import com.emanuel.todo.entity.TagTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagTaskRepository extends JpaRepository<TagTask, Long> {
}
