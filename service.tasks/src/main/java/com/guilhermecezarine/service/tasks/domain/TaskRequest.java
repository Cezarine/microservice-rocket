package com.guilhermecezarine.service.tasks.domain;

import lombok.NonNull;

import java.time.LocalDateTime;

public record TaskRequest(
        @NonNull
        String title,
        @NonNull
        String email,
        @NonNull
        LocalDateTime dueDate
) {
}
