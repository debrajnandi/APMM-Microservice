package com.example.demo.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

/**
 * @author ANTARAMUKHERJEE
 *
 */
public class Employee {
	@PrimaryKey
	private int id;

	private String firstName;

	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Employee[id=%s, firstName='%s', lastName='%s']", this.id,
				this.firstName, this.lastName);
	}
}

