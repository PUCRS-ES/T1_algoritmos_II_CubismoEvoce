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
			long count = 0;
			
			count++;
			Scanner leitor = new Scanner(new File("c10000"));
			
			count++;
			Retangulo original = new Retangulo(
				leitor.nextShort(),
				leitor.nextShort(),
				leitor.nextShort(),
				leitor.nextShort(),
				count
			);
			
			count++;
			Deque<Retangulo> filaCircular = new LinkedList<Retangulo>();
			count++;
			filaCircular.add(original);
			count++;
			Interseccao interserc = new Interseccao();
			count++;
			int area = 0;
			
			count++;
			int quantidadeDeRetangulos = leitor.nextInt();
			
			count++;
			int atual = 0;
			while (atual < quantidadeDeRetangulos) {
				count++;
				Retangulo corteAtual = new Retangulo(
					leitor.nextShort(),
					leitor.nextShort(),
					leitor.nextShort(),
					leitor.nextShort(),
					count
				);

				count++;
				int tamanho = filaCircular.size();
				for (int i = 0; i < tamanho; i++) {
					count++;
					
					count++;
					Retangulo ret = filaCircular.removeFirst();
					
					if (interserc.estaNasQuinas(ret, corteAtual) == true) {
						count++;
						filaCircular.add(ret);
					}
					else {
						count++;
						ArrayList<Retangulo> horizontal = interserc.cortaHorizontalmente(ret, corteAtual, count);
						count++;
						Retangulo baixo = horizontal.get(0);
						count++;
						Retangulo meio = horizontal.get(1);
						count++;
						Retangulo topo = horizontal.get(2);
						
						if (baixo != null) {
							count++;
							filaCircular.add(baixo);
						}
						if (topo != null) {
							count++;
							filaCircular.add(topo);
						}
						
						if (meio != null) {
							count++;
							ArrayList<Retangulo> vertical = interserc.cortaVerticalmente(meio, corteAtual, count);
							count++;
							Retangulo esquerda = vertical.get(0);
							count++;
							Retangulo centro = vertical.get(1);
							count++;
							Retangulo direita = vertical.get(2);
							
							if (esquerda != null) {
								count++;
								filaCircular.add(esquerda);
							}
							if (direita != null) {
								count++;
								filaCircular.add(direita);
							}
						}
					}
				}
				
				count++;
				atual++;
			}
			
			count++;
			area = 0;
			for (Retangulo aux : filaCircular) {
				count++;
				area += aux.calculaArea();
			}
			count++;
			System.out.println("Área: " + area + " - Operacoes: " + count);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
