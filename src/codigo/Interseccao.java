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
	
	public ArrayList<Retangulo> cortaHorizontalmente(Retangulo original, Retangulo corte, long count) {
		
		count++;
		ArrayList<Retangulo> lista = new ArrayList<Retangulo>();
		
		if (original.getY2() > corte.getY2() && original.getY1() < corte.getY1()) { //retangulo original ocupa 3 linhas
			Retangulo topo = new Retangulo(original.getX1(), corte.getY2(), original.getX2(), original.getY2(), count);
			Retangulo meio = new Retangulo(original.getX1(), corte.getY1(), original.getX2(), corte.getY2(), count);
			Retangulo baixo = new Retangulo(original.getX1(), original.getY1(), original.getX2(), corte.getY1(), count);
			count++;
			lista.add(baixo);
			count++;
			lista.add(meio);
			count++;
			lista.add(topo);
		}
		else if(original.getY2() > corte.getY2() && corte.getY2() > original.getY1()) { //retangulo ocupa a linha de cima e a do meio
			Retangulo topo = new Retangulo(original.getX1(), corte.getY2(), original.getX2(), original.getY2(), count);
			Retangulo meio = new Retangulo(original.getX1(), original.getY1(), original.getX2(), corte.getY2(), count);
			count++;
			lista.add(null);
			count++;
			lista.add(meio);
			count++;
			lista.add(topo);
		}
		else if(original.getY1() < corte.getY1() && corte.getY1() < original.getY2()) { //retangulo ocupa a linha do meio, e a de baixo
			Retangulo meio = new Retangulo(original.getX1(), corte.getY1(), original.getX2(), original.getY2(), count);
			Retangulo baixo = new Retangulo(original.getX1(), original.getY1(), original.getX2(), corte.getY1(), count);
			count++;
			lista.add(baixo);
			count++;
			lista.add(meio);
			count++;
			lista.add(null);
		}
		else { //retangulo esta contido em apenas uma linha
			Retangulo ret = new Retangulo(original.getX1(), original.getY1(), original.getX2(), original.getY2(), count);
			
			//essa linha é a do topo
			if (original.getY1() >= corte.getY2() && original.getY2() > corte.getY2()) {
				count++;
				lista.add(null);
				count++;
				lista.add(null);
				count++;
				lista.add(ret);
			}
			//essa linha é a do centro
			else if (original.getY2() <= corte.getY2() && original.getY1() >= corte.getY1()) {
				count++;
				lista.add(null);
				count++;
				lista.add(ret);
				count++;
				lista.add(null);
			}
			//essa linha é a de baixo
			else {
				count++;
				lista.add(ret);
				count++;
				lista.add(null);
				count++;
				lista.add(null);
			}
		}
		
		count++;
		return lista;
	}
	
	public ArrayList<Retangulo> cortaVerticalmente(Retangulo original, Retangulo corte, long count) {
		count++;
		ArrayList<Retangulo> lista = new ArrayList<Retangulo>();
		
		if (original.getX1() < corte.getX1() && original.getX2() > corte.getX2()) { //retangulo ocupa 3 colunas
			Retangulo esquerda = new Retangulo(original.getX1(), original.getY1(), corte.getX1(), original.getY2(), count);
			Retangulo centro = new Retangulo(corte.getX1(), original.getY1(), corte.getX2(), original.getY2(), count);
			Retangulo direita = new Retangulo(corte.getX2(), original.getY1(), original.getX2(), original.getY2(), count);
			count++;
			lista.add(esquerda);
			count++;
			lista.add(centro);
			count++;
			lista.add(direita);
		}
		else if (original.getX1() < corte.getX1() && corte.getX1() < original.getX2()) { //retangulo ocupa a coluna do meio e da esquerda
			Retangulo esquerda = new Retangulo(original.getX1(), original.getY1(), corte.getX1(), original.getY2(), count);
			Retangulo centro = new Retangulo(corte.getX1(), original.getY1(), original.getX2(), original.getY2(), count);
			count++;
			lista.add(esquerda);
			count++;
			lista.add(centro);
			count++;
			lista.add(null);
		}
		else if (original.getX1() < corte.getX2() && corte.getX2() < original.getX2()) { //retangulo ocupa a coluna do meio e da direita
			Retangulo centro = new Retangulo(original.getX1(), original.getY1(), corte.getX2(), original.getY2(), count);
			Retangulo direita = new Retangulo(corte.getX2(), original.getY1(), original.getX2(), original.getY2(), count);
			count++;
			lista.add(null);
			count++;
			lista.add(centro);
			count++;
			lista.add(direita);
		}
		//retangulo esta contido em apenas uma coluna
		else {
			Retangulo ret = new Retangulo(original.getX1(), original.getY1(), original.getX2(), original.getY2(), count);
			
			//essa coluna é a da direita
			if (original.getX1() >= corte.getX2() && original.getX2() > corte.getX2()) {
				count++;
				lista.add(null);
				count++;
				lista.add(null);
				count++;
				lista.add(ret);
			}
			//essa colunas é a do centro
			else if (original.getX2() <= corte.getX2() && original.getX1() >= corte.getX1()) {
				count++;
				lista.add(null);
				count++;
				lista.add(ret);
				count++;
				lista.add(null);
			}
			//essa linha é a da esquerda
			else {
				count++;
				lista.add(ret);
				count++;
				lista.add(null);
				count++;
				lista.add(null);
			}
		}
		
		count++;
		return lista;
	}
	
	
	
	//Nao usar esses metodos aqui pra baixo!
	
	
	
	public Retangulo cortaAEsquerda(Retangulo original, Retangulo corte, int count) {
		if (original.getX1() < corte.getX1() && corte.getX1() <= original.getX2())
			return new Retangulo(original.getX1(), original.getY1(), corte.getX1(), original.getY2(), count);
		else
			return null;
	}

	public Retangulo cortaADireita(Retangulo original, Retangulo corte, int count) {
		if (original.getX1() <= corte.getX2() && corte.getX2() < original.getX2())
			return new Retangulo(corte.getX2(), original.getY1(), original.getX2(), original.getY2(), count);
		else
			return null;
	}

	public Retangulo cortaAcima(Retangulo original, Retangulo corte, int count) {
		if (original.getY1() <= corte.getY2() && corte.getY2() < original.getY2())
			return new Retangulo(corte.getX1(), corte.getY2(), corte.getX2(), original.getY2(), count);
		else
			return null;
	}

	public Retangulo cortaAbaixo(Retangulo original, Retangulo corte, int count) {
		if (original.getY1() < corte.getY1() && corte.getY1() <= original.getY2())
			return new Retangulo(corte.getX1(), original.getY1(), corte.getX2(), corte.getY1(), count);
		else
			return null;
	}
}
