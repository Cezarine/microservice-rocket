package com.guilhermecezarine.service.tasks.scheduler;

import com.guilhermecezarine.service.tasks.service.TasksService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {
    private final TasksService tasksService;
    public TaskNotificationSchedule(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void checkAndNotifyTasks() {
        this.tasksService.sendNotificationForDueTasks();
    }
}
