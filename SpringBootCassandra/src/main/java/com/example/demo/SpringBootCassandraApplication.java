package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.datastax.driver.core.utils.UUIDs;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;

@SpringBootApplication
public class SpringBootCassandraApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		//deleting existing records
		System.out.println("Deleted existing records by calling deleteAll()");
		System.out.println("------------------------------------");
		this.repository.deleteAll();

		// save a couple of customers
		System.out.println("Inserting records by calling save()");
		System.out.println("------------------------------------");
		this.repository.save(new Customer(UUIDs.timeBased(), "Antara", "Mukherjee"));
		this.repository.save(new Customer(UUIDs.timeBased(), "Adwitiya", "Dey"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Antara'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Antara"));

		System.out.println("Customers found with findByLastName('Dey'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Dey")) {
			System.out.println(customer);
		}
}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraApplication.class, args);
	}
}
