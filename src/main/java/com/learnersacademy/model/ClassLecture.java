package com.learnersacademy.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class ClassLecture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "subject")
	private Subject subject;

	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private Time time;
	
	@Column(name = "student_list")
	private List<Student> studentList;
	
	
	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	
	// Constructors
	
	public ClassLecture() {
		super();
		
	}
	
	public ClassLecture(Subject subject, Date date, Time time, List<Student> studentList) {
		super();
		
		this.subject = subject;
		this.date = date;
		this.time = time;
		this.studentList = studentList;
	}
	
	public ClassLecture(int id, Subject subject, Date date, Time time, List<Student> studentList) {
		super();
		this.id = id;
		this.subject = subject;
		this.date = date;
		this.time = time;
		this.studentList = studentList;
	}
	
	
	
	
	
	
	
}
