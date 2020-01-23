package hybernet_query_demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
	
	/////////this class is used DATA ACCESS OBJECT/////

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
	//  <insertion>	
//		StudentDTO dto=new StudentDTO();
//		dto.setName("shivam");
//		dto.setStream("ece");
//		dto.setPercentage(76.3);
			
		
//		Transaction tx=ss.beginTransaction();
//		tx.commit();
		
//		<read>
//		  StudentDTO dto=ss.load(StudentDTO.class, 1);
//		  System.out.println(dto.getName()+" "+dto.getPercentage());
		 
//		<update>
//		StudentDTO dto=ss.load(StudentDTO.class, 1);
//		dto.setName("shivansh");
//		dto.setPercentage(99.99);
		
//		StudentDTO dto=ss.load(StudentDTO.class, 1);
//		ss.delete(dto);
		
//		ss.save(dto);
//		Transaction tx=ss.beginTransaction();
//		tx.commit();
		
		
		//UNIQUE RESULT
//		// PROCESS 1
//		Query qry=ss.createQuery("from StudentDTO where id=1");
//		//PROCESS 2
//		StudentDTO dto=(StudentDTO)qry.uniqueResult();
//		System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getPercentage()+" "+dto.getStream());
		
		
//		//LIST RESULT
//		// PROCESS 1
//		Query qry=ss.createQuery("from StudentDTO ");
//		//PROCESS 2
//		List<StudentDTO> list=qry.list();
//		for(StudentDTO dto:list){
//			System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getPercentage()+" "+dto.getStream());
//		}
		
//		////USE OF SET PARAMETER METHOD///
//		// setParameter() to set the value dynamically like jdbc prepared statement
//		Query qry=ss.createQuery("from StudentDTO where id=?");
//		qry.setParameter(0, new Integer(1));
//		StudentDTO dto=(StudentDTO)qry.uniqueResult();
//		System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getPercentage()+" "+dto.getStream());
//	
		
//		////USE OF OVERLOAD METHOD OF SETPARAMETER METHOD///
//		// setParameter() to set the value dynamically like jdbc prepared statement
//		Query qry=ss.createQuery("from StudentDTO where id=:id");
//		qry.setParameter("id", new Integer(1));
//		StudentDTO dto=(StudentDTO)qry.uniqueResult();
//		System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getPercentage()+" "+dto.getStream());
//	
		//////////UPDATE QUERIES//////
		Query qry=ss.createQuery("update StudentDTO set marks=marks+20.00");
		int row=qry.executeUpdate();
		System.out.println("rows effected : "+row);
		
		ss.close();
		sf.close();
	}
}