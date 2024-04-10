package com.emanuel.todo.entity;

import com.emanuel.todo.util.TaskState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskState state;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;


    public Task(String title, String description, TaskState state, List<Tag> tags) {
        this.title = title;
        this.description = description;
        this.state = state;
        this.tags = new ArrayList<>(tags);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }
}
