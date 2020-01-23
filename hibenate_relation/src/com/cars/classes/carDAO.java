package com.cars.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class carDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		EngineDTO eng = new EngineDTO();
		eng.setEnginetype("1000HP");

		CarDTO cdto = new CarDTO();
		cdto.setCarName("ferrari");

		cdto.setEng(eng);
		ss.save(cdto);
		ss.beginTransaction().commit();

		ss.close();
		sf.close();
	}
}