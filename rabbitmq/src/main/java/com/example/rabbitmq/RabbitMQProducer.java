package com.example.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        log.info("send message - {}", message);
        rabbitTemplate.convertAndSend("test_exchange", "test_routing_key", message);
    }

    public void sendMessage(UserDto userDto) {
        log.info("send message - {}", userDto.toString());
        rabbitTemplate.convertAndSend("test_exchange", "test_routing_key_json", userDto);
    }
}
