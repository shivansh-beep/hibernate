package com.shiv.hibenate_relation;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Demo1 implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
  private int id;
  private String name;
  @OneToOne(cascade=CascadeType.ALL)
  private Demo2 d2;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Demo2 getD2() {
	return d2;
}
public void setD2(Demo2 d2) {
	this.d2 = d2;
}
}
