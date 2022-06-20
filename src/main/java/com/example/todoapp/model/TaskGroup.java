package com.example.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Entity
@Table(name = "TASK_GROUPs")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @NotBlank(message = "Task group's description most be not null and not empty")
    private String description;
    private boolean done;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;
    @ManyToOne()
    @JoinColumn(name = "project_id")
    private Project project;

    public TaskGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
