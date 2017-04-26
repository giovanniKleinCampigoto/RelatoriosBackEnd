package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@OneToOne(mappedBy = "consultor", cascade = CascadeType.REMOVE)
	private MelhoriasAtingidas melhorias_atingidas;
	
	@OneToOne(mappedBy = "consultor", cascade = CascadeType.REMOVE)
	private Atividades atividades;
	
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
}
