package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		try {
			Instant start = Instant.now();
			
			Scanner leitor = new Scanner(new File("c35000"));
			Retangulo original = new Retangulo(
				leitor.nextInt(),
				leitor.nextInt(),
				leitor.nextInt(),
				leitor.nextInt()
			);
			Deque<Retangulo> filaCircular = new LinkedList<Retangulo>();
			filaCircular.add(original);
			Interseccao interserc = new Interseccao();
			int area = 0;
			
			int quantidadeDeRetangulos = leitor.nextInt();
			
			int atual = 0;
			while (atual < quantidadeDeRetangulos) {
				Retangulo corteAtual = new Retangulo(
					leitor.nextInt(),
					leitor.nextInt(),
					leitor.nextInt(),
					leitor.nextInt()
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
				
				atual++;
			}
			
			area = 0;
			for (Retangulo aux : filaCircular)
				area += aux.calculaArea();
			Instant end = Instant.now();
			System.out.println("Área: " + area + " - " + Duration.between(start, end));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
