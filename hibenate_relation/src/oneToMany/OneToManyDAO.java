package oneToMany;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		// StudEntDTOs s1=new StudEntDTOs();
		// s1.setSname("shivam");
		//
		// StudEntDTOs s3=new StudEntDTOs();
		// s3.setSname("shivansh");
		//
		// StudEntDTOs s2=new StudEntDTOs();
		// s2.setSname("ankush");
		//
		// List<StudEntDTOs> list=new LinkedList();
		// list.add(s3);
		// list.add(s2);
		// list.add(s1);

		// FacultyDTO f=new FacultyDTO();
		// f.setFname("sonia");
		// f.setSlist(list);
		//
		// ss.save(f);
		// ss.beginTransaction().commit();

		//////////////////////////////////////////////// READ OPERATION////////////////////////////
//
//		FacultyDTO f = ss.load(FacultyDTO.class,1);
//		
//		System.out.println("===================faculty=======================\n " + f.getFname());
//
//		--
		
		
		//////////////////////////////////////////UPDATE OPERATION///////////////////////////////////////
//		FacultyDTO f = ss.load(FacultyDTO.class,1);
//		
//		f.setFname(f.getFname()+" Gandhi");
//		List<StudEntDTOs> list = f.getSlist();
//		for (StudEntDTOs studEntDTOs : list) {
//			if(studEntDTOs.getSname().equals("shivam")){
//				studEntDTOs.setSname(studEntDTOs.getSname()+" Gandhi");
//			}
//		}
//		ss.update(f);
		
		
		
		//////////////////////////////////DELETE////////////////////////////
		FacultyDTO f=ss.load(FacultyDTO.class, 1);
		ss.delete(f);
		
		
		ss.beginTransaction().commit();
		ss.close();
		sf.close();
	}

}
++