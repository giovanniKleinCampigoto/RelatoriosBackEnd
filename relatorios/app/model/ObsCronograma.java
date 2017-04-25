package model;

public class ObsCronograma {

	private int id;
	private int status_id;
	private String previsto;
	private String realizado;
	
	
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
	
	
}
