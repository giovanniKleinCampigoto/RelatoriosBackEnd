package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "observacao")
public class ObsCronograma {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;	
	@Column(name = "previsto")
	private String previsto;
	@Column(name = "realizado")
	private String realizado;
	@Column(name = "criado")
	private Timestamp criado;
	
	@ManyToOne
	@JoinColumn(name = "status_id")	
	private Status status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrevisto() {
		return previsto;
	}
	public void setPrevisto(String previsto) {
		this.previsto = previsto;
	}
	public String getRealizado() {
		return realizado;
	}
	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}
	
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Timestamp getCriado() {
		return criado;
	}
	public void setCriado(Timestamp criado) {
		this.criado = criado;
	}
	
	
}
