package projeto;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	private String nome, id;
	
	List <Filme> filmesEmprestados = new ArrayList<>();
	
	public Usuario(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}
	
	public abstract int limiteEmprestimos();
	
	public void emprestarFilme(Filme filme) throws Exception {
		if (filmesEmprestados.contains(filme)) {
			throw new Exception("Este filme já está emprestado para este usuário.");
		}
		
		if (filmesEmprestados.size() >= limiteEmprestimos()) {
			throw new Exception("Limite mensal atingido. Espere até próximo mês.");
		} else {
			filme.emprestar();
			filmesEmprestados.add(filme);
		}
	}
	
	public void devolverFilme(Filme filme) throws Exception {
		if (!filmesEmprestados.contains(filme)) {
			throw new Exception("O usuário não possui este filme. Impossível devolver.");
		} else {
			filme.devolver();
			filmesEmprestados.remove(filme);
		  }
	}
	
	public void exibirFilmesEmprestados() {
		for(Filme filme : filmesEmprestados) {
			System.out.println(filme);
		}
	}

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

}