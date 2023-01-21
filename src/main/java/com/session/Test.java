package com.session;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// pass the class name and id for updating record
		
		System.out.println("first query>>");
		
		Query query = session.createQuery("from Student");
		
		query.setCacheable(true);
		
		List<Student>students = query.list();
		
		for (Student student : students) {
			
			System.out.println("ID="+student.getId());
			System.out.println("City="+student.getCity());
			System.out.println("Mobile="+student.getMobile());
			System.out.println("Name="+student.getName());
		}
		
		session.close();
		sessionFactory.close();
		System.out.println("Record retrieved successfully.");

	}


	}


