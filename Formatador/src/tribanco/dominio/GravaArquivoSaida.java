package tribanco.dominio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravaArquivoSaida {

	public void gravaArquivo(Parametros parametros) throws IOException {
		
		String saida  = parametros.getDirDestino()+"\\"+parametros.getNomeArquivo().replaceAll("TXT", "csv");
		System.out.println("arq saisa"+saida);
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(saida, true));
		buffWrite.append(parametros.getLinha()+"\n");
		buffWrite.close();

	}

}
