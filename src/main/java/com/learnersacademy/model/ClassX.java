package com.learnersacademy.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.learnersacademy.dao.SubjectDAO;
import com.learnersacademy.dao.TeacherDAO;

@Entity
@Table(name = "classes")
public class ClassX implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "subject_id")
	private int subjectId;

	@Column(name = "teacher_id")
	private int teacherId;

	@Column(name = "date")
	private String date;
	
	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public Subject getSubject() {
		SubjectDAO subjectDAO = new SubjectDAO();
		Subject subject = subjectDAO.getSubject(subjectId);
		return subject;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public Teacher getTeacher() {
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = teacherDAO.getTeacher(teacherId);
		return teacher;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	}

	public ClassX(int subjectId, int teacherId, String date) {
		super();

		this.subjectId = subjectId;
		this.teacherId = teacherId;
		this.date = date;
	}

	public ClassX(int id, int subjectId, int teacherId, String date) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
		this.date = date;
	}

}
