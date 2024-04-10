package com.emanuel.todo.service.impl;

import com.emanuel.todo.dto.TaskDto;
import com.emanuel.todo.entity.Task;
import com.emanuel.todo.mapper.imp.TaskMapperImp;
import com.emanuel.todo.repository.ITaskRepository;
import com.emanuel.todo.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;
    private final TaskMapperImp taskMapper;

    public TaskServiceImpl(ITaskRepository taskRepository, TaskMapperImp taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }
    @Override
    public Task addTask(Task task) {
        Optional<Task> getTask = taskRepository.findTaskByTitle(task.getTitle());

        if (getTask.isPresent()){
            throw new RuntimeException("task '" + task.getTitle() + "' already exists");
        }else{
            //Task task = this.taskMapper.fromDtoToEntity(task);
            return taskRepository.save(task);
        }
    }

    @Override
    public TaskDto getTask(String title) {
        Optional<Task> findTask = this.taskRepository.findTaskByTitle(title);

        if (findTask.isPresent()){
            Task task = findTask.get();
            return taskMapper.fromEntityToDto(task);
        }else {
            throw new RuntimeException("task '" + title + "' not found'");
        }
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<Task> taskList = this.taskRepository.findAll();

        return taskList.stream().map(this.taskMapper::fromEntityToDto).toList();
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        Optional<Task> getTask = this.taskRepository.findTaskByTitle(taskDto.getTitle());

        if (getTask.isPresent()){
           Task task = this.taskMapper.fromDtoToEntity(taskDto);
           this.taskRepository.save(task);
        }
    }

    @Override
    public void deleteTask(String title) {
        Optional<Task> getTask = this.taskRepository.findTaskByTitle(title);

        if (getTask.isPresent()) {
            Task task = getTask.get();
            this.taskRepository.delete(task);
        } else {
            throw new RuntimeException("task not found");
        }
    }
}
