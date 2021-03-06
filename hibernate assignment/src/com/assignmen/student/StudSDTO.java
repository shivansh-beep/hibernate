package com.assignmen.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class StudSDTO implements Serializable {
@Id
@GenericGenerator(name="auto",strategy="increment")
@GeneratedValue(generator="auto")
@Column(name="regno")
	private int id;
	private String fname;
	private String lname;
	private String email;
	private double monthlyMarks;
	private double quaterlyMarks;
	private double aggregateMarks;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMonthlyMarks() {
		return monthlyMarks;
	}
	public void setMonthlyMarks(double monthlyMarks) {
		this.monthlyMarks = monthlyMarks;
	}
	public double getQuaterlyMarks() {
		return quaterlyMarks;
	}
	public void setQuaterlyMarks(double quaterlyMarks) {
		this.quaterlyMarks = quaterlyMarks;
	}
	public double getAggregateMarks() {
		return aggregateMarks;
	}
	public void setAggregateMarks(double aggregateMarks) {
		this.aggregateMarks = aggregateMarks;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}