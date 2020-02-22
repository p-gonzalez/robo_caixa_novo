package br.com.indra.UtilFile;

public class UtilFile {


	public static String createStringDiretorio(String nomeNovoArquivo) {
		String diretorio = nomeNovoArquivo.substring(27,31);
		diretorio = diretorio+"\\"+retornarNomeMes(nomeNovoArquivo.substring(31,33));
		diretorio = diretorio+"\\"+nomeNovoArquivo.substring(33,35);
		diretorio = diretorio+"\\"+nomeNovoArquivo.substring(35,37);//+"-"+nomeNovoArquivo.substring(37,39);
		return diretorio;
	}

	private static String retornarNomeMes(String numeroMes) {
		Integer mes = Integer.parseInt(numeroMes);
		switch(mes){
		case 1: return "Janeiro";

		case 2: return "Fevereiro";
		
		case 3: return "Março";
		
		case 4: return "Abril";
		
		case 5: return "Maio";
		
		case 6: return "Junho";
		
		case 7: return "Julho";
		
		case 8: return "Agosto";
		
		case 9: return "Setembro";
		
		case 10: return "Outubro";
		
		case 11: return "Novembro";
		
		case 12: return "Dezembro";
		
		default: return "Mês Inválido";
		}
	}
}
