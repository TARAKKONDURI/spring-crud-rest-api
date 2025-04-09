package com.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findByName",query = "select e from Employee e where e.name LIKE :name")
public class Employee {

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

}
