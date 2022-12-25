package com.learnersacademy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.Admin;
import com.learnersacademy.util.HibernateUtil;

public class AdminDAO {

	public boolean validateAdmin(String userName, String password) {

		Transaction transaction = null;

		Admin admin = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			admin = (Admin) session.createQuery("FROM Admin A WHERE A.username = :userName")
					.setParameter("userName", userName).uniqueResult();

			if (admin != null && admin.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	// saveAdmin()
	public void saveAdmin(Admin admin) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(admin);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// updateAdmin()
	public void updateAdmin(Admin admin) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(admin);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// deleteAdmin()
	public void deleteAdmin(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Admin admin = session.get(Admin.class, id);
			if (admin != null) {
				session.delete(admin);
				System.out.println("admin is deleted");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// getAdmin()
	public Admin getAdmin(int id) {
		Transaction transaction = null;
		Admin admin = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			admin = session.get(Admin.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return admin;
	}

	//getAllAdmin()
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin() {

		Transaction transaction = null;

		List<Admin> listOfAdmin = new ArrayList<Admin>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			listOfAdmin = session.createQuery("from Admin").getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfAdmin;
	}

}
