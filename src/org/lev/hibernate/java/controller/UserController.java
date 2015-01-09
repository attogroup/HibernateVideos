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
import org.lev.hibernate.java.model.Masda;
import org.lev.hibernate.java.model.MyData;
import org.lev.hibernate.java.model.Porshe;
import org.lev.hibernate.java.model.User;

import com.java.lev.myproject.Address;

public class UserController {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {

		sessionFactory = createSessionFactory();

		Porshe carPorshe = new Porshe();
		carPorshe.setPorsheModel("Porshe model");
		Masda carMasda = new Masda();
		carMasda.setMasdaModel("Masda Model");
		Car myCar = new Car();
		myCar.setCarName("My ooold Car");
		saveCar(myCar);
		saveCar(carMasda);
		saveCar(carPorshe);

		System.out.println("FINISHED");

	}
	
	private static void saveCar(Car myCar) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(myCar);
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
