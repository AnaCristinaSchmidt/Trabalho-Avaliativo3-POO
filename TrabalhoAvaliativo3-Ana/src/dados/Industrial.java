package dados;

public class Industrial extends Robo {

	private String setor;

	public Industrial(int id, String modelo, double valorDiario, String setor) {
		super(id, modelo, valorDiario);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	@Override
	public double calculaLocacao(int dias) {
		return 0;
	}

	@Override
	public String toString() {
		return getId() + "," + getModelo() + "," + getValorDiario() + "," + getSetor() + ";";
	}
}


