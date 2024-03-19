package com.emanuel.todo.entity;

import com.emanuel.todo.util.EstadoTarea;
import jakarta.persistence.*;
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
    private String title;
    private String description;
    private EstadoTarea state;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TagTask> tags;


    public Task(String title, String descripcion, EstadoTarea estado, List<TagTask> tags) {
        this.title = title;
        this.description = description;
        this.state = state;
        this.tags = new ArrayList<>(tags);
    }

    public void addTag(TagTask tag) {
        tags.add(tag);
    }
}
