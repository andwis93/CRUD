package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @GetMapping(path ="/taskDtoList")
    public List<TaskDto> getTasks() {
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1L,"First element","First content"));
        taskDtoList.add(new TaskDto(2L,"Second element","Second content"));
        taskDtoList.add(new TaskDto(3L,"Third element","Third content"));
        return new ArrayList<>(taskDtoList);
    }

    @GetMapping(value = "{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @DeleteMapping(value = "{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
    }

    @PutMapping(value = "{taskId}")
    public TaskDto updateTask(@PathVariable("taskId") Long taskId, TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @PostMapping(value = "{taskId}")
    public void createTask(@PathVariable Long taskId, TaskDto taskDto) {
    }
}
