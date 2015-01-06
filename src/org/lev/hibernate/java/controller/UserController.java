package org.lev.hibernate.java.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.lev.hibernate.java.model.User;

public class UserController {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User myUser = new User();

		
		myUser.setUserAge(23);
		
		String name="";
		for (int i = 0; i < 100; i++) {
			name+="-7777777777777777--7777777777777777--7777777777777777--7777777777777777--7777777777777777-";
		}
		myUser.setUserName(name);
		myUser.setDateOfBirth(new Date());

		sessionFactory = createSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(myUser);
		session.getTransaction().commit();
	
	}

private static  SessionFactory createSessionFactory() {
	
	Configuration configuration = new Configuration();
	configuration.configure();
	serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	return sessionFactory;
}
	


}
