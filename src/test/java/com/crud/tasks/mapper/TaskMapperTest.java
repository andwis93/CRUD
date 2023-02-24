package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskMapperTest {
//    @Autowired
//    private TaskMapper taskMapper;
//
//    @Test
//    void testMapToTaskDtoList() {
//        //Given
//        List<Task> taskList = List.of(new Task(1L, "Task1", "Description1"),
//                new Task(2L, "Task2", "Description2"));
//
//        //When
//        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);
//
//        //Then
//        assertEquals(2, taskDtos.size());
//    }
//
//    @Test
//    void testMapToTaskDto() {
//        //Given
//        Task task = new Task(1L, "Task", "Description");
//
//        //When
//        TaskDto taskDto = taskMapper.mapToTaskDto(task);
//
//        //Then
//        assertNotNull(taskDto);
//        assertEquals(1L, taskDto.getId());
//    }
//
//    @Test
//    void testMapToTask() {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "Task", "Content");
//
//        //When
//        Task task = taskMapper.mapToTask(taskDto);
//
//        //Then
//        assertNotNull(task);
//        assertEquals(1L, task.getId());
//    }
}
