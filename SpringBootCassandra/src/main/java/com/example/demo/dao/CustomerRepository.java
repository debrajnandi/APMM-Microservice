package com.example.demo.dao;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{
	@Query("Select * from customer where firstname=?0")
	Customer findByFirstName(String firstName);

	@Query("Select * from customer where lastname=?0")
	List<Customer> findByLastName(String lastName);

}
