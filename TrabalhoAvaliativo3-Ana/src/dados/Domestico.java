package dados;

public class Domestico extends Robo {

	private int nivel;


	public Domestico(int id, String modelo, double valorDiario, int nivel) {
		super(id, modelo, valorDiario);
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	@Override
	public double calculaLocacao(int dias) {
		return 0;
	}

	@Override
	public String toString() {
		return getId() + "," + getModelo() + "," +getValorDiario() + "," + getNivel() + ";";
	}
}
