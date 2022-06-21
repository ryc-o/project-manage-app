package com.example.todoapp.logic;

import com.example.todoapp.TaskConfigurationProperties;
import com.example.todoapp.model.ProjectRepository;
import com.example.todoapp.model.TaskGroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {
    @Bean
    ProjectService service(
            ProjectRepository repository,
            TaskGroupRepository taskGroupRepository,
            TaskConfigurationProperties config){
        return new ProjectService(repository, taskGroupRepository, config);
    }
}
