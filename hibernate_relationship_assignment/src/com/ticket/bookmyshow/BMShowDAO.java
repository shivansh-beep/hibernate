package com.ticket.bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BMShowDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 for one to one relation b/w movie and director");
//		System.out.println("press 2 for one to many relation b/w director and muliple movies");
		System.out.println("press 3 for many to one relation b/w Actors in single movie");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			DirectorDTO d1 = new DirectorDTO();
			d1.setDname("anurag");
			MovieDTO m1 = new MovieDTO();
			m1.setMname("waseypur");
			m1.setMtype("action");

			ss.save(m1);
			ss.beginTransaction().commit();
			break;
		case 2:
 
			break;

		case 3:
			MovieDTO mdto = new MovieDTO();
			mdto.setMname("hera pheri");
			mdto.setMtype("Comedy");

			ActorDTO a1 = new ActorDTO();
			a1.setAname("akshay kumar");
			a1.setAtype("action & comedy actor");
			a1.setMdto(mdto);

			ActorDTO a2 = new ActorDTO();
			a2.setAname("suneel shetty");
			a2.setAtype("action & comedy actor");
			a1.setMdto(mdto);

			ActorDTO a3 = new ActorDTO();
			a3.setAname("paresh rawal");
			a3.setAtype("Comedy actor");
			a1.setMdto(mdto);
			
			ss.save(a1);
			ss.save(a2);
			ss.save(a3);

			Transaction tx = ss.beginTransaction();
			tx.commit();
		}

		ss.close();
		sf.close();

	}

}
