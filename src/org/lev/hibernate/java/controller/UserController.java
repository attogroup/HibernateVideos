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

		sessionFactory = createSessionFactory();

		User myUser = new User();
		myUser.setUserAge(23);
		myUser.setUserName("First one");
		myUser.setDateOfBirth(new Date());
		myUser.setAddress(fillUserAdress("Arlosorov","Gylad 6","2"));
		myUser.setOfficeAdress(fillUserAdress("Arlosorov_Office","Gylad 6_Office","2_Office"));

		myUser.getUserAdressCollection().add(fillUserAdress("Arlosorov1_Collection","Gylad 6","2"));
		myUser.getUserAdressCollection().add(fillUserAdress("Arlosorov2_Collection","Gylad 6","2"));
		saveUser(myUser);

		User myUser2 = new User();
		myUser2.setUserName("Second one");
		myUser2.getUserAdressCollection().add(fillUserAdress("Arlosorov3_Collection","Gylad 6","2"));
		myUser2.getUserAdressCollection().add(fillUserAdress("Arlosorov4_Collection","Gylad 6","2"));
		saveUser(myUser2);
		
		myUser = getUser(2);

		
		System.out.println(myUser.getUserId() + " User name="
				+ myUser.getUserName());

	}


	private static Address fillUserAdress(String street,String house,String room) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setStreet(street);
		address.setHouse(house);
		address.setRoom(room);
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
