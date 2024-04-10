package com.emanuel.todo.mapper.imp;

import com.emanuel.todo.dto.PersonDto;
import com.emanuel.todo.dto.TaskDto;
import com.emanuel.todo.entity.Person;
import com.emanuel.todo.entity.Task;
import com.emanuel.todo.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImp implements Mapper<Task, TaskDto> {

    @Override
    public TaskDto fromEntityToDto(Task task) {

       // String userName = task.getPerson().getUsername();

        PersonDto personDto = PersonDto.builder()
                .name(task.getPerson().getName())
                .lastName(task.getPerson().getLastName())
                .username(task.getPerson().getUsername()).build();

        return TaskDto.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .state(task.getState())
                .person(personDto).build();
    }

    @Override
    public Task fromDtoToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setState(taskDto.getState());
       // task.setPerson(taskDto.getPerson());
        return task;
    }

    @Override
    public Task fromDtoToEntity(TaskDto taskDto, Task task) {
        return null;
    }
}
