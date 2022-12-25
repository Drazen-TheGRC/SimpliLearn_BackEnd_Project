package com.learnersacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "subject")
	private String subjectName;

	@Column(name = "subject_shortcut")
	private String subjectShortcut;
	
	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectShortcut() {
		return subjectShortcut;
	}

	public void setSubjectShortcut(String subjectShortcut) {
		this.subjectShortcut = subjectShortcut;
	}
	
	// Constructors

	public Subject() {
		super();

	}

	public Subject(String subjectName, String subjectShortcut) {
		super();

		this.subjectName = subjectName;
		this.subjectShortcut = subjectShortcut;
	}

	public Subject(int id, String subjectName, String subjectShortcut) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.subjectShortcut = subjectShortcut;
	}

}
