package com.learnersacademy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.ClassLecture;
import com.learnersacademy.util.HibernateUtil;

public class ClassLectureDAO {

	// saveClassLecture()
	public void saveClassLecture(ClassLecture classLecture) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(classLecture);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// updateClassLecture()
	public void updateClassLecture(ClassLecture classLecture) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(classLecture);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// deleteClassLecture()
	public void deleteClassLecture(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ClassLecture classLecture = session.get(ClassLecture.class, id);
			if (classLecture != null) {
				session.delete(classLecture);
				System.out.println("classLecture is deleted");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// getClassLecture()
	public ClassLecture getClassLecture(int id) {
		Transaction transaction = null;
		ClassLecture classLecture = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			classLecture = session.get(ClassLecture.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return classLecture;
	}

	// getAllClassLecture()
	@SuppressWarnings("unchecked")
	public List<ClassLecture> getAllClassLecture() {

		Transaction transaction = null;

		List<ClassLecture> listOfClassLecture = new ArrayList<ClassLecture>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			listOfClassLecture = session.createQuery("from ClassLecture").getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfClassLecture;
	}
}
