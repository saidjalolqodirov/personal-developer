package com.example.rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQController {
    private final RabbitMQProducer rabbitMQProducer;

    public RabbitMQController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("send message");
    }

    @GetMapping("/user")
    public ResponseEntity<String> sendMessage() {
        rabbitMQProducer.sendMessage(new UserDto("name",12,"address","phone","email"));
        return ResponseEntity.ok("send message");
    }
}
