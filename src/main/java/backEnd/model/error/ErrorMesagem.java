package backEnd.model.error;

public class ErrorMesagem {
	
	private String titulo;
	
	private Integer status;
	
	private String mensagem;
	
	



	public ErrorMesagem(String titulo, Integer status, String mensagem) {
		super();
		this.titulo = titulo;
		this.status = status;
		this.mensagem = mensagem;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getMesagem() {
		return mensagem;
	}



	public void setMesagem(String mesagem) {
		this.mensagem = mesagem;
	}

	
	
	
	
}
