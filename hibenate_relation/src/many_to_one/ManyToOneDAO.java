package many_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		CompanyDTO cdto = new CompanyDTO();
		cdto.setCname("ust");
		cdto.setType("software company");

		EmpDTO edto = new EmpDTO();
		edto.setEname("shivam");
		edto.setEsal(23000.00);
		edto.setCdto(cdto);

		EmpDTO edto1 = new EmpDTO();
		
		edto1.setEname("shivansh");
		edto1.setEsal(22000.00);
		edto1.setCdto(cdto);

		EmpDTO edto2 = new EmpDTO();
		edto2.setEname("ankush");
		edto2.setEsal(25000.00);
		edto2.setCdto(cdto);

		ss.save(edto);
		ss.save(edto1);
		ss.save(edto2);

		Transaction tx = ss.beginTransaction();
		tx.commit();

		ss.close();
		sf.close();

	}

}
