package tribanco.dominio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravaArquivoSaida {

	public void gravaArquivo(String linha) throws IOException {

		String saida = "C:\\Users\\julimar.miranda\\Documents\\Teste SGP\\arquivos\\saida_formatador\\CSU_ACQ_AGENDA_11052018.csv";
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(saida, true));
		buffWrite.append(linha+"\n");
		buffWrite.close();

	}

}
