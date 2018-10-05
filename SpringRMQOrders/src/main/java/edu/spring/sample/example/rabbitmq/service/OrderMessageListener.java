package edu.spring.sample.example.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import edu.spring.sample.example.rabbitmq.config.RabbitConfig;
import edu.spring.sample.example.rabbitmq.model.Order;

@Component
public class OrderMessageListener {
	static final Logger logger = LoggerFactory.getLogger(OrderMessageListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void processOrder(Order order) {
        logger.info("Order Received: "+order);
    }
}
