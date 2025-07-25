package com.guilhermecezarine.service.tasks.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Task")
@Table(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String email;

    private LocalDateTime dueDate;

    private Boolean notified;

    public TasksEntity(TaskRequest request) {
        this(
                null,
                request.title(),
                request.email(),
                request.dueDate(),
                Boolean.FALSE
        );
    }
}
