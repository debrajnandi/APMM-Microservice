package edu.spring.sample.example.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.spring.sample.example.rabbitmq.config.RabbitConfig;
import edu.spring.sample.example.rabbitmq.model.Order;

@Service
public class OrderMessageSender {
	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderMessageSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendOrder(Order order) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, order);
        /*
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            Message message = MessageBuilder
                                .withBody(orderJson.getBytes())
                                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                                .build();
            this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        */
    }
}
