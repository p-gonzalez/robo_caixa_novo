package br.com.indra.UtilFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

	
	public static final String PATTERN_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	public static final String PATTERN_DD_MM_YY_HH_MM_SS = "dd/MM/yy HH:mm:ss";
	public static final String PATTERN_YYYYMMDDHH_MMSS = "yyyyMMddHHmmss";
	public static final String PATTERN_HH = "HH";
	public static final String PATTERN_HHmmss = "HH:mm:ss";
	
	
	public static Date addMinutes(Date data, int min) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, min);
		return cal.getTime();
	}
	
	public static Date addDataOuHora(Date data, int quantidade, int campo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(campo, quantidade);
		return cal.getTime();
	}
	
	public static String convertToString(Date data, String formato) {
		SimpleDateFormat fmt  = new SimpleDateFormat(formato);
		return fmt.format(data);
	}
	
	public static Date convertToDate(String data, String formato) {
		SimpleDateFormat fmt  = new SimpleDateFormat(formato);
		try {
			return fmt.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
	public static String convertDataFormatoBrasil(String data) {
		String ano = data.substring(0,4);
	String mes = data.substring(5,7);
	String dia = data.substring(8,10);
	return dia+"/"+mes+"/"+	ano;
	}
}