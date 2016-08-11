package codigo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Programa {

	public static void main(String[] args) {
		Retangulo original = new Retangulo(5, 3, 12, 10);
		ArrayList<Retangulo> muitosCortes = new ArrayList<Retangulo>();
		muitosCortes.add(new Retangulo(1,  7,  8, 14));
		muitosCortes.add(new Retangulo(7,  5, 11, 13));
		muitosCortes.add(new Retangulo(10, 7, 17, 14));
		muitosCortes.add(new Retangulo(9,  1, 17,  6));
		
		Deque<Retangulo> filaCircular = new LinkedList<Retangulo>();
		filaCircular.add(original);
		Interseccao interserc = new Interseccao();
		int area = 0;
		
		for (Retangulo corteAtual : muitosCortes) {
			int tamanho = filaCircular.size();
			
			for (int i = 0; i < tamanho; i++) {
				Retangulo ret = filaCircular.removeFirst();
				
				if (interserc.estaNasQuinas(ret, corteAtual) == true)
					filaCircular.add(ret);
				else {
					ArrayList<Retangulo> horizontal = interserc.cortaHorizontalmente(ret, corteAtual);
					Retangulo baixo = horizontal.get(0);
					Retangulo meio = horizontal.get(1);
					Retangulo topo = horizontal.get(2);
					
					if (baixo != null)
						filaCircular.add(baixo);
					if (topo != null)
						filaCircular.add(topo);
					
					if (meio != null) {
						ArrayList<Retangulo> vertical = interserc.cortaVerticalmente(meio, corteAtual);
						Retangulo esquerda = vertical.get(0);
						Retangulo centro = vertical.get(1);
						Retangulo direita = vertical.get(2);
						
						if (esquerda != null)
							filaCircular.add(esquerda);
						if (direita != null)
							filaCircular.add(direita);
					}
				}
			}
		}
		
		while (!filaCircular.isEmpty()) {
			Retangulo atual = filaCircular.removeFirst();
			area += atual.calculaArea();
		}
					
		
		
		area = area;
	}

}
