package com.shivansh.contact;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class ContactDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		// Contact c=new Contact();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Press 1 to Show all contacts");
			System.out.println("Press 2 to Search for contact (using name)");
			System.out.println("Press 3 to Operate on contact");
			System.out.println("==============================================");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Criteria cr = ss.createCriteria(Contact.class);
				List<Contact> list = cr.list();
				for (Contact c : list) {
					System.out.println(c.getName() + "  " + c.getNumber() + "  " + c.getCgroup());
				}
			
				break;
			case 2:
				Criteria cr1 = ss.createCriteria(Contact.class);
				System.out.println("enter the exact name which you want to Search for contact ");
				System.out.println();
				System.out.println("=============================================================");
				String name = sc.next();
				cr1.add(Restrictions.ilike("name", name, MatchMode.EXACT));
				List<Contact> result = cr1.list();
				boolean b = result.isEmpty();
				if (!b) {
					for (Contact c : result) {
						System.out.println();
						System.out.println("name : " + c.getName() + " " + "number : " + c.getNumber() + " "
								+ "group : " + c.getCgroup());
					}
					System.out.println("Press 1 to call");
					System.out.println("Press 2 to message");
					System.out.println("Press 3 to go back to main menu");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						int call = 0;
						do {
							System.out.println("calling....");
							System.out.println("=============");
							System.out.println();
							System.out.println("press 2 to end the call");
							call = sc.nextInt();
						} while (call == 0);
						break;
					case 2:
						System.out.println("text :- write message ");
						String message = sc.next();
						System.out.println();
						System.out.println("message sent");
						break;
					case 3:
						main(args);
						break;
					}
				} else {
					System.out.println("no contact found");
				}
				 
				break;
			case 3:
				System.out.println("Press 1 to add contact");
				System.out.println("Press 2 to delete contact");
				System.out.println("Press 3 to edit contact ");
				System.out.println("==============================");
				System.out.println();
				int ch2 = sc.nextInt();
				switch (ch2) {
				case 1:
					System.out.println("enter name");
					String newName = sc.next();
					System.out.println("enter number");
					long newNumber = sc.nextLong();
					System.out.println("enter group");
					String newGroup = sc.next();
					Contact c = new Contact();
					c.setName(newName);
					c.setNumber(newNumber);
					c.setCgroup(newGroup);
					ss.save(c);
					Transaction tx4 = ss.beginTransaction();
					tx4.commit();
					System.out.println("contact saved.");
					break;
				case 2:
					System.out.println("enter the name you want to delete");
					String delName = sc.next();
					Contact cd = ss.load(Contact.class, delName);
					ss.delete(cd);
					Transaction tx1 = ss.beginTransaction();
					tx1.commit();
					System.out.println("contact deleted.");
					break;
				case 3:
					Criteria cr3 = ss.createCriteria(Contact.class);
					System.out.println("enter the exact name which you want to Search for contact ");
					System.out.println();
					System.out.println("=============================================================");
					String sname = sc.next();
					cr3.add(Restrictions.ilike("name", sname, MatchMode.EXACT));
					Contact cu1 = (Contact) cr3.uniqueResult();
					System.out.println("=============================================================");
					System.out.println();
					System.out.println(
							"name : " + cu1.getName() + "number : " + cu1.getNumber() + "group : " + cu1.getCgroup());

					System.out.println();
					System.out.println("==========================================================================");
					// System.out.println("press 1 to update name");
					System.out.println("press 2 to update contact");
					System.out.println("press 3 to update group");
					int uo = sc.nextInt();

					if (uo == 2) {
						System.out.println("enter the new number");
						long unumber = sc.nextLong();
						cu1.setNumber(unumber);
						System.out.println("number successfully updated");
					} else if (uo == 3) {
						System.out.println("enter new group");
						String ugroup = sc.next();
						cu1.setCgroup(ugroup);
						System.out.println("group successfully updated");
					}
					ss.update(cu1);
					Transaction tx2 = ss.beginTransaction();
					tx2.commit();
				}

			}
		} while (choice == 1 || choice==2 || choice==3 );
		ss.close();
		sf.close();
	}

}
