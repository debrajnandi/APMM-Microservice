package com.example.demo;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.demo.model.Employee;

@SpringBootApplication
@RabbitListener(queues="${javainuse.rabbitmq.queue}", containerFactory="jsaFactory")
public class SpringBootRabbitMqApplication {
	
	@RabbitHandler
	public void process(@Payload Employee employee) {
		System.out.println(new Date() + ": " + employee  );
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMqApplication.class, args);
	}
}
