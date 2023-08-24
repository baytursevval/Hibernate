package com.sevval.HibDemo;

import javax.net.ssl.ExtendedSSLSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	AlienName an=new AlienName();
    	an.setFname("sevval");
    	an.setLname("akdnz");
    	an.setMname("fatmanur");
    	
    	Alien sevval=new Alien();
    	  	
    	sevval.setAid(102);
    	sevval.setAname(an);
    	sevval.setColor("green");
    		
    	Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf= con.buildSessionFactory(reg);
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	
    	session.save(sevval);
    	
    	//sevval= (Alien) session.get(Alien.class, 102);
    	
    	tx.commit();
    	
        System.out.println(sevval);
    }
}
