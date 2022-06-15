package com.example.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASKS")
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @NotBlank(message = "Task's description most be not null and not empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    //@Column(name = "CREATED_ON")
    private LocalDateTime createdOn;
    //@Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

    public Task() {
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

    void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void updateFrom(final Task source){
        description = source.description;
        done = source.done;
        deadline = source.deadline;
    }

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
