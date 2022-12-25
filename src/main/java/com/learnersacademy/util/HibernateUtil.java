package com.learnersacademy.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.learnersacademy.model.Admin;
import com.learnersacademy.model.ClassLecture;
import com.learnersacademy.model.Student;
import com.learnersacademy.model.Subject;
import com.learnersacademy.model.Teacher;

public class HibernateUtil {
	// Creating a sessionFactory
	private static SessionFactory sessionFactory;

	// Creating a getSessionFactory() method
	public static SessionFactory getSessionFactory() {

		// Checking if we already have set the sesionFactory (is it null)
		if (sessionFactory == null) {
			try {
				// Creating a new configuration
				Configuration configuration = new Configuration();

				// Creating a properties object
				Properties settings = new Properties();
				// Driver
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				// Setting URL to my database learners_academy_database. I will create it using
				// I will create it using HeidiSQL (CREATE DATABASE `learners_academy_database`)
				settings.put(Environment.URL,
						"jdbc:mysql://localhost:3306/learners_academy_database?allowPublicKeyRetrieval=true&useSSL=false");
				// MySQL user is root
				settings.put(Environment.USER, "root");
				// MySQL password is password
				settings.put(Environment.PASS, "password");

				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Admin.class);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Subject.class);
				configuration.addAnnotatedClass(Teacher.class);
				configuration.addAnnotatedClass(ClassLecture.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
