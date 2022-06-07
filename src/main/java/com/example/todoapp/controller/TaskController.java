package com.example.todoapp.controller;

import com.example.todoapp.model.SqlTaskRepository;
import com.example.todoapp.model.Task;
import com.example.todoapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    public TaskController(final TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<?> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/tasks")
    ResponseEntity<?> readAllTasks(Pageable page) {
        logger.info("Custom pageable!");
        return ResponseEntity.ok(repository.findAll(page));
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@RequestBody Task toUpdate) {
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
