package com.sevval.HibDemo;

import javax.net.ssl.ExtendedSSLSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	Alien sevval=new Alien();
    	sevval.setAid(101);
    	sevval.setAname("sevval");
    	sevval.setColor("blue");
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	SessionFactory sf= con.buildSessionFactory();
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	
    	session.save(sevval);
    	
    	tx.commit();
    }
}
