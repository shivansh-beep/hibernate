package com.assignmen.student;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CURD {

	void reg() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		StudSDTO dto = new StudSDTO();
		Scanner sc = new Scanner(System.in);
		String fname;
		String lname;
		String email;
		double monthlyMarks;
		double quaterlyMarks;
		double aggregateMarks;
		String password;

		System.out.println("enter first name");
		dto.setFname(fname = sc.next());

		System.out.println("enter last name");
		dto.setLname(lname = sc.next());

		System.out.println("enter your email");
		dto.setEmail(email = sc.next());

		System.out.println("enter monthly marks");
		dto.setMonthlyMarks(monthlyMarks = sc.nextDouble());

		dto.setQuaterlyMarks(quaterlyMarks = (3 * monthlyMarks));
		System.out.println("quaterly marks calculated : " + quaterlyMarks);

		dto.setAggregateMarks(aggregateMarks = ((4 * quaterlyMarks) / 12));
		System.out.println(" aggregate marks calculated : " + aggregateMarks);

		System.out.println("set your password");
		sc.nextLine();
		dto.setPassword(password = sc.next());
		ss.save(dto);
		Transaction tx = ss.beginTransaction();
		tx.commit();
		System.out.println("regesterd successfully");

	}
	
	int logIn(String email, String password) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Query qry=ss.createQuery(" from StudSDTO where email=? and password=?");
		qry.setParameter(0, email);
		qry.setParameter(1, password);
		StudSDTO dto=(StudSDTO)qry.uniqueResult();
		 int id=dto.getId();
		
		 return id;
			
	}

	void updt(int id) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Scanner sc = new Scanner(System.in);

	}

	void delete(int id) {

	}
	void fetch(int id){
		
	}

}
