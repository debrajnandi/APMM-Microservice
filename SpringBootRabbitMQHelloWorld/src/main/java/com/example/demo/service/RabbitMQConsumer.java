/*package com.example.demo.service;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class RabbitMQConsumer {
	@RabbitListener(queues="${javainuse.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Employee employee) {
        System.out.println("Recieved Message: " + employee);
        
    }
}
*/