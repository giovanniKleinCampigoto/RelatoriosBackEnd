package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "status", cascade = CascadeType.MERGE)
	private Set<MelhoriasAtingidas> ma = new HashSet<MelhoriasAtingidas>();
	@OneToMany(mappedBy = "status", cascade = CascadeType.MERGE)
	private Set<ObsCronograma> ob = new HashSet<ObsCronograma>();
	@OneToMany(mappedBy = "status", cascade = CascadeType.MERGE)
	private Set<Atividades> at = new HashSet<Atividades>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<MelhoriasAtingidas> getMa() {
		return ma;
	}

	public void setMa(Set<MelhoriasAtingidas> ma) {
		this.ma = ma;
	}

	public Set<ObsCronograma> getOb() {
		return ob;
	}

	public void setOb(Set<ObsCronograma> ob) {
		this.ob = ob;
	}

	public Set<Atividades> getAt() {
		return at;
	}

	public void setAt(Set<Atividades> at) {
		this.at = at;
	}

}
