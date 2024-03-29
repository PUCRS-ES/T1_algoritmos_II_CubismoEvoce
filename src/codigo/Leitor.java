package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
	private File arquivo;
	private BufferedReader reader;
	
	public Leitor(String nomeArquivo) throws FileNotFoundException {
		arquivo = new File(nomeArquivo);
		if(arquivo.exists())
			reader = new BufferedReader(new FileReader(arquivo));
		else
			throw new FileNotFoundException();
	}
	
	public String leProximaLinha() throws IOException {
		return reader.readLine();
	}
	
	public void fechaArquivo() throws IOException {
		reader.close();
	}
}
