package br.com.indra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.indra.entity.DadosCadastrais;


public class DadosCadastraisDAO {
	public static final Logger logger = LogManager.getLogger(DadosCadastraisDAO.class.getName());
	private Connection conexao;
	private ResultSet resultSet;
	
	public DadosCadastraisDAO(Connection c) {
		this.conexao = c;
	}

	public synchronized List<DadosCadastrais> buscarListaDeCallId(String callIdIn) {
		List<DadosCadastrais> callId = null;
		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM tb_dados_cadastrais WHERE callid IN ("+callIdIn+") and cod_dado = 2 and cod_fonte = 2");
			resultSet = ps.executeQuery();
			callId = new ArrayList<DadosCadastrais>();
			
			while (resultSet.next()) {
				DadosCadastrais call = new DadosCadastrais();
				call.setCallId(resultSet.getString("callid"));
				call.setDataHora(resultSet.getDate("data_hora"));
				callId.add(call);
			}
		} catch (Exception e) {
			logger.error("Classe: CallIdDAO	, Método: buscarListaDeCallId, Error: " + e);
		}
		return callId;

	}

	public synchronized void atualizarThreadProcessando(String id) {
		try {
			PreparedStatement ps = conexao
					.prepareStatement("UPDATE tb_dados_cadastrais SET thread_processando = 'S' WHERE callid = ? ");
			ps.setString(1, id);
			ps.execute();
			logger.info(
					"Classe: CallIdDAO, Método: atualizarThreadProcessando,  Mensagem: Atualização realizada com sucesso ! Id: "
							+ id);
		} catch (Exception e) {
			logger.error("Classe: CallIdDAO, Método: atualizarThreadProcessando, Erro: " + e);
		}
	}

}
