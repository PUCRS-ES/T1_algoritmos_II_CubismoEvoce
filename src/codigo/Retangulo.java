package codigo;

public class Retangulo {
	public boolean isValido = true;
	//posso tranquilamente trocar por short para acelerar o tempo de calculo e reduzir memoria
	private short X1, X2, Y1, Y2;
	
	public Retangulo (short x1, short y1, short x2, short y2, long count) {
		X1 = x1;
		X2 = x2;
		Y1 = y1;
		Y2 = y2;
		count = count + 4;
	}
	
	public int calculaArea() {
		return (X2 - X1) *  (Y2 - Y1);
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
		short aux = X1;
		X1 = X2;
		X2 = aux;
	}
	
	public short getX1() {
		return X1;
	}
	
	public short getX2() {
		return X2;
	}

	public void trocaY() {
		short aux = Y1;
		Y1 = Y2;
		Y2 = aux;
	}
	
	public short getY1() {
		return Y1;
	}
	
	public short getY2() {
		return Y2;
	}
}
