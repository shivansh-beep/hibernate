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

@Entity
public class ActorDTO  implements Serializable {

	   @Id
	   @GenericGenerator(name="auto",strategy="increment")
		@GeneratedValue(generator="auto")
	   private int aid;
	   private String aname;
	   private String atype;
	   @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(referencedColumnName = "mid")
		private MovieDTO mdto;
//		@OneToOne(cascade = CascadeType.ALL)
//		private DirectorDTO d1;
//		@OneToMany(cascade = CascadeType.ALL)
//		@JoinColumn(referencedColumnName="aid")
//		private List<ActorDTO> slist;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public MovieDTO getMdto() {
		return mdto;
	}
	public void setMdto(MovieDTO mdto) {
		this.mdto = mdto;
	}
	   
}
