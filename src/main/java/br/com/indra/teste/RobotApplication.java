package br.com.indra.teste;

import java.awt.AWTException;
import java.text.ParseException;

public class RobotApplication {

	public static void main(String[] args) throws AWTException, ParseException, InterruptedException {
		System.setProperty("webdriver.ie.driver", "C:\\bot_acr_cef\\browsers\\IEDriverServer.exe");
		ProcessamentoCallId p = new ProcessamentoCallId();
		//p.processa(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		p.processa(10, 1099);
		
	}
			
	
}	
		