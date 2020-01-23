package com.shiv.hibenate_relation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDAO {

	public static void main(String[] args) {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Demo2 d2=new Demo2();
			d2.setName("X");
	Demo1 d1=new Demo1();
	d1.setName("shivansh");
	d1.setD2(d2);
	ss.save(d1);
//	ss.beginTransaction().commit();
	
	Demo1 dto1=ss.load(Demo1.class,1);
	System.out.println(dto1.getName());
	Demo2 dto2=dto1.getD2();
	System.out.println(dto2.getName());
	ss.close();
	sf.close();
	
	
	}

}
