package com.example.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "test_queue")
    public void consumeMessage(String message) {
        log.info("receive message - {}", message);
    }

    @RabbitListener(queues = "test_queue_json")
    public void consumeMessageJson(UserDto userDto) {
        log.info("receive message - {}", userDto.toString());
    }
}
