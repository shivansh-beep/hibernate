package com.shivansh.contact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Contact implements Serializable{
	
@Id
private String name;
private long number;
private String cgroup;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}
public String getCgroup() {
	return cgroup;
}
public void setCgroup(String cgroup) {
	this.cgroup = cgroup;
}


}
