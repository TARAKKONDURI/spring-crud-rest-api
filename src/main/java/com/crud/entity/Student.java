package com.crud.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			
			name = "student_course", 
			joinColumns = @JoinColumn(name = "student_id"), 
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		if(null == this.courses) return new HashSet<>();
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Student(int id, String name, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courses=" + courses + "]";
	}

	public Student(String name, Set<Course> courses) {
		super();
		this.name = name;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
	}

}
