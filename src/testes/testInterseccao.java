package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import codigo.Interseccao;
import codigo.Retangulo;

public class testInterseccao {
	
	@Test
	public void testCortaAEsquerda() {
		Retangulo original = new Retangulo(0, 0, 3, 3);
		Retangulo corte = new Retangulo(1, 1, 2, 2);
		Interseccao interserc = new Interseccao();
		
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
		Retangulo original = new Retangulo(0, 0, 3, 3);
		Retangulo corte = new Retangulo(1, 1, 2, 2);
		Interseccao interserc = new Interseccao();
		
		Retangulo retDireita = interserc.cortaADireita(original, corte);
		assertEquals(2, retDireita.getX1());
		assertEquals(0, retDireita.getY1());
		assertEquals(3, retDireita.getX2());
		assertEquals(3, retDireita.getY2());
		assertEquals(3, retDireita.calculaArea());
	}
	
	@Test 
	public void testCortaEmCima() {
		Retangulo original = new Retangulo(0, 0, 3, 3);
		Retangulo corte = new Retangulo(1, 1, 2, 2);
		Interseccao interserc = new Interseccao();
		
		Retangulo retAcima = interserc.cortaAcima(original, corte);
		assertEquals(1, retAcima.getX1());
		assertEquals(2, retAcima.getY1());
		assertEquals(2, retAcima.getX2());
		assertEquals(3, retAcima.getY2());
		assertEquals(1, retAcima.calculaArea());
	}
	
	@Test 
	public void testCortaEmBaixo() {
		Retangulo original = new Retangulo(0, 0, 3, 3);
		Retangulo corte = new Retangulo(1, 1, 2, 2);
		Interseccao interserc = new Interseccao();
		
		Retangulo retAbaixo = interserc.cortaAbaixo(original, corte);
		assertEquals(1, retAbaixo.getX1());
		assertEquals(0, retAbaixo.getY1());
		assertEquals(2, retAbaixo.getX2());
		assertEquals(1, retAbaixo.getY2());
		assertEquals(1, retAbaixo.calculaArea());
	}

	
}
