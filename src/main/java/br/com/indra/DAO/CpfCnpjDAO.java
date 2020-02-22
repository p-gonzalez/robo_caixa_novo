package br.com.indra.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.indra.connections.ConexaoOld;


public class CpfCnpjDAO {

	private Connection conexao;
	private PreparedStatement ps;
	private StringBuilder query;
	private ResultSet resultSet;
	//private static final String IP = "10.209.8.41";
	//private static final String BD = "BD_ATF";
	//private  static final String SCHEMA = "dbo";
	private static final Logger logger = LogManager.getLogger(CpfCnpjDAO.class.getName());

	public CpfCnpjDAO() {
		conexao = ConexaoOld.getConexao();
	}

	// EFETUA UMA CONSULTA NO BANCO 10.209.8.41, pois neste banco contém todas as informações integras
	public String buscarCpfCnpjlinkedServer(String callId) {
		String cpfCnpj = null;
		try {
			query = new StringBuilder();
			query.append("SELECT ");
			query.append("DISTINCT ");
			query.append("TOP(1) ");
			query.append("valor_dado ");
			query.append("FROM ");
			//query.append("["+IP+"].");
			//query.append("["+BD+"].");
			//query.append("["+SCHEMA+"].");
			query.append("[tb_dados_cadastrais] ");
			query.append("WHERE ");
			query.append("cod_fonte = 2");
			query.append("cod_dado = 2 " );
			query.append("AND ");
			query.append("callid = '"+callId+"'");
			ps = conexao.prepareStatement(query.toString());
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				cpfCnpj = resultSet.getString("valor_dado");
			}
		} catch (Exception e) {
			logger.error("Classe: CpfCnpjDAO, Método: buscarCpfCnpjlinkedServer, Error: "+e);
		}

		return cpfCnpj;
	}
}
