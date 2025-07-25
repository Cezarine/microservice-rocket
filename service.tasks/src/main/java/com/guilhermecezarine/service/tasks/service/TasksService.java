package com.guilhermecezarine.service.tasks.service;

import com.guilhermecezarine.service.tasks.domain.TasksEntity;
import com.guilhermecezarine.service.tasks.microservice.NotificationClient;
import com.guilhermecezarine.service.tasks.microservice.NotificationRequest;
import com.guilhermecezarine.service.tasks.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private final NotificationClient notificationClient;

    public TasksService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public void sendNotificationForDueTasks() {
        LocalDateTime deadLine = LocalDateTime.now().plusDays(1);
        List<TasksEntity> tasks = tasksRepository.findTasksDueWithinDeadline(deadLine);

        tasks.forEach(t -> {
            NotificationRequest request = new NotificationRequest("Sua tarefa: " + t.getTitle() + " está prestes a vencer.", t.getEmail());
            notificationClient.sendNotification(request);
            t.setNotified(Boolean.TRUE);
            tasksRepository.save(t);
        });
    }
}
