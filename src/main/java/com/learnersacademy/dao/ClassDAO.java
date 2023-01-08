package com.learnersacademy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.ClassX;
import com.learnersacademy.util.HibernateUtil;

public class ClassDAO {

	// saveClassX()
	public void saveClassX(ClassX classX) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(classX);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// updateClassX()
	public void updateClassX(ClassX classX) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(classX);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// deleteClassX()
	public void deleteClassX(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ClassX classX = session.get(ClassX.class, id);
			if (classX != null) {
				session.delete(classX);
				System.out.println("classX is deleted");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// getClassX()
	public ClassX getClassX(int id) {
		Transaction transaction = null;
		ClassX classX = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			classX = session.get(ClassX.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return classX;
	}

	// getAllClassX()
	@SuppressWarnings("unchecked")
	public List<ClassX> getAllClassX() {

		Transaction transaction = null;

		List<ClassX> listOfClassX = new ArrayList<ClassX>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			listOfClassX = session.createQuery("from ClassX").getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfClassX;
	}
}
