package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTask(final Long taskId) throws TaskNotFoundException {
        return repository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }
    public boolean ifTaskExists(final Long taskId)  {
       return repository.existsById(taskId);
    }

    public Task saveTask(final Task task)  {
        return repository.save((Task)task);
    }

    public void deleteTask(final Long taskId) throws EmptyResultDataAccessException {
            repository.deleteById(taskId);
    }

}
