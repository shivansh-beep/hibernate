package com.hotelbilling.shivansh;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HotelDAO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		HotelDTO dto = new HotelDTO();
		int[] a=new int[100];
		int Tprice=0;
		int choice;
		do{
		System.out.println("press 1 for food items");
		System.out.println("press 2 for selecting food items");
		System.out.println("press 3 for operate on foood items");
		System.out.println("press 4 to generate bill");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			// HotelDTO dto = new HotelDTO();
			Criteria cr = ss.createCriteria(HotelDTO.class);
			List<HotelDTO> list = cr.list();
			for (HotelDTO sdto : list) {
				System.out.println(sdto.getId() + "  " + sdto.getFood() + "  " + sdto.getPrice());
			}break;
		case 2:
			cr = ss.createCriteria(HotelDTO.class);
			list = cr.list();
			for (HotelDTO dto1 : list) {
				System.out.println(dto1.getId() + "  " + dto1.getFood() + "  " + dto1.getPrice());
			System.out.println("_________________________________________________________");
			}
			System.out.println("place order by order id");
				int n=1,i=0,j=0;
				
				
				while(n!=0&&n==1) {
					System.out.println("Enter Food ID to Order Food.");
					int id=sc.nextInt();
					a[i++]=id;
					System.out.println("Enter 1 to Continue Order OR 0 to End.");
					n=sc.nextInt();
					}
				System.out.println("\n\nYour Order Are:");
				 j=0;
				
				while(a[j]!=0) {
					dto=ss.load(HotelDTO.class, a[j]);
					System.out.println(" "+dto.getId()+".  "+dto.getFood()+"  Rs."+dto.getPrice());
					Tprice+= dto.getPrice();
					j++;
				}   System.out.println("-----------------------------");
			    	//System.out.println("Today Total Bill: Rs."+Tprice);
				break;
		case 3:
			System.out.println("operate on food items");
			System.out.println("Press A to Add Food Item.");
			System.out.println("Press B to Remove Food Item.");
			System.out.println("Press C to Modify Food Item.");
		   String ch11=sc.next();
				switch(ch11){
				case "A":
					System.out.println("want to add more items");
					System.out.println("enter food name");
					String fname=sc.next();
					System.out.println("enter food price");
					double fprice=sc.nextDouble();
					dto.setFood(fname);
					dto.setPrice(fprice);
					ss.save(dto);
					tx.commit();
					System.out.println("food item is added");
					break;
					
				case "B":
						System.out.println("delete any food fron order");
						Criteria cr1 = ss.createCriteria(HotelDTO.class);
						List<HotelDTO> list1 = cr1.list();
						for (HotelDTO sdto : list1) {
							System.out.println(sdto.getId() + "  " + sdto.getFood() + "  " + sdto.getPrice());
						}
						System.out.println("item id of the order you wanna delete");
						int id=sc.nextInt();
					dto=ss.load(HotelDTO.class,id);
					ss.delete(dto);
					tx.commit();
					System.out.println("item deleted successfully");
					
								
				case"c":
					System.out.println("modify food item");
					Criteria cr2 = ss.createCriteria(HotelDTO.class);
					List<HotelDTO> list2 = cr2.list();
					for (HotelDTO sdto : list2) {
						System.out.println(sdto.getId() + "  " + sdto.getFood() + "  " + sdto.getPrice());
					}
						System.out.println("enter which food you wanna update");
						int fid=sc.nextInt();
					dto=ss.load(HotelDTO.class,fid);
					if(dto!=null){
						System.out.println("which product you want to upadta");
						String fname1=sc.next();
						if(fname1.equalsIgnoreCase("price")){
							System.out.println("enter new price");
							double nprice=sc.nextDouble();
							dto.setPrice(nprice);
							ss.update(dto);
							tx.commit();
							System.out.println("price updated");
						}
					}
						else{
							System.out.println("enter valid id");
						}
						break;
						
						default :
							System.out.println("enter valid choise");
							break;
					}
					case 4:
						System.out.println("bill ammount");
						j=0;
						while(a[j]!=0){
						dto=ss.load(HotelDTO.class, a[j]);
						System.out.println(dto.getId()+"  "+dto.getFood()+"  "+dto.getPrice());
						j++;
						}
						System.out.println("total billing ammount : "+Tprice);
		}
		System.out.println("go to the main menu by pressing 1 and press 0 for exit");
		choice=sc.nextInt();
		}while(choice==1);
			ss.close();
		   sf.close();
		}
	}


