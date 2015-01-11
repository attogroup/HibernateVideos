package org.lev.hibernate.java.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

		for (int i = 0; i < 10; i++) {
			User myUser = new User();
			myUser.setUserName("user#"+i);
			saveUser(myUser);	
		}
		
		queryExecute();
		System.out.println("FINISHED");

	}

	
	
	private static void queryExecute() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();


		Criteria criteria = session.createCriteria(User.class);

		criteria.addOrder(Order.desc("userId"));
		
		Collection<User> arrayList = new ArrayList<User>();
		
		arrayList = (ArrayList<User>)criteria.list();
		session.getTransaction().commit();
		
		for (User user : arrayList) {
			System.out.println(user.getUserName());
		}
		
		session.close();
		
	}



	private static void saveUser(User myUser) {
		sessionFactory = createSessionFactory();
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
