package com.learnersacademy.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class ClassX implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "subject")
	private String subject;

	@Column(name = "date")
	private String date;
	
	// Getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	// Constructors

	public ClassX() {
		super();
;
	}

	public ClassX(String subject, String date) {
		super();

		this.subject = subject;
		this.date = date;
	}
	
	public ClassX(int id, String subject, String date) {
		super();
		this.id = id;
		this.subject = subject;
		this.date = date;
	}

}
