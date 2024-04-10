package com.emanuel.todo.service;

import com.emanuel.todo.dto.TaskDto;
import com.emanuel.todo.entity.Task;

import java.util.List;

public interface ITaskService {
    Task addTask(Task task);
    TaskDto getTask(String title);

    List<TaskDto> getAllTask();

    void updateTask(TaskDto taskDto);

    void deleteTask(String title);

}
