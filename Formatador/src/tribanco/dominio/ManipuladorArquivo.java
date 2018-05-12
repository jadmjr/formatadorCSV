package tribanco.dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipuladorArquivo {

	public static void main(String[] args) throws IOException {

		String caminho = "C:\\Users\\julimar.miranda\\Documents\\Teste SGP\\arquivos\\fonte\\CSU_ACQ_AGENDA_07052018_TOKENIZADO.txt";

		LeitorArquivoEntrada leitor = new LeitorArquivoEntrada();
		leitor.lerArquivo(caminho);

	}

}