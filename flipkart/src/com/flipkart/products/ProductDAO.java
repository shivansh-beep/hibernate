package com.flipkart.products;

import java.text.BreakIterator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class ProductDAO {
	static String[] args = null;

	public static void main(String[] args) {

		try {
			FlipkartDTO fd = new FlipkartDTO();
			Scanner sc = new Scanner(System.in);
			int ch;
			int ch1;
			do {
				System.out.println("welcome to flipkart");
				System.out.println("press 1 to show all the items\n");
				System.out.println("press 2 to Search for an item\n");
				System.out.println("=================================");
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					ProductDAO.mainMenu();
					break;
				case 2:
					System.out.println("enter the name of item you want to search");
					System.out.println("==========================================");
					String name = sc.next();
					ProductDAO.search(name);
					ProductDAO.options(name);
					break;
				}
				System.out.println("==============================\n");
				System.out.println("enter 1 for back to main menu\n");
				System.out.println("enter 2 to end\n");
				System.out.println("==============================");
				ch = sc.nextInt();
			} while (ch == 1);

			System.exit(0);

		} catch (InputMismatchException e) {
			System.out.println("please enter a numeric value only");
			System.out.println("====================================");
			ProductDAO.main(args);
		}
	}

	public static void search(String name) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Criteria cr1 = ss.createCriteria(FlipkartDTO.class);

		cr1.add(Restrictions.ilike("product_name", name, MatchMode.ANYWHERE));

		List<FlipkartDTO> results = cr1.list();
		boolean b = results.isEmpty();
		if (!b) {
			for (FlipkartDTO flipkartDTO : results) {

				System.out.println(
						"\nproduct id : " + flipkartDTO.getId() + "\n product name :  " + flipkartDTO.getProduct_name()
								+ "\n product cost : " + flipkartDTO.getProduct_cost() + "\n product color :  "
								+ flipkartDTO.getProduct_color() + " \n description : " + flipkartDTO.getDescription()
								+ "\n number of products : " + flipkartDTO.getNumber_of_products());
				System.out.println(
						"===================================================================================================");
			}
		} else {
			System.out.println("product not found in the cart");
			System.out.println("press 1 to search again : ");
			System.out.println("\n press 2 for main menu");
			int i=sc.nextInt();
			switch(i){
			case 1: 
				System.out.println("enter the name of item you want to search");
				System.out.println("==========================================");
				name = sc.next();
				search(name);
				break;
			case 2:
				ProductDAO.main(args);
				break;
			}
		}
		ss.close();
		sf.close();
	}

	public static void mainMenu() {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Scanner sc = new Scanner(System.in);
		String srch;
		Criteria cr = ss.createCriteria(FlipkartDTO.class);
		List<FlipkartDTO> list = cr.list();
		for (FlipkartDTO flipkartDTO : list) {
			System.out.println("\nproduct id : " + flipkartDTO.getId() + "\n product name :  "
					+ flipkartDTO.getProduct_name() + "\n product cost : " + flipkartDTO.getProduct_cost()
					+ "\n product color :  " + flipkartDTO.getProduct_color() + " \n description : "
					+ flipkartDTO.getDescription() + "\n number of products : " + flipkartDTO.getNumber_of_products());
		}
		ss.close();
		sf.close();
	}

	public static void buy(int id, String name, int qty) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		Scanner sc = new Scanner(System.in);

		FlipkartDTO fd = ss.load(FlipkartDTO.class, id);

		System.out.println("=====================================");

		for (;;) {

			if (fd.getNumber_of_products() >= qty) {
				
				System.out.println("please enter your 16 digit card no.");
				String card=sc.next();
				
				if (card.length()==16) {
				try {
					long cd = Long.parseLong(card);
							
					} catch (NumberFormatException e) {
						System.out.println("please enter only numeric values");
						ProductDAO.buy(id, name, qty);
						System.out.println("=================================");
					}

					System.out.println("enter your cvv");
					String cvv = sc.next();
					if (cvv.length() == 3) {
						System.out.println("cvv enterd successfully");
						System.out.println("==========================");
						System.out.println("\nenter your name : ");
						String cname = sc.next();
						System.out.println("\n enter your address : ");
						String add = sc.next();

						System.out.println("order placed successfully");

						System.out.println("your total ammount deducted = " + (fd.getProduct_cost() * qty));
						System.out.println("===================================================");

						fd.setNumber_of_products(fd.getNumber_of_products() - qty);
						ss.save(fd);
						tx.commit();

						search(fd.getProduct_name());
						System.out.println("Customer Name : " + cname);
						System.out.println("\n Delivery Address : " + add);
						System.out.println("\nyour total bill = " + (fd.getProduct_cost() * qty));
						System.out.println("===================================================");
						ss.close();
						sf.close();
						
						main(args);
					} else {
						System.out.println("enter a valid cvv no. please try again : ");
						cvv = sc.next();
					}
				} else {
					System.out.println("please enter valid card no.");
					ProductDAO.buy(id, name, qty);
				}
			} else {
				System.out.println("product is out of stock");
				break;
			}
		}
	}

	public static void options(String name) {
		Scanner sc = new Scanner(System.in);

		System.out.println("press 1 to buy the product\n");
		System.out.println("press 2 to search again\n");
		System.out.println("press 3 to back to the last menu\n");
		System.out.println("====================================");
		int ch1 = sc.nextInt();
		switch (ch1) {
		case 1:
			search(name);
			System.out.println("enter the id of your selected product");
			int id = sc.nextInt();
			System.out.println("ender the quantity of or product you want to buy : ");
			int qty = sc.nextInt();
			ProductDAO.buy(id, name, qty);
			break;
		case 2:
			System.out.println("enter the name of item you want to search");
			System.out.println("==========================================");
			name = sc.next();
			ProductDAO.search(name);
			break;
		case 3:
			ProductDAO.main(args);
			break;

		default:
			System.out.println("enter a valid choise");
			break;
		}
	}
}
