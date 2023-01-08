package com.learnersacademy.model;

import java.io.Serializable;
import java.util.Date;
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
	private Subject subject;

	@Column(name = "date")
	private Date date;

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

	// Constructors

	public ClassX() {
		super();

	}

	public ClassX(Subject subject, Date date) {
		super();

		this.subject = subject;
		this.date = date;
	}

	public ClassX(int id, Subject subject, Date date) {
		super();
		this.id = id;
		this.subject = subject;
		this.date = date;
	}

}
