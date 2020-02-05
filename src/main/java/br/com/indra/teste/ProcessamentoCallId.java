package br.com.indra.teste;

import java.awt.AWTException;
import java.text.ParseException;

import br.com.indra.DAO.CallIdDAO;
import br.com.indra.entity.CallId;

public class ProcessamentoCallId {
	// criar uma classe que tenha um metodo (processa)onde recebea o paramentro
	// de quatidade inicial e quantidade final
	// onde deva fazer um loop da quantidade inicial a quantidade final e
	// imprima todos os valores

	
	private CallIdDAO callIdDAO;
	private Robo robo;
	
	public void processa(int quantInicial, int quantFinal) throws AWTException, ParseException, InterruptedException {
		callIdDAO = new CallIdDAO();
		robo = new Robo();
				
		for (int i = quantInicial; i < quantFinal; i++) {
			System.out.println("ligações " + i);
			String callId = callIdDAO.buscarListaDeCallId(i);
			robo.processoNavegacao(callId);
			callIdDAO.atualizarStatus(i);
		}

	}

	public static void main(String[] args) {
		CallIdDAO c = new CallIdDAO();
		System.out.println(c.buscarListaDeCallId(2));
		
	}
}
