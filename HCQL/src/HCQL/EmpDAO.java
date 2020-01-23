package HCQL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;


public class EmpDAO {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		
//		EmpDTO dto=new EmpDTO();
//		dto.setId(1);
//		dto.setName("shivam");
//		dto.setSal(12000.00);
//		ss.save(dto);
		
		////////////////////ONE RECORD USING CRITERIA//////////////
		/*Criteria cr=ss.createCriteria(EmpDTO.class);
		 cr.add(Restrictions.eq("id", 1));
		 EmpDTO dto=(EmpDTO) cr.uniqueResult();
		System.out.println(dto.getId()+" "+dto.getName());*/
		
		/////////////////////multiple record///////////////////
		Criteria cr=ss.createCriteria(EmpDTO.class);
		List<EmpDTO> list=cr.list();
		for(EmpDTO dto:list){
			System.out.println(dto.getName()+" "+dto.getSal());
		}
		 
//		Transaction tx=ss.beginTransaction();
//		tx.commit();
		ss.close();
		sf.close();
	}

}
