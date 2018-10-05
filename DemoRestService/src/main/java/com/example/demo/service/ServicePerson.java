package com.example.demo.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;

@Service
public class ServicePerson {
	Hashtable<String, Person> person = new Hashtable<String, Person>();
	public ServicePerson() {
		Person p1 = new Person();
		p1.setId("1");
		p1.setName("Antara");
		p1.setAge("35");
		p1.setHeight("5 feet");
		
		person.put("1", p1);
		
		Person p2 = new Person();
		p2.setId("2");
		p2.setName("Adwitiya");
		p2.setAge("6");
		p2.setHeight("3.5 feet");
		
		person.put("2", p2);
	}
	
	public Hashtable<String, Person> getAllPersons() {
		return person;
	}
	
	public Person getPersonById(String id) {
		if(person.containsKey(id)) {
			return person.get(id);
		} else {
			return null;
		}
	}
}
