package projeto;

public class FilmeDigital extends Filme {
	private double tamanhoGB;

	public double getTamanhoGB() {
		return tamanhoGB;
	}

	public void setTamanhoGB(double tamanhoGB) {
		this.tamanhoGB = tamanhoGB;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTamanhoGB: " + tamanhoGB;
	}
	
	
}
