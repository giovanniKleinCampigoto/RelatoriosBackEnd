package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@OneToOne(mappedBy = "status", cascade = CascadeType.REMOVE)
	private MelhoriasAtingidas melhorias_atingidas;
	
	@OneToOne(mappedBy = "status", cascade = CascadeType.REMOVE)
	private Atividades atividades;
	
	@OneToOne(mappedBy = "status", cascade = CascadeType.REMOVE)
	private ObsCronograma obscronograma;

	
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
	
	

}
