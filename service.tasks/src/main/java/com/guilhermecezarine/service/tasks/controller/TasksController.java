package com.guilhermecezarine.service.tasks.controller;

import com.guilhermecezarine.service.tasks.domain.TaskRequest;
import com.guilhermecezarine.service.tasks.domain.TasksEntity;
import com.guilhermecezarine.service.tasks.repository.TasksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksRepository tasksRepository;
    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @PostMapping
    public ResponseEntity<TasksEntity> createTask(@RequestBody TaskRequest request) {
        return ResponseEntity.ok(this.tasksRepository.save(new TasksEntity(request)));
    }
}
