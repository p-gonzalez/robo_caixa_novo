package br.com.indra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.indra.connections.ConexaoOld;
import br.com.indra.entity.CpfCnpj;

public class CpfCnpjDAO_old {
	
	CpfCnpj cpf = new CpfCnpj();
	
	public String buscarListaDeCpfCnpj(int id){
		try{
			Connection conexao = ConexaoOld.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT callid FROM tb_dados_cadastrais WHERE id = ? ");
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
