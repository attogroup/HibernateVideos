package org.lev.hibernate.java.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.lev.hibernate.java.model.Car;
import org.lev.hibernate.java.model.MyData;
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
		for (int i = 0; i < 10; i++) {
			Car car = new Car();
			car.setCarName("Volga");
			car.setCarYear(2000+i);
			car.setUserCarOwner(myUser);
			myUser.getCars().add(car);	
		}
		
		User myUser2 =new User();
		myUser2.setUserName("Second user");
		for (int i = 0; i < 10; i++) {
			Car car = new Car();
			car.setCarName("Lada");
			car.setCarYear(1900+i);
			car.setUserCarOwner(myUser2);
			myUser2.getCars().add(car);	
		}

		
		saveUser(myUser);
		saveUser(myUser2);
		myUser=null;

		System.out.println("FINISHED");

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

		User user=(User) session.get(User.class, id);
		session.close();
		return user;
	}

	private static void saveUser(MyData myUser) {
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
