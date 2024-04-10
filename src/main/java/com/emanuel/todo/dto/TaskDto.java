package com.emanuel.todo.dto;

import com.emanuel.todo.entity.Person;
import com.emanuel.todo.util.TaskState;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskState state;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonDto person;

}
