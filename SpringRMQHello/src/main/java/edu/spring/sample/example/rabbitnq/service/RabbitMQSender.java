/**
 * 
 */
package edu.spring.sample.example.rabbitnq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.spring.sample.example.rabbitnq.model.Person;;

/**
 * @author SUMANPattanaik
 *
 */
@Service
public class RabbitMQSender {
	
	@Autowired
	AmqpTemplate rabbitTemplate;
	
	@Value("${person.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${person.rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Person person){
		rabbitTemplate.convertAndSend(exchange, routingKey, person);
		System.out.println("Sending message.. "+person.toString());
	}
}
