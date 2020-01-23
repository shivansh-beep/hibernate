package com.ticket.bookmyshow;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

//import oneToMany.StudEntDTOs;
@Entity
public class MovieDTO implements Serializable {
   @Id
   @GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
   private int mid;
   private String mname;
   private String mtype;
   
	//@ManyToMany(cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.ALL)
	private DirectorDTO d1;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName="aid")
//	private List<ActorDTO> alist;
	//@ManyToOne(cascade = CascadeType.ALL)
//	@JoinTable(name="ven_cus",joinColumns=@JoinColumn(name="cid"),inverseJoinColumns=@JoinColumn(name="vid"))

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public DirectorDTO getD1() {
		return d1;
	}

	public void setD1(DirectorDTO d1) {
		this.d1 = d1;
	}
	
	
   
}
