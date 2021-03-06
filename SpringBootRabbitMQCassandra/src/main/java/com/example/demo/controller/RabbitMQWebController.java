package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.RabbitMQSender;

/**
 * @author ANTARAMUKHERJEE
 *
 */
@RestController
@RequestMapping(value = "/employee-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("id") int id) {
	
	Employee emp=new Employee();
	emp.setId(id);
	emp.setFirstName(firstName);
	emp.setLastName(lastName);
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ employee Successfully";
	}

}
