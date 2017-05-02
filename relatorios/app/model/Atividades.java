package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atividades")
public class Atividades {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "data")
	private Timestamp data;
	@Column(name = "area")
	private String area;
	@Column(name = "programa")
	private String programa;
	@Column(name = "ferramenta")
	private String ferramenta;
	@Column(name = "atividades")
	private String atividades;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "inicio")
	private Time inicio;
	@Column(name = "fim")
	private Time fim;
	@Column(name = "tempo")
	private Time tempo;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "consultor_id")
	private Consultor consultor;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Consultor getConsultor() {
		return this.consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Time getInicio() {
		return inicio;
	}

	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	public Time getFim() {
		return fim;
	}

	public void setFim(Time fim) {
		this.fim = fim;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}

}
