package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import codigo.Retangulo;

public class testRetangulo {
	
	@Test
	public void testaValido() {
		Retangulo ret = new Retangulo(1, 1, 3, 3);
		assertEquals(true, ret.isValido);
	}
	
	@Test
	public void testaInvalido() {
		Retangulo ret = new Retangulo(0, 0, 0, 9);
		assertEquals(false, ret.isValido);
	}
	
	@Test
	public void testaArea() {
		Retangulo ret = new Retangulo(0, 0, 3, 3);
		assertEquals(9, ret.calculaArea());
		
		ret = new Retangulo(0, 0, 5, 5);
		assertEquals(25, ret.calculaArea());
	}
	
	@Test
	public void testaIsXTrocado() {
		Retangulo ret = new Retangulo(0, 0, 2, 2);
		assertEquals(false, ret.isXInvertido());
		
		ret = new Retangulo(2, 2, 0, 0);
		assertEquals(true, ret.isXInvertido());
	}
	
	@Test
	public void testaIsYTrocado() {
		Retangulo ret = new Retangulo(0, 0, 2, 2);
		assertEquals(false, ret.isYInvertido());
		
		ret = new Retangulo(2, 2, 0, 0);
		assertEquals(true, ret.isYInvertido());
	}
	
	@Test
	public void testaTrocaX() {
		Retangulo ret = new Retangulo(0, 0, 2, 2);
		ret.trocaX();
		assertEquals(2, ret.getX1());
		assertEquals(0, ret.getX2());
	}
	
	@Test
	public void testaTrocaY() {
		Retangulo ret = new Retangulo(0, 0, 2, 2);
		ret.trocaY();
		assertEquals(2, ret.getY1());
		assertEquals(0, ret.getY2());
	}
}
