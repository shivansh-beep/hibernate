package manyToMany;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		// Customer cdto=new Customer();
		// cdto.setCname("aman");
		// cdto.setCtype("male");
		//
		// Customer cdto1=new Customer();
		// cdto1.setCname("amandeep");
		// cdto1.setCtype("female");
		//
		// Customer cdto2=new Customer();
		// cdto2.setCname("ankush");
		// cdto2.setCtype("male");
		//
		// Customer cdto3=new Customer();
		// cdto3.setCname("shivam");
		// cdto3.setCtype("male");
		//
		// List<Customer> lCustomers=new LinkedList();
		// lCustomers.add(cdto);
		// lCustomers.add(cdto1);
		// lCustomers.add(cdto2);
		// lCustomers.add(cdto3);
		//
		//
		// vendor v1=new vendor();
		// v1.setVname("amazom");
		// v1.setVtype("shopping");
		// v1.setlCustomers(lCustomers);
		//
		//
		// ss.save(v1);

		vendor v1 = new vendor();
		v1.setVname("snampdeal");
		v1.setVtype("E.com.");

		vendor v2 = new vendor();
		v2.setVname("flipkart");
		v2.setVtype("E.com.");

		vendor v3 = new vendor();
		v3.setVname("snampdeal");
		v3.setVtype("E.com.");

		List<vendor> list = new LinkedList<>();
		list.add(v1);
		list.add(v2);
		list.add(v3);

		Customer c4 = new Customer();
		c4.setCname("alok");
		c4.setCtype("tiktok");
		c4.setlVendors(list);

		ss.save(c4);

		Transaction tx = ss.beginTransaction();
		tx.commit();
		ss.close();
		sf.close();

	}

}
