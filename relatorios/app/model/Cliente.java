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
@Table(name = "cliente")
public class Cliente implements java.io.Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	private Set<MelhoriasAtingidas> ma = new HashSet<MelhoriasAtingidas>();
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
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
		return this.ma;
	}
	public void setMa(Set<MelhoriasAtingidas> ma) {
		this.ma = ma;
	}
	
	public Set<Atividades> getAt() {
		return this.at;
	}
	public void setAt(Set<Atividades> at) {
		this.at = at;
	}

	
	
}
