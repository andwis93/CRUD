package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class DbServiceTest {
    @Autowired
    private DbService dbService;
    @Autowired
    private TaskRepository taskRepository;


    @Test
    void testFindAllTasks() throws TaskNotFoundException {
        //Given
        Task theTask = null;
        Task task1 = new Task( 1L,"Title1", "Content1");
        Task task2 = new Task(2L,"Title2", "Content2");
        dbService.saveTask(task1);
        dbService.saveTask(task2);

        //When
        List<Task> taskList = dbService.getAllTasks();
        Long id = taskList.get(0).getId();
        if (dbService.ifTaskExists(id)) {
            theTask = dbService.getTask(id);
        }
        dbService.deleteTask(id);
        List<Task> taskList2 = dbService.getAllTasks();

        //Then
        assertEquals(2,taskList.size());
        assertNotNull(theTask);
        assertEquals("Title1", theTask.getTitle());
        assertEquals(1,taskList2.size());

        //CleanUp
        taskRepository.deleteAll();
    }
}
