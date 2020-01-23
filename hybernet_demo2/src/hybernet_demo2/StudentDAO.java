package hybernet_demo2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

	///////// this class is used DATA ACCESS OBJECT/////

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		// <insertion>
		// StudentDTO dto=new StudentDTO();
		// dto.setName("shivam");
		// dto.setStream("ece");
		// dto.setPercentage(76.3);

		// Transaction tx=ss.beginTransaction();
		// tx.commit();

		// <read>
		// StudentDTO dto=ss.load(StudentDTO.class, 1);
		// System.out.println(dto.getName()+" "+dto.getPercentage());

		// <update>
//		StudentDTO dto = ss.load(StudentDTO.class, 1);
//		dto.setName("shivansh");
//		dto.setPercentage(99.99);

		StudentDTO dto = ss.load(StudentDTO.class, 1);
		ss.delete(dto);

		ss.save(dto);
		Transaction tx = ss.beginTransaction();
		tx.commit();
		ss.close();
		sf.close();
	}
}