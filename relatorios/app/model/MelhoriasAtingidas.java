package model;

public class MelhoriasAtingidas {

	private int id;
	private int status_id;
	private int consultor_id;
	private int cliente_id;
	private String melhorias;

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

	public String getMelhorias() {
		return melhorias;
	}

	public void setMelhorias(String melhorias) {
		this.melhorias = melhorias;
	}

}
