package tribanco.dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivoEntrada {

	public void lerArquivo(String caminho) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(caminho));

		ConverteCSV conversor = new ConverteCSV();
		GravaArquivoSaida gravador = new GravaArquivoSaida();

		String linha = "";
		String linhaCSV = "";
		int contador = 0;

		while (true) {
			if (linha != null) {

				// PULANDO A LINHA DO CABECALHO
				if (contador > 1) {
					linhaCSV = conversor.converteLinha(linha);
					gravador.gravaArquivo(linhaCSV);
					//System.out.println("Gravou a linha:" + contador);
				}
				if (contador == 1) {
					String cabecalho = "tipReg;numOrg;numEc;numLoja;dtEfetiva;dtMov;dtAgendamento;transacao;descricao;numParcela;totalParcela;plastico;numAutorizacao;nsu;vlTotal;vlBruto;vlLiquido;vlDesc;vlDescAntecip;vlLiquiAntecip;banco;agencia;conta;debCred;bandeira;txDescon;vl01;vl02;vl03;tipoCartao;statusTransacao;bloqFraude;filler;";
					gravador.gravaArquivo(cabecalho);
				}

			} else
				break;
			linha = buffRead.readLine();
			contador++;
		}
		buffRead.close();

	}

}
