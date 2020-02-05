package br.com.indra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.indra.connections.Conexoes;
import br.com.indra.entity.CpfCnpj;

public class CpfCnpjDAO {
	
	CpfCnpj cpf = new CpfCnpj();
	
	public String buscarListaDeCpfCnpj(int id){
		try{
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT callid FROM tb_dados_cadastrais_20190801 WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			String cpfCnpj = null;
			
			while(resultSet.next()){
				cpfCnpj = resultSet.getString("callid");
			}
			
			return cpfCnpj;
		} catch (Exception e) {
		System.out.println(e);	
		}
		
		return null;
	}
}
