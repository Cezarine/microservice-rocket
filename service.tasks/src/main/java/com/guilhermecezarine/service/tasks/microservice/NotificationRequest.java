package com.guilhermecezarine.service.tasks.microservice;

public record NotificationRequest(
        String message,
        String email
) {
}
