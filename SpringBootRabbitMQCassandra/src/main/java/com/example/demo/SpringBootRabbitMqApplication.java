package com.example.demo;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

/**
 * @author ANTARAMUKHERJEE
 *
 */
@SpringBootApplication
@RabbitListener(queues="${employee.rabbitmq.queue}", containerFactory="jsaFactory")
public class SpringBootRabbitMqApplication {
	
	@Autowired
	private EmployeeRepository repository;
	
	@RabbitHandler
	public void process(@Payload Employee employee) {
		System.out.println(new Date() + "Message Received from Queue: " + employee  );
		
		//deleting existing records
		//System.out.println("Deleted existing records by calling deleteAll()");
		//System.out.println("------------------------------------");
		//this.repository.deleteAll();

		// save a couple of employee
		System.out.println("Inserting record in Employee table by calling save()");
		System.out.println("------------------------------------");
		this.repository.save(new Employee(employee.getId(), employee.getFirstName(), employee.getLastName()));
				

		// fetch all employees
		System.out.println("Employee found with findAll():");
		System.out.println("-------------------------------");
		for (Employee emp : this.repository.findAll()) {
			System.out.println(emp);
		}
		System.out.println();

		// fetch an individual employee
		System.out.println("Employee found with findByFirstName: " + employee.getFirstName());
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName(employee.getFirstName()));

		System.out.println("Employee found with findByLastName: " +employee.getLastName());
		System.out.println("--------------------------------");
		for (Employee emp : this.repository.findByLastName(employee.getLastName())) {
			System.out.println(emp);
		}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMqApplication.class, args);
	}
}
