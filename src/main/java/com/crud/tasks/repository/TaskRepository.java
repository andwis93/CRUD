package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("ALL")
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();


    Task save(Task task);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Task> findById(Long id);

    boolean existsById(Long id);

}
