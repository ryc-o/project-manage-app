package com.example.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @NotBlank(message = "Task's description most be not null and not empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

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

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public TaskGroup getGroup() {
        return group;
    }

    public void setGroup(TaskGroup group) {
        this.group = group;
    }

    public void updateFrom(final Task source){
        description = source.description;
        done = source.done;
        deadline = source.deadline;
        group = source.group;
    }

}
