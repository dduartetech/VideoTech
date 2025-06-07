package projeto;

public class UsuarioFree extends Usuario {
	public UsuarioFree(String nome, String id) {
		super(nome, id);
	}

	@Override
	public int limiteEmprestimos() {
		return 5;
	}

}
