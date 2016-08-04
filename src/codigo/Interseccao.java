package codigo;

import java.util.ArrayList;

public class Interseccao {
	ArrayList<Retangulo> resultado = new ArrayList<Retangulo>();
	
	public Interseccao() {
		
	}

	public Retangulo cortaAEsquerda(Retangulo original, Retangulo corte) {
		if (original.getX1() < corte.getX1() && corte.getX1() <= original.getX2())
			return new Retangulo(original.getX1(), original.getY1(), corte.getX1(), original.getY2());
		else
			return null;
	}

	public Retangulo cortaADireita(Retangulo original, Retangulo corte) {
		if (original.getX1() <= corte.getX2() && corte.getX2() < original.getX2())
			return new Retangulo(corte.getX2(), original.getY1(), original.getX2(), original.getY2());
		else
			return null;
	}

	public Retangulo cortaAcima(Retangulo original, Retangulo corte) {
		if (original.getY1() <= corte.getY2() && corte.getY2() < original.getY2())
			return new Retangulo(corte.getX1(), corte.getY2(), corte.getX2(), original.getY2());
		else
			return null;
	}

	public Retangulo cortaAbaixo(Retangulo original, Retangulo corte) {
		if (original.getY1() < corte.getY1() && corte.getY1() <= original.getY2())
			return new Retangulo(corte.getX1(), original.getY1(), corte.getX2(), corte.getY1());
		else
			return null;
	}
}
