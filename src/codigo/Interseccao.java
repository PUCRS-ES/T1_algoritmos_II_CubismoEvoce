package codigo;

import java.util.ArrayList;

public class Interseccao {
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
		if (original.getY1() <= corte.getY2() && corte.getY2() < original.getY2()) {
			int limiteEsquerdo = corte.getX1();
			if (limiteEsquerdo < original.getX1())
				limiteEsquerdo = original.getX1();
			
			int limiteDireito = corte.getX2();
			if (original.getX2() < limiteDireito)
				limiteDireito = original.getX2();
			
			return new Retangulo(limiteEsquerdo, corte.getY2(), limiteDireito, original.getY2());
		}
		else
			return null;
	}

	public Retangulo cortaAbaixo(Retangulo original, Retangulo corte) {
		if (original.getY1() < corte.getY1() && corte.getY1() <= original.getY2()) {
			int limiteEsquerdo = corte.getX1();
			if (limiteEsquerdo < original.getX1())
				limiteEsquerdo = original.getX1();
			
			int limiteDireito = corte.getX2();
			if (original.getX2() < limiteDireito)
				limiteDireito = original.getX2();
			
			return new Retangulo(limiteEsquerdo, original.getY1(), limiteDireito, corte.getY1());
		}
		else
			return null;
	}

	public ArrayList<Retangulo> cortaTodos(Retangulo original, Retangulo corte) {
		//Considerar o uso de um vetor ao inves de ArrayList. O comprimento máximo será 4 sempre
		ArrayList<Retangulo> areaVisivel = new ArrayList<Retangulo>();
		
		Retangulo retEsq = cortaAEsquerda(original, corte);
		Retangulo retDir = cortaADireita(original, corte);
		Retangulo retCim = cortaAcima(original, corte);
		Retangulo retBai = cortaAbaixo(original, corte);
		
		if (retEsq != null)
			areaVisivel.add(retEsq);
		if (retDir != null)
			areaVisivel.add(retDir);
		if (retCim != null)
			areaVisivel.add(retCim);
		if (retBai != null)
			areaVisivel.add(retBai);
		
		return areaVisivel;
	}
}
