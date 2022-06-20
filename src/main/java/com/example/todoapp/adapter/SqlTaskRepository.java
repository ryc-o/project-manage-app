package com.example.todoapp.adapter;

import com.example.todoapp.model.Task;
import com.example.todoapp.model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
    @Override
    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM TASKS WHERE ID = :id")
    boolean existsById(@Param("id") Integer id);

    List<Task> findByDone(@Param("state") boolean done);

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
}