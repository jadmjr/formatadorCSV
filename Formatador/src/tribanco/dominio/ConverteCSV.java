package tribanco.dominio;

public class ConverteCSV {
	String linhaSaida;

	String tipReg;
	String numOrg;
	String numEc;
	String numLoja;
	String dtEfetiva;
	String dtMov;
	String dtAgendamento;
	String transacao;
	String descricao;
	String numParcela;
	String totalParcela;
	String plastico;
	String numAutorizacao;
	String nsu;
	String vlTotal;
	String vlBruto;
	String vlLiquido;
	String vlDesc;
	String vlDescAntecip;
	String vlLiquiAntecip;
	String banco;
	String agencia;
	String conta;
	String debCred;
	String bandeira;
	String txDescon;
	String vl01;
	String vl02;
	String vl03;
	String tipoCartao;
	String statusTransacao;
	String bloqFraude;
	String filler;

	public String converteLinha(String linha) {

		tipReg = linha.substring(0, 2);
		numOrg = linha.substring(2, 5);
		numEc = linha.substring(5, 20);
		numLoja = linha.substring(20, 35);
		dtEfetiva = linha.substring(35, 43);
		dtMov = linha.substring(43, 51);
		dtAgendamento = linha.substring(51, 59);
		transacao = linha.substring(59, 64);
		descricao = linha.substring(64, 84);
		numParcela = linha.substring(84, 86);
		totalParcela = linha.substring(86, 88);
		plastico = linha.substring(88, 107);
		numAutorizacao = linha.substring(107, 113);
		nsu = linha.substring(113, 124);
		vlTotal = linha.substring(124, 139);
		vlBruto = linha.substring(139, 154);
		vlLiquido = linha.substring(154, 169);
		vlDesc = linha.substring(169, 184);
		vlDescAntecip = linha.substring(184, 199);
		vlLiquiAntecip = linha.substring(199, 214);
		banco = linha.substring(214, 217);
		agencia = linha.substring(217, 221);
		conta = linha.substring(221, 231);
		debCred = linha.substring(231, 232);
		bandeira = linha.substring(232, 235);
		txDescon = linha.substring(235, 240);
		vl01 = linha.substring(240, 255);
		vl02 = linha.substring(255, 260);
		vl03 = linha.substring(260, 275);
		tipoCartao = linha.substring(275, 276);
		statusTransacao = linha.substring(276, 277);
		bloqFraude = linha.substring(277, 278);
		
		
		linhaSaida = tipReg + ";" + numOrg + ";" + numEc + ";" + numLoja + ";" + dtEfetiva + ";" + dtMov + ";"
				+ dtAgendamento + ";" + transacao + ";" + descricao + ";" + numParcela + ";" + totalParcela + ";"
				+ plastico + ";" + numAutorizacao + ";" + nsu + ";" + vlTotal + ";" + vlBruto + ";" + vlLiquido + ";"
				+ vlDesc + ";" + vlDescAntecip + ";" + vlLiquiAntecip + ";" + banco + ";" + agencia + ";" + conta + ";"
				+ debCred + ";" + bandeira + ";" + txDescon + ";" + vl01 + ";" + vl02 + ";" + vl03 + ";" + tipoCartao
				+ ";" + statusTransacao + ";" + bloqFraude + ";" + filler;
		
		if(numEc.contains("50797") && vlLiquido.contains("722455"))
			System.out.println(linhaSaida);
		
		return linhaSaida;
	}

}
