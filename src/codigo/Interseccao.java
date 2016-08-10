package codigo;

import java.util.ArrayList;

public class Interseccao {
	public Interseccao() {
		
	}

	public boolean estaNasQuinas(Retangulo original, Retangulo corte) {
		if (original.getX2() <= corte.getX1() && original.getY1() >= corte.getY2() || //superior esquerdo 
		    original.getX2() <= corte.getX1() && original.getY2() <= corte.getY1() || //inferior esquerdo
		    original.getX1() >= corte.getX2() && original.getY1() >= corte.getY2() || //superior direito
		    original.getX1() >= corte.getX2() && original.getY2() <= corte.getY1() ||   //inferior direito
		    
		    //centro-vertical, à esquerda
		    original.getX2() <= corte.getX1() && original.getY2() <= corte.getY2() && original.getY1() >= corte.getY1() ||
		    
		    //centro-vertical, à direita
		    original.getX1() >= corte.getX2() && original.getY2() <= corte.getY2() && original.getY1() >= corte.getY1() ||
		    
		    //centro-horizontal, acima
		    original.getX1() >= corte.getX1() && original.getX2() <= corte.getX2() && original.getY1() >= corte.getY2() ||
		    
    		//centro-horizontal, abaixo
		    original.getX1() >= corte.getX1() && original.getX2() <= corte.getX2() && original.getY2() <= corte.getY1()
		   )
			return true;
		else
			return false;
	}
	
	public ArrayList<Retangulo> cortaEmPartesVerticais(Retangulo original, Retangulo corte) {
		
		ArrayList<Retangulo> lista = new ArrayList<Retangulo>();
		
		if (original.getY2() > corte.getY2() && original.getY1() < corte.getY1()) { //retangulo original ocupa 3 linhas
			Retangulo topo = new Retangulo(original.getX1(), corte.getY2(), original.getX2(), original.getY2());
			Retangulo meio = new Retangulo(original.getX1(), corte.getY1(), original.getX2(), corte.getY2());
			Retangulo baixo = new Retangulo(original.getX1(), original.getY1(), original.getX2(), corte.getY1());
			lista.add(topo);
			lista.add(meio);
			lista.add(baixo);
		}
		else if(original.getY2() > corte.getY2() && original.getY1() >= corte.getY1()) { //retangulo ocupa a linha de cima e a do meio
			Retangulo topo = new Retangulo(original.getX1(), corte.getY2(), original.getX2(), original.getY2());
			Retangulo meio = new Retangulo(original.getX1(), original.getY1(), original.getX2(), corte.getY2());
			lista.add(topo);
			lista.add(meio);
		}
		else { //retangulo ocupa a linha do meio, e a de baixo
			Retangulo meio = new Retangulo(original.getX1(), corte.getY1(), original.getX2(), original.getY2());
			Retangulo baixo = new Retangulo(original.getX1(), original.getY1(), original.getX2(), corte.getY1());
			lista.add(meio);
			lista.add(baixo);
		}
		
		return lista;
	}
	
	public ArrayList<Retangulo> cortaEmPartesHorizontais(Retangulo original, Retangulo corte) {
		
		ArrayList<Retangulo> lista = new ArrayList<Retangulo>();
		
		if (original.getX1() < corte.getX1() && original.getX2() > corte.getX2()) { //retangulo ocupa 3 colunas
			Retangulo esquerda = new Retangulo(original.getX1(), original.getY1(), corte.getX1(), original.getY2());
			Retangulo centro = new Retangulo(corte.getX1(), original.getY1(), corte.getX2(), original.getY2());
			Retangulo direita = new Retangulo(corte.getX2(), original.getY1(), original.getX2(), original.getY2());
			lista.add(esquerda);
			lista.add(centro);
			lista.add(direita);
		}
		else if (original.getX1() < corte.getX1() && original.getX2() <= corte.getX2()) { //retangulo ocupa a coluna do meio e da esquerda
			Retangulo esquerda = new Retangulo(original.getX1(), original.getY1(), corte.getX1(), original.getY2());
			Retangulo centro = new Retangulo(corte.getX1(), original.getY1(), original.getX2(), original.getY2());
			lista.add(esquerda);
			lista.add(centro);
		}
		else { //retangulo ocupa a coluna do meio e da direita
			Retangulo centro = new Retangulo(original.getX1(), original.getY1(), corte.getX2(), original.getY2());
			Retangulo direita = new Retangulo(corte.getX2(), original.getY1(), original.getX2(), original.getY2());
			lista.add(centro);
			lista.add(direita);
		}
		
		return lista;
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
