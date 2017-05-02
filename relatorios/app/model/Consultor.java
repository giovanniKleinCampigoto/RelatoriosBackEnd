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
@Table(name = "consultor")
public class Consultor {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "consultor", cascade = CascadeType.MERGE)
	private Set<MelhoriasAtingidas> ma = new HashSet<MelhoriasAtingidas>();
	
	@OneToMany(mappedBy = "consultor", cascade = CascadeType.MERGE)
	private Set<Atividades> at = new HashSet<Atividades>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<MelhoriasAtingidas> getMa() {
		return ma;
	}

	public void setMa(Set<MelhoriasAtingidas> ma) {
		this.ma = ma;
	}

	public Set<Atividades> getAt() {
		return at;
	}

	public void setAt(Set<Atividades> at) {
		this.at = at;
	}

}
