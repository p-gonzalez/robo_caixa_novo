package br.com.indra.entity;


import java.util.Date;

public class DadosCadastrais {

	private String callId;
	private Date dataHora;

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
}
