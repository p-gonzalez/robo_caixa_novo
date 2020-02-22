package br.com.indra.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_log_gravacoes")
public class LogGravacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=50)
	private String duracao1;
	
	@Column(length=50)
	private String duracaoTotal;
	
	@Column(length=150)
	private String habilidades;
	
	@Column(length=50)
	private String idChamado;
	
	@Column(length=50)	
	private Date inicioContato;
	
	@Column(length=50)
	private Date recarregarData;
	
	@Column(length=1500)
	private String interlocutores;
	
	@Column(length=150)
	private String proprietario;
	
	@Column(length=500)
	private String servico;
	
	@Column(length=1550)
	private String udf;
	
	@Column(length=16)
	private String cfpCnpj;
	
	@Column(length=50)
	private String numChamador;
	
	@Column(length=50)
	private String idOperador;
	
	@Column(length=50)
	private String idContratada = "INDRA-FO-2015";
	
	@Column(length=3)
	private int status;
	
	@Column(length=11)
	private String numTel;
	
	@Column(length=50)
	private String nomeTitular;
	
	@Column(length=50)	
	private Integer idCall;
	
	@Column(length=50)
	private String callId;
	
	@Column(length=50)
	private Date dataHoraProcessamento;
	
	@Column(length=50)
	private   String nomeArquivo;
	
	@Column(length=50)
	private String tempoAtend;
	
	@Column(length=50)
	private String dtAtendimento;
	
	@Column(length=50)
	private String tempoAtendimento;
	
	
	private boolean isExisteGravacao;
	
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
	public boolean isExisteGravacao() {
		return isExisteGravacao;
	}
	public void setExisteGravacao(boolean isExisteGravacao) {
		this.isExisteGravacao = isExisteGravacao;
	}
	
}
