package projeto;

public abstract class Filme implements Emprestavel {
	private String titulo, diretor;
	private int codigo;
	private boolean emprestado;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean isEmprestado() {
		return emprestado;
	}
	
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	public String emprestar() throws Exception {
		if (this.emprestado) {
			throw new Exception("Filme emprestado para outro usuário");
		}
		this.emprestado = true;
		return "Filme emprestado com sucesso! Aproveite! :D";
	}
	
	public String devolver() throws Exception {
		if (!this.emprestado) {
			throw new Exception("Voce não possui o filme. Impossível devolver");
		} 
		this.emprestado = false;
		return "Filme devolvido com sucesso!";
	}

	@Override
	public String toString() {
		return "=== FILME === \nTitulo: " + titulo + "\nDiretor: " + diretor + "\nCodigo: " + codigo + "\nEmprestado: " + emprestado;
	}

}