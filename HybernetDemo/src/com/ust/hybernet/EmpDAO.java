package com.ust.hybernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;


public class EmpDAO {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		
		EmpDTO dto=new EmpDTO();
		dto.setId(1);
		dto.setName("shivam");
		dto.setSal(12000.00);
		ss.save(dto);
		
		Transaction tx=ss.beginTransaction();
		tx.commit();
		ss.close();
		sf.close();
	}

}
