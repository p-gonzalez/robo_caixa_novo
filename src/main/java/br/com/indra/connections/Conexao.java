package br.com.indra.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Conexao {

	private static Connection conexao;
	public static final Logger logger = LogManager.getLogger(Conexao.class.getName());
	private static final String URL_CONEXAO = "jdbc:sqlserver://BPOPRDSPODBS01;instanceName=PRODUCAO;databaseName=BD_ATF";
	

	private static final String USUARIO = "svc1_sql";
	private static final String SENHA = "I@1!qdBle5ing";

	public static Connection getConexao() {
		if (conexao == null) {
			
				try {
					logger.info("Classe: ConexaoSqlServer, Método: getConexaoSqlServer, Mensagem: Abrindo conexão com o Banco de dados....");
					conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
					logger.info("Classe: ConexaoSqlServer, Método: getConexaoSqlServer, Mensagem: Banco de dados Conectado !");
				} catch (Exception e) {
					logger.error("Classe: ConexaoSqlServer, Método: getConexaoSqlServer, Error: "+e);
				}

		}
		return conexao;
	}
	
public static void fecharConexao(){
	if(conexao != null){
		try {
			logger.info("Classe: ConexaoSqlServer, Método: fecharConexao, Mensagem: Encerrando conexão com o Banco....");
			conexao.close();
			conexao = null;
			logger.info("Classe: ConexaoSqlServer, Método: fecharConexao, Mensagem: Conexão fechada ! ");
		} catch (SQLException e) {
			logger.error("Classe: ConexaoSqlServer, Método: fecharConexao, Error: "+e);
		}
		
	}
}
}
