package br.com.indra.teste;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DecimalFormat;

import br.com.indra.bin.UtilDate;
import br.com.indra.entity.Cadastros;

public class Teste {

	public static void main(String[] args) {
		/*
		 * Cadastros cadastros = new Cadastros(); Robo r = new Robo();
		 * 
		 * String narq = r.getNomePadraoArquivo(cadastros);
		 * cadastros.setNomeArquivo(narq);
		 * 
		 * System.out.println(narq);
		 */

		// float st = (float) 2.49;
		//
		// float result = st/60;
		//
		//
		// System.out.println(result);
		//

		String minutos = "01:09:46";
		System.out.println(convertMinutoEmSegundos(minutos));
		minutos = "09:46";
		System.out.println(convertMinutoEmSegundos(minutos));
		minutos = "02:46";
		System.out.println(convertMinutoEmSegundos(minutos));
	}
	
	public static String convertMinutoEmSegundos(String minutos) {
		String[] times = minutos.split(":");
		Integer hora = 0;
		Integer minuto = 0;
		Integer segundos = 0;
		Integer totalHoras = 0;
		if(times.length > 2) {
			hora = Integer.valueOf(times[0]);
			minuto = Integer.valueOf(times[1]);
			segundos = Integer.valueOf(times[2]);
			totalHoras = (hora * 3600);
		}else {
			minuto = Integer.valueOf(times[0]);
			segundos = Integer.valueOf(times[1]);
		}
		totalHoras = totalHoras + (minuto * 3600) / 60;
		totalHoras = totalHoras + segundos;
		
		return totalHoras.toString();
	}

}
