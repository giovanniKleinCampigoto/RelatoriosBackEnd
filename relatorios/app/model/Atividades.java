package model;

import java.sql.Date;
import java.sql.Time;

public class Atividades {

	private int id;
	private int status_id;
	private int consultor_id;
	private int cliente_id;
	private Date data;
	private String area;
	private String programa;
	private String ferramenta;
	private String atividades;
	private String tipo;
	private Time inicio;
	private Time fim;
	private Time tempo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getConsultor_id() {
		return consultor_id;
	}

	public void setConsultor_id(int consultor_id) {
		this.consultor_id = consultor_id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
