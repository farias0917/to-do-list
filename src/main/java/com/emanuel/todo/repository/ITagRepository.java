package com.emanuel.todo.repository;

import com.emanuel.todo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagRepository extends JpaRepository<Tag, Long> {
}
