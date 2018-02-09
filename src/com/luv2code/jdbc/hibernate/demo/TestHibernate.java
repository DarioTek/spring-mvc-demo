package com.luv2code.jdbc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		// NOTE: The hibernate config file needs to be in the classpath
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml") // if no parameter is passed hibernate will look for the default hibernate filename configuration file "hibernate.cfg.xml"
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			// use the session object save and retrieve java objects

			// create the student object
			Student student = new Student("Dario", "Montecastro", "dmontecastro@yahoo.com");
			
			// start the transaction
			session.beginTransaction();
			// save the student
			session.save(student);
			// commit the transaction
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
