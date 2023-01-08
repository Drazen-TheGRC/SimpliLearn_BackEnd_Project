package com.learnersacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "student_id")
	private String studentId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "classX")
	private String classX;

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassX() {
		return classX;
	}

	public void setClassX(String classX) {
		this.classX = classX;
	}

	// Constructors

	public Student() {
		super();

	}

	public Student(String studentId, String firstName, String lastName, int age) {
		super();

		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

	}

	public Student(String studentId, String firstName, String lastName, int age, String classX) {
		super();

		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.classX = classX;
	}

	public Student(int id, String studentId, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

	}

	public Student(int id, String studentId, String firstName, String lastName, int age, String classX) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.classX = classX;
	}
}
