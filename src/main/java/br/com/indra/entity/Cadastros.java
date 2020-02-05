package br.com.indra.entity;

import java.sql.Time;
import java.util.Date;

public class Cadastros {
	
	private Integer id;
	private String duracao1;
	private String duracaoTotal;
	private String habilidades;
	private String idChamado;
		
	private Date inicioContato;
	private Date recarregarData;
	
	private String interlocutores;
	private String proprietario;
	private String servico;
	private String udf;
	
	private String cfpCnpj;
	private String numChamador;
	private String idOperador;
	private String idContratada = "INDRA-FO-2015";
	private int status;
	private String numTel;
	private String nomeTitular;
	
	
	private Integer idCall;
	private String callId;
	private Date dataHoraProcessamento;
	private   String nomeArquivo;
	private String tempoAtend;
	private String dtAtendimento;
	private String tempoAtendimento;
	
		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDuracao1() {
		return duracao1;
	}
	public void setDuracao1(String duracao1) {
		this.duracao1 = duracao1;
	}
	
	public String getDuracaoTotal() {
		return duracaoTotal;
	}
	public void setDuracaoTotal(String duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}
	public String getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}
	public String getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(String idChamado) {
		this.idChamado = idChamado;
	}
	
	public Date getInicioContato() {
		return inicioContato;
	}
	public void setInicioContato(Date inicioContato) {
		this.inicioContato = inicioContato;
	}
	public Date getRecarregarData() {
		return recarregarData;
	}
	public void setRecarregarData(Date recarregarData) {
		this.recarregarData = recarregarData;
	}
	public String getInterlocutores() {
		return interlocutores;
	}
	public void setInterlocutores(String interlocutores) {
		this.interlocutores = interlocutores;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getUdf() {
		return udf;
	}
	public void setUdf(String udf) {
		this.udf = udf;
	}
	public String getCfpCnpj() {
		return cfpCnpj;
	}
	public void setCfpCnpj(String cfpCnpj) {
		this.cfpCnpj = cfpCnpj;
	}
	public String getNumChamador() {
		return numChamador;
	}
	public void setNumChamador(String numChamador) {
		this.numChamador = numChamador;
	}
	public String getIdOperador() {
		return idOperador;
	}
	public void setIdOperador(String idOperador) {
		this.idOperador = idOperador;
	}
	public String getIdContratada() {
		return idContratada;
	}
	public void setIdContratada(String idContratada) {
		this.idContratada = idContratada;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public Integer getIdCall() {
		return idCall;
	}
	public void setIdCall(Integer idCall) {
		this.idCall = idCall;
	}
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public Date getDataHoraProcessamento() {
		return dataHoraProcessamento;
	}
	public void setDataHoraProcessamento(Date dataHoraProcessamento) {
		this.dataHoraProcessamento = dataHoraProcessamento;
	}
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getTempoAtend() {
		return tempoAtend;
	}
	public void setTempoAtend(String tempoAtend) {
		this.tempoAtend = tempoAtend;
	}
	public String getDtAtendimento() {
		return dtAtendimento;
	}
	public void setDtAtendimento(String dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}
	public String getTempoAtendimento() {
		return tempoAtendimento;
	}
	public void setTempoAtendimento(String tempoAtendimento) {
		this.tempoAtendimento = tempoAtendimento;
	}
	
	
	
}
