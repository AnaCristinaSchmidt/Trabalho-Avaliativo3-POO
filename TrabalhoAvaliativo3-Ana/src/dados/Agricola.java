package dados;

public class Agricola extends Robo {

	private double area;

	private String uso;

	public Agricola(int id, String modelo, double valorDiario, double area, String uso){
		super(id,  modelo, valorDiario);
		this.area = area;
		this.uso = uso;
	}
	public double getArea(){
		return area;
	}
	public String getUso(){
		return uso;
	}

	@Override
	public double calculaLocacao(int dias){
		return 0;
	}

	@Override
	public String toString() {
		return getId() + "," + getModelo() + "," + getValorDiario() + "," + getArea() + "," + getUso() + ";";
	}
}
