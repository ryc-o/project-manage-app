package com.example.todoapp.adapter;

import com.example.todoapp.model.Project;
import com.example.todoapp.model.ProjectRepository;
import com.example.todoapp.model.TaskGroup;
import com.example.todoapp.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {
    @Override
    @Query("FROM Project p JOIN FETCH p.steps ")
    List<Project> findAll();
}
