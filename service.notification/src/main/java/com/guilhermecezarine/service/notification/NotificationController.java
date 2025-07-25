package com.guilhermecezarine.service.notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        System.out.println(notificationRequest.message());
        return ResponseEntity.ok().build();
    }
}
