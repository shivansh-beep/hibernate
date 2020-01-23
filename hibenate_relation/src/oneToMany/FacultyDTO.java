package oneToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FacultyDTO implements Serializable {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int fid;
	private String fname;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="fid")
	private List<StudEntDTOs> slist;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public List<StudEntDTOs> getSlist() {
		return slist;
	}

	public void setSlist(List<StudEntDTOs> slist) {
		this.slist = slist;
	}
	
	
	

}
