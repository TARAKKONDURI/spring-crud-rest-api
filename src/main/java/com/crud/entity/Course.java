package com.crud.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<>();
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
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	public Set<Student> getStudents() {
		if(null == this.students) return new HashSet<>();
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Course(String name, Set<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}
	public Course(String name) {
		super();
		this.name = name;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
