package br.com.indra.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexoes {
	private static Connection conexao;
	//private static final String URL_CONEXAO = "jdbc:mysql://10.209.8.21/admrobot?useTimezone=true&serverTimezone=UTC";
	//private static final String URL_CONEXAO = "jdbc:mysql://10.209.41.28/admrobot?useTimezone=true&serverTimezone=UTC";
	//private static final String URL_CONEXAO = "jdbc:mysql://localhost/admrobot?useTimezone=true&serverTimezone=UTC";
	private static final String URL_CONEXAO = "jdbc:mysql://10.209.49.61/db_robo_acr";
	//private static final String URL_CONEXAO = "jdbc:mysql://10.209.49.61/db_robo_acr?useTimezone=true&serverTimezone=UTC";
	
	// base servidor - produção
	//private static final String USUARIO = "root";
	//private static final String SENHA = "!ndr@DBbp0#2019";
	
	//apontamento para servidor 10.209.49.61
	private static final String USUARIO = "admrobo";
	private static final String SENHA = "!ndr@DBbp0#2019";
	
	//base local
	//private static final String USUARIO = "root";
	//private static final String SENHA = "!ndr@DBbp0#2019";

	public static Connection getConexao() {
		if (conexao == null) {
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return conexao;
	}
public static void fecharConexao(){
	if(conexao != null){
		try {
			conexao.close();
			conexao = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
}