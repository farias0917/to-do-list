package com.emanuel.todo.controller;

import com.emanuel.todo.dto.TaskDto;
import com.emanuel.todo.entity.Task;
import com.emanuel.todo.service.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    public final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createTask(@RequestBody Task task){
        Map<String, String> response = new HashMap<>();
        try {
            this.taskService.addTask(task);
            response.put("message", "Task have been created!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (RuntimeException e){
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            response.put("message", "Internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{title}")
    public TaskDto getTask(@PathVariable("title") String title){
        return taskService.getTask(title);
    }


    @GetMapping
    public List<TaskDto> getAllTask(){
        return this.taskService.getAllTask();
    }

    @PutMapping
    public void updateTask(@RequestBody TaskDto taskDto){
        this.taskService.updateTask(taskDto);
    }

    @DeleteMapping("{title}")
    public ResponseEntity<Map<String,String>> deleteTask(@PathVariable("title") String title){
        Map<String, String> response = new HashMap<>();
        try {
            taskService.deleteTask(title);
            response.put("message", "task has been deleted!");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
