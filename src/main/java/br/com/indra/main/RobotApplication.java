package br.com.indra.main;

import java.awt.AWTException;
import java.text.ParseException;

import br.com.indra.teste.ProcessamentoCallId;

public class RobotApplication {

	public static void main(String[] args) throws AWTException, ParseException, InterruptedException {
		System.setProperty("webdriver.ie.driver", "C:\\bot_acr_cef\\browsers\\IEDriverServer.exe");
		ProcessamentoCallId p = new ProcessamentoCallId();
		//p.processa(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		p.processa(100, 500);
		
	}	
			
	
}	
		