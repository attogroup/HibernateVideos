package org.lev.hibernate.java.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.lev.hibernate.java.model.User;

import com.java.lev.myproject.Address;

public class UserController {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sessionFactory = createSessionFactory();

		User myUser = new User();
		myUser.setUserAge(23);
		myUser.setUserName("Vasia");
		myUser.setDateOfBirth(new Date());
		myUser.setAddress(fillUserAdress());

		saveUser(myUser);
		myUser = null;
		myUser = getUser(2);

		System.out.println(myUser.getUserId() + " User name="
				+ myUser.getUserName());

	}

	private static Address fillUserAdress() {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setStreet("Arlosorov");
		address.setHouse("#2");
		address.setRoom("33");
		return address;
	}

	private static User getUser(int id) {

		Session session = sessionFactory.openSession();
		session = sessionFactory.openSession();
		session.beginTransaction();

		return (User) session.get(User.class, id);
	}

	private static void saveUser(User myUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(myUser);
		session.getTransaction().commit();
		session.close();
	}

	private static SessionFactory createSessionFactory() {

		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
