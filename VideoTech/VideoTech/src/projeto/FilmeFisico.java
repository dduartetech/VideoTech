package projeto;

public class FilmeFisico extends Filme {
	private int duracaoMinutos;

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	@Override
	public String toString() {
		return super.toString() + "\nDuracaoMinutos: " + duracaoMinutos;
	}
	
	

}
