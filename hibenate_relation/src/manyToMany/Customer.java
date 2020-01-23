package manyToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Customer implements Serializable {
	
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int cid;
	private String cname;
	private String ctype;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="ven_cus",joinColumns=@JoinColumn(name="cid"),inverseJoinColumns=@JoinColumn(name="vid"))
	private List<vendor> lVendors;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public List<vendor> getlVendors() {
		return lVendors;
	}
	public void setlVendors(List<vendor> lVendors) {
		this.lVendors = lVendors;
	}
	

}
