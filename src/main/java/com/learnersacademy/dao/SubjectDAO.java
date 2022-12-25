package com.learnersacademy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.Subject;
import com.learnersacademy.util.HibernateUtil;

public class SubjectDAO {

	// saveSubject()
	public void saveSubject(Subject subject) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// updateSubject()
	public void updateSubject(Subject subject) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// deleteSubject()
	public void deleteSubject(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				session.delete(subject);
				System.out.println("subject is deleted");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// getSubject()
	public Subject getSubject(int id) {
		Transaction transaction = null;
		Subject subject = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return subject;
	}

	// getAllSubject(
	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubject() {

		Transaction transaction = null;

		List<Subject> listOfSubject = new ArrayList<Subject>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			listOfSubject = session.createQuery("from Subject").getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfSubject;
	}
}
