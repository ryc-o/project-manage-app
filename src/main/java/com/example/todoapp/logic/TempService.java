package com.example.todoapp.logic;

import com.example.todoapp.model.Task;
import com.example.todoapp.model.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class TempService {
    @Autowired
    void temp(TaskGroupRepository taskGroupRepository){
        taskGroupRepository.findAll().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toList());
    };
}
