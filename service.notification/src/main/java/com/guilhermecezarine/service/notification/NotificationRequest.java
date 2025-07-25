package com.guilhermecezarine.service.notification;

public record NotificationRequest(
        String message,
        String email
) {
}
