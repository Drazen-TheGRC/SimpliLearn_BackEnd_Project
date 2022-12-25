package com.learnersacademy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.Student;
import com.learnersacademy.util.HibernateUtil;

public class StudentDAO {

	// saveStudent()
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// updateStudent()
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// deleteStudent()
	public void deleteStudent(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
				System.out.println("student is deleted");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// getStudent()
	public Student getStudent(int id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	// getAllStudent()
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {

		Transaction transaction = null;

		List<Student> listOfStudent = new ArrayList<Student>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			listOfStudent = session.createQuery("from Student").getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfStudent;
	}
}
