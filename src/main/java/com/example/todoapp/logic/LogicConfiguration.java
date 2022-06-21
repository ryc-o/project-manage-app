package com.example.todoapp.logic;

import com.example.todoapp.TaskConfigurationProperties;
import com.example.todoapp.model.ProjectRepository;
import com.example.todoapp.model.TaskGroupRepository;
import com.example.todoapp.model.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {
    @Bean
    ProjectService projectService(
            ProjectRepository repository,
            TaskGroupRepository taskGroupRepository,
            TaskGroupService service,
            TaskConfigurationProperties config
    ){
        return new ProjectService(repository, taskGroupRepository, service, config);
    }

    @Bean
    TaskGroupService taskGroupService(
            TaskGroupRepository repository,
            TaskRepository taskRepository
    ){
        return new TaskGroupService(repository, taskRepository);
    }
}
