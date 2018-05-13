package tribanco.dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivoEntrada {

	public void lerArquivo(Parametros parametros) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(parametros.getPathArquivo()));

		ConverteCSV conversor = new ConverteCSV();
		GravaArquivoSaida gravador = new GravaArquivoSaida();
		parametros.setLinha("");

		int contador = 0;

		while (true) {
			if (parametros.getLinha() != null) {

				// PULANDO A LINHA DO CABECALHO
				if (contador > 1) {
					parametros.setLinha(conversor.converteLinha(parametros.getLinha()));
					gravador.gravaArquivo(parametros);
					System.out.println("Gravou a linha:" + contador);
				}
				if (contador == 1) {
					String cabecalho = "tipReg;numOrg;numEc;numLoja;dtEfetiva;dtMov;dtAgendamento;transacao;descricao;numParcela;totalParcela;plastico;numAutorizacao;nsu;vlTotal;vlBruto;vlLiquido;vlDesc;vlDescAntecip;vlLiquiAntecip;banco;agencia;conta;debCred;bandeira;txDescon;vl01;vl02;vl03;tipoCartao;statusTransacao;bloqFraude;filler;";
					parametros.setLinha(cabecalho);
					gravador.gravaArquivo(parametros);
				}

			} else {
				break;
			}
			parametros.setLinha(buffRead.readLine());
			contador++;
		}
		buffRead.close();

	}

}
