package com.example.todoapp.logic;

import com.example.todoapp.TaskConfigurationProperties;
import com.example.todoapp.model.*;
import com.example.todoapp.model.projection.GroupReadModel;
import com.example.todoapp.model.projection.GroupTaskWriteModel;
import com.example.todoapp.model.projection.GroupWriteModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectService {
    private ProjectRepository repository;
    private TaskGroupRepository taskGroupRepository;
    private TaskGroupService service;
    private TaskConfigurationProperties config;

    public ProjectService(ProjectRepository repository, TaskGroupRepository taskGroupRepository, TaskGroupService service, TaskConfigurationProperties config) {
        this.repository = repository;
        this.taskGroupRepository = taskGroupRepository;
        this.service = service;
        this.config = config;
    }

    public List<Project> readAll() {
        return repository.findAll();
    }

    public Project save(ProjectWriteModel toSave){
        return repository.save(toSave.toProject());
    }

    public GroupReadModel createGroup(LocalDateTime deadline, int projectId) {
        if (config.getTemplate().isAllowMultipleTasks() && taskGroupRepository.existsByDoneIsFalseAndProject_Id(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        return repository.findById(projectId)
                .map(project -> {
                    var targetGroup = new GroupWriteModel();
                    targetGroup.setTasks((
                            project.getSteps().stream()
                                    .map(projectStep -> {
                                        var task = new GroupTaskWriteModel();
                                        task.setDescription(projectStep.getDescription());
                                        task.setDeadline(deadline.plusDays(projectStep.getDaysToDeadline()));
                                        return task;
                                    }
                            ).collect(Collectors.toSet()))
                    );
                    return service.createGroup(targetGroup, project);
                }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
    }

}
