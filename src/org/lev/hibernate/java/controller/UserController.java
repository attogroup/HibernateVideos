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
		myUser.setAddress(fillUserAdress("Arlosorov","Gylad 6","2","2333"));
		myUser.setOfficeAdress(fillUserAdress("Arlosorov_Office","Gylad 6_Office","2_Office","Office_postCode"));

		saveUser(myUser);
//		myUser = null;
		myUser.setAddress(fillUserAdress("Arlosorov2","Gylad 6","2","2333"));
		myUser.setOfficeAdress(fillUserAdress("Arlosorov_Office","Gylad 6_Office","2_Office","Office_postCode"));

		saveUser(myUser);
		
//		myUser = getUser(2);
//
//		
//		System.out.println(myUser.getUserId() + " User name="
//				+ myUser.getUserName());

	}


	private static Address fillUserAdress(String street,String house,String room, String postCode) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setStreet(street);
		address.setHouse(house);
		address.setRoom(room);
		address.setPostCode(postCode);
		return address;
	}

	private static User getUser(int id) {

		Session session = sessionFactory.openSession();
		session = sessionFactory.openSession();
		session.beginTransaction();

		User user =(User) session.get(User.class, id);
		session.close();
		return user;
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
