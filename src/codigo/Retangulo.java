package codigo;

public class Retangulo {
	public boolean isValido = true;
	//posso tranquilamente trocar por short para acelerar o tempo de calculo e reduzir memoria
	private int X1, X2, Y1, Y2;
	
	public Retangulo (int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2)
			isValido = false;
		
		//Testar ainda se os valores estao dentro da faixa 0 < x < 32.000
		
		X1 = x1;
		X2 = x2;
		Y1 = y1;
		Y2 = y2;
	}
	
	public int calculaArea() {
		return (X2 - X1) * (Y2 - Y1);
	}

	public boolean isXInvertido() {
		if (X1 > X2)
			return true;
		else
			return false;
	}

	public boolean isYInvertido() {
		if (Y1 > Y2)
			return true;
		else
			return false;
	}

	public void trocaX() {
		int aux = X1;
		X1 = X2;
		X2 = aux;
	}
	
	public int getX1() {
		return X1;
	}
	
	public int getX2() {
		return X2;
	}

	public void trocaY() {
		int aux = Y1;
		Y1 = Y2;
		Y2 = aux;
	}
	
	public int getY1() {
		return Y1;
	}
	
	public int getY2() {
		return Y2;
	}
}
