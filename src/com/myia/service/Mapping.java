/**
 * 
 */
package com.myia.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author E0188121
 *
 */
public class Mapping {
	
	private static SessionFactory  session;
	
	public static Session getSession() {
	
		if(session==null) {
		
			Configuration cfg = new Configuration().configure();
			session = cfg.buildSessionFactory();
		
		}
		
		return session.openSession();
	
	}
	
	
	
	
}
