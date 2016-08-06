package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import codigo.Interseccao;
import codigo.Retangulo;

public class testInterseccao {
	Retangulo original = new Retangulo(0, 0, 3, 3);
	Retangulo corte = new Retangulo(1, 1, 2, 2);
	Interseccao interserc = new Interseccao();
	
	Retangulo retanguloPrincipalExercicio = new Retangulo(5, 3, 12, 10);
	Retangulo retangulo1Exercicio = new Retangulo(1, 7, 8, 14);
	Retangulo retangulo2Exercicio = new Retangulo(7, 5, 11, 13);
	Retangulo retangulo3Exercicio = new Retangulo(10, 7, 17, 14);
	Retangulo retangulo4Exercicio = new Retangulo(9, 1, 17, 6);
	
	@Test
	public void testCortaAEsquerda() {		
		Retangulo retEsquerda = interserc.cortaAEsquerda(original, corte);
		assertEquals(0, retEsquerda.getX1());
		assertEquals(0, retEsquerda.getY1());
		assertEquals(1, retEsquerda.getX2());
		assertEquals(3, retEsquerda.getY2());
		assertEquals(3, retEsquerda.calculaArea());
		
		Retangulo corte2 = new Retangulo(0, 0, 6, 3);
		Retangulo retSemInterseccao = interserc.cortaAEsquerda(original, corte2);
		assertEquals(null, retSemInterseccao);
	}
	
	@Test
	public void testCortaADireita() {
		Retangulo retDireita = interserc.cortaADireita(original, corte);
		assertEquals(2, retDireita.getX1());
		assertEquals(0, retDireita.getY1());
		assertEquals(3, retDireita.getX2());
		assertEquals(3, retDireita.getY2());
		assertEquals(3, retDireita.calculaArea());
		
		Retangulo corte2 = new Retangulo(2, 0, 3, 3);
		Retangulo retSemInterseccao = interserc.cortaADireita(original, corte2);
		assertEquals(null, retSemInterseccao);
	}
	
	@Test 
	public void testCortaEmCima() {
		Retangulo retAcima = interserc.cortaAcima(original, corte);
		assertEquals(1, retAcima.getX1());
		assertEquals(2, retAcima.getY1());
		assertEquals(2, retAcima.getX2());
		assertEquals(3, retAcima.getY2());
		assertEquals(1, retAcima.calculaArea());
		
		Retangulo corte2 = new Retangulo(0, 1, 3, 3);
		Retangulo retSemInterseccao = interserc.cortaAcima(original, corte2);
		assertEquals(null, retSemInterseccao);
		
		Retangulo novoTeste = interserc.cortaAcima(retanguloPrincipalExercicio, retangulo4Exercicio);
		assertEquals(9, novoTeste.getX1());
		assertEquals(12, novoTeste.getX2());
		assertEquals(6, novoTeste.getY1());
		assertEquals(10, novoTeste.getY2());
	}
	
	@Test 
	public void testCortaEmBaixo() {
		Retangulo retAbaixo = interserc.cortaAbaixo(original, corte);
		assertEquals(1, retAbaixo.getX1());
		assertEquals(0, retAbaixo.getY1());
		assertEquals(2, retAbaixo.getX2());
		assertEquals(1, retAbaixo.getY2());
		assertEquals(1, retAbaixo.calculaArea());
		
		Retangulo corte2 = new Retangulo(0, 0, 3, 3);
		Retangulo retSemInterseccao = interserc.cortaAbaixo(original, corte2);
		assertEquals(null, retSemInterseccao);
		
		Retangulo novoTeste = interserc.cortaAbaixo(retanguloPrincipalExercicio, retangulo1Exercicio);
		assertEquals(5, novoTeste.getX1());
		assertEquals(8, novoTeste.getX2());
		assertEquals(3, novoTeste.getY1());
		assertEquals(7, novoTeste.getY2());
	}
	
	@Test
	public void testCortaTodos() {
		ArrayList<Retangulo> areaVisivel = interserc.cortaTodos(original, corte);
		assertEquals(4, areaVisivel.size());
		
		int areaTotal = 0;
		for (Retangulo ret : areaVisivel)
			areaTotal += ret.calculaArea();
		assertEquals(8, areaTotal);
	}

	
}
