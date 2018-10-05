/**
 * 
 */
package edu.spring.sample.example.rabbitnq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.sample.example.rabbitnq.model.Person;
import edu.spring.sample.example.rabbitnq.service.RabbitMQSender;

/**
 * @author SUMANPattanaik
 *
 */
@RestController
@RequestMapping(value="/rabbitmq/")
public class RabbitMQWebController {
	
	@Autowired
	RabbitMQSender mqSender;
	
	@GetMapping("/push-1")
	public String produce(
			@RequestParam Long idNumber,
			@RequestParam String firstName,
			@RequestParam String lastName, int age){
		
		return push(idNumber,firstName,null,lastName,age);
	}
	
	@GetMapping("/push-2")
	public String produce(
			@RequestParam Long idNumber,
			@RequestParam String firstName,
			@RequestParam String middleName,
			@RequestParam String lastName, int age){
		return push(idNumber,firstName,middleName,lastName,age);
	}
	
	@GetMapping("/push-3")
	public String produce(@RequestBody Person person){
		return push(person);
	}
	
	private String push(Long idNumber,
			String firstName,
			String middleName,
			String lastName, int age){
		Person person = new Person();
		
		person.setIdNumber(idNumber);
		person.setFirstName(firstName);
		person.setMiddleName(middleName);
		person.setLastName(lastName);
		person.setAge(age);
		
		return push(person);
	}
	
	private String push(Person person){
		mqSender.send(person);
		return "Message sent to RabbitMQ sucessfully";
	}

}
