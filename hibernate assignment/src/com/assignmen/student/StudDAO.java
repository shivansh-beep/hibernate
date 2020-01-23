package com.assignmen.student;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudDAO {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		StudSDTO dto = new StudSDTO();
		CURD c = new CURD();
		Scanner sc = new Scanner(System.in);
		int choise;
		System.out.println("press 1 for registration");
		System.out.println("press 2 for login");
		// System.out.println("press 3 for login");
		// System.out.println("press 4 for delete");

		switch (choise = sc.nextInt()) {
		case 1:
			c.reg();
			break;
		case 2:

			String email;
			String password;
			System.out.println("enter youe email");
			email = sc.next();
			System.out.println("enter your password");
			password = sc.next();

			Query qry = ss.createQuery("from StudSDTO where email='" + email + "' and password='" + password + "'");
			
			
			
			
			
			
			StudSDTO rs = (StudSDTO) qry.uniqueResult();
			if (rs != null) {
				// int regno = c.logIn(email, password);
				System.out.println("press 1 for update");
				System.out.println("press 2 for delete");
				System.out.println("press 3 to fetch data");
				int chs = sc.nextInt();
				int regno = rs.getId();
				switch (chs) {
				case 1:

					dto = ss.load(StudSDTO.class, regno);
					System.out.println("enter new email");
					String nEmail = sc.next();
					dto.setEmail(nEmail);
					ss.update(dto);
					Transaction tx = ss.beginTransaction();
					tx.commit();
					System.out.println("email updated");
					break;

				case 2:
					dto = ss.load(StudSDTO.class, regno);
					ss.delete(dto);
					Transaction tx2 = ss.beginTransaction();
					tx2.commit();
					System.out.println("account successfully deleted");
					break;
				case 3:

					qry = ss.createQuery("from StudSDTO where id=?");
					qry.setParameter(0, regno);
					dto = (StudSDTO) qry.uniqueResult();
					System.out.println(dto.getFname() + " " + dto.getAggregateMarks());
					break;
				default:
					System.out.println("enter a valid choise");

				}

			} else {
				System.out.println("enter valid email and password");
			}

			ss.close();
			sf.close();

		}
	}
}
