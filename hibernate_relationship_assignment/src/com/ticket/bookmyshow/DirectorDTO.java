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
public class DirectorDTO implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int did;
	private String dname;
	private String dtype;
	private MovieDTO m1;
	// @ManyToMany(cascade = CascadeType.ALL)
	// @OneToOne(cascade = CascadeType.ALL)
	// private ActorDTO m1;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "mid")
//	private List<MovieDTO> mlist;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public MovieDTO getM1() {
		return m1;
	}
	public void setM1(MovieDTO m1) {
		this.m1 = m1;
	}

	
}
