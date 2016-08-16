package codigo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Programa {

	public static void main(String[] args) {
		try {
			Leitor leitor = new Leitor("c50000");
			String linha = leitor.leProximaLinha();
			String[] dados = linha.split(" ");
			Retangulo original = new Retangulo(
				Integer.parseInt(dados[0]),
				Integer.parseInt(dados[1]),
				Integer.parseInt(dados[2]),
				Integer.parseInt(dados[3])
			);
			Deque<Retangulo> filaCircular = new LinkedList<Retangulo>();
			filaCircular.add(original);
			Interseccao interserc = new Interseccao();
			int area = 0;
			
			linha = leitor.leProximaLinha();
			int quantidadeDeRetangulos = Integer.parseInt(linha);
			
			int atual = 0;
			while (atual < quantidadeDeRetangulos) {
				linha = leitor.leProximaLinha();
				dados = linha.split(" ");
				Retangulo corteAtual = new Retangulo(
					Integer.parseInt(dados[0]),
					Integer.parseInt(dados[1]),
					Integer.parseInt(dados[2]),
					Integer.parseInt(dados[3])
				);

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
				
				area = 0;
				for (Retangulo aux : filaCircular)
					area += aux.calculaArea();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				atual++;
				System.out.println("Retangulo atual: " + atual + " - Área: " + area);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
