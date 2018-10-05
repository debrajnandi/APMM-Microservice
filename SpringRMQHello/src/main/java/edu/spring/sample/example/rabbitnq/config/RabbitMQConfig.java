/**
 * 
 */
package edu.spring.sample.example.rabbitnq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SUMANPattanaik
 *
 */
@Configuration
public class RabbitMQConfig {
	
	@Value("${person.rabbitmq.queue}")
	private String queueName;
	
	@Value("${person.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${person.rabbitmq.routingkey}")
	private String routingKey;
	
	@Bean
	Queue queue(){
		return new Queue(queueName,false);
	}
	
	@Bean
	DirectExchange exchate(){
		return new DirectExchange(exchange);
	}
	
	@Bean
	Binding binding(DirectExchange exchange, Queue queue){
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
	
	@Bean
	public MessageConverter jsonConverter(){
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory){
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonConverter());
		return rabbitTemplate;
	}
}
