package com.example.demo.controller;

import java.util.Hashtable;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.ServicePerson;

@RestController
@RequestMapping("/persons")
public class DemoController {

		@Autowired
		private ServicePerson servicePerson;
		
		@RequestMapping(value="/getPersonData",method=RequestMethod.GET)
		public Hashtable<String, Person> getAllPersons() {
			return servicePerson.getAllPersons();
		}
		
		@RequestMapping("{id}")
		public Person getPersonById(@PathVariable("id") String id) {
			return servicePerson.getPersonById(id);
		}
}
