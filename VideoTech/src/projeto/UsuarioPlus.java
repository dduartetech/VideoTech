package projeto;

public class UsuarioPlus extends Usuario {

	public UsuarioPlus(String nome, String id) {
		super(nome, id);
	}

	@Override
	public int limiteEmprestimos() {
		return 10;
	}
	
}
