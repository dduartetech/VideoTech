package projeto;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
	public List <Filme> filmesDisp = new ArrayList<>();
	public List <Usuario> usuarios = new ArrayList<>();
	
	public void cadastrarFilme(Filme filme) {
		filmesDisp.add(filme);
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public List <Filme> buscarFilme(String titulo) {
		List <Filme> encontrados = new ArrayList<>();
		for (Filme filme : filmesDisp) {
			if (filme.getTitulo().equalsIgnoreCase(titulo)) {
				encontrados.add(filme);
			}
		}
		return encontrados;
	}
	
	public List <Usuario> buscarUsuario(String id) {
		List <Usuario> encontrados = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				encontrados.add(usuario);
			}
		}
		return encontrados;
	}
	
	public List <Filme> filmesDisponiveis() {
		List <Filme> disponiveis = new ArrayList();
		for (Filme filme : filmesDisp) {
			if(!filme.isEmprestado()) {
				disponiveis.add(filme);
			}
		}
		return disponiveis;
	}
	
	public List <Filme> filmesEmprestados(){
		List <Filme> emprestados = new ArrayList<>();
		for (Filme filme : filmesDisp) {
			if (filme.isEmprestado()) {
				emprestados.add(filme);
			}
		}
		return emprestados;
	}
	
}