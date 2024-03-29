package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/tasks")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TaskController {
    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<Task> task = service.getAllTasks();
        return ResponseEntity.ok(taskMapper.mapToTaskDtoList(task));
    }

    @GetMapping(value = "{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId) throws TaskNotFoundException {
        return ResponseEntity.ok(taskMapper.mapToTaskDto(service.getTask(taskId)));
    }

    @DeleteMapping(value = "{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) throws EmptyResultDataAccessException {
        service.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) throws TaskNotFoundException  {
            Task task = taskMapper.mapToTask(taskDto);
        if(service.ifTaskExists(task.getId())) {
            Task savedTask = service.saveTask(task);
            return ResponseEntity.ok(taskMapper.mapToTaskDto(savedTask));
        }else {
            throw new TaskNotFoundException();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
     Task savedTask = service.saveTask(taskMapper.mapToTask(taskDto));
        return ResponseEntity.ok(taskMapper.mapToTaskDto(savedTask));

    }
}
