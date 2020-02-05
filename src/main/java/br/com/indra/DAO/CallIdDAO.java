package br.com.indra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.indra.connections.Conexoes;
import br.com.indra.entity.CallId;

public class CallIdDAO {
	CallId cid = new CallId();

	public String buscarListaDeCallCpfCnpj(int id) {
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao
					.prepareStatement("SELECT callid FROM tb_dados_cadastrais_20190801 WHERE id=? ");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();

			String call = null;

			while (resultSet.next()) {

				call = resultSet.getString("callid");

			}

			return call;

		} catch (Exception e) {

			System.out.println(e);

		}
		return null;

	}

	public String buscarListaDeCallId(int id) {
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT call_id FROM tb_call_id WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();

			String callId = null;

			while (resultSet.next()) {

				callId = resultSet.getString("call_Id");

			}

			return callId;

		} catch (Exception e) {

			System.out.println(e);

		}
		return null;

	}

	public void atualizarStatus(int id, int status) {
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("UPDATE tb_call_id SET status=? WHERE id = ? ");
			ps.setInt(1, id);
			ps.setInt(2, status);
			boolean execute = ps.execute();
			if (!execute) {
				System.out.println("Erro ao executar update id " + id);
			}

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	public void atualizarStatus(int id) {
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("UPDATE tb_call_id SET status=1 WHERE id = ? ");
			ps.setInt(1, id);

			boolean execute = ps.execute();
			if (!execute) {
				System.out.println("Erro ao executar update id " + id);
			}

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	/*
	 * public String buscarCallidPeriodo(String dInicio, String dFim){ try{
	 * Connection conexao = Conexoes.getConexao(); PreparedStatement ps =
	 * conexao.
	 * prepareStatement("SELECT * FROM tb_call_id WHERE data_hora BETWEEN ? AND ? "
	 * ); ps.setString(1, dInicio); ResultSet resultSet = ps.executeQuery();
	 * String callId = null;
	 * 
	 * while(resultSet.next()){ callId = resultSet.getString("call_id"); }
	 * return callId;
	 * 
	 * }catch(Exception e ){
	 * 
	 * System.out.println(e); } return dFim;
	 * 
	 * 
	 * }
	 */
	/*
	 * public void buscarListaDeCallId() { try {
	 * 
	 * List<String>callId = new ArrayList<>(); int coluna = 1; String ps =
	 * "SELECT call_id FROM tb_call_id WHERE id = ? "; try{ ps =
	 * conexao.prepareStatement (ps); ResultSet resultSet = ps.executeQuery();
	 * 
	 * while (resultSet.next()) {
	 * 
	 * //callId = resultSet.getString("call_Id");
	 * 
	 * callId.add(ps.)
	 * 
	 * }
	 * 
	 * return callId;
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println(e);
	 * 
	 * } return null;
	 * 
	 * }
	 */

	public String buscarListaDeCallIdCadastro(int id) {
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT id_chamado FROM cadastros WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();

			String callIdCadastro = null;

			while (resultSet.next()) {

				callIdCadastro = resultSet.getString("id_chamado");

			}

			return callIdCadastro;

		} catch (Exception e) {

			System.out.println(e);

		}
		return null;

	}

	public String buscarCpfCnpjCadastros(int id) {
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT cpf_cnpj FROM cadastros WHERE id = ?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			String cpfCnpj = null;
			while (resultSet.next()) {

				cpfCnpj = resultSet.getString("cpf_cnpj");

			}

			return cpfCnpj;

		} catch (Exception e) {

		}

		return null;

	}

	public static void main(String[] args) {
		CallIdDAO c = new CallIdDAO();

		int id = 3;
		int coluna = 2;

		// c.buscarListaDeCallIdCadastro(2);
		// c.buscarListaDeCallId(2);
		// c.buscarCpfCnpjCadastros(1);
		// c.atualizarStatus(coluna,id);

		/*
		 * if(c.buscarListaDeCallIdCadastro(20) ==
		 * c.buscarListaDeCallCpfCnpj(20)){
		 * System.out.println("Call ids são iguais "); }else{
		 * System.out.println("Call ids são diferentes "); }
		 * System.out.println(c.buscarListaDeCallIdCadastro(2) + " == " +
		 * c.buscarListaDeCallId(2));
		 */

		// System.out.println(c.buscarCallidPeriodo("2019-08-01 10:00:00",
		// "2019-08-01 11:00:00"));

		// System.out.println(c.buscarCpfCnpjCadastros(2));(int botX = 0; botX <
		// 6; botX++)

		String aa = c.buscarListaDeCallCpfCnpj(20);
		String bb = c.buscarListaDeCallIdCadastro(20);
		for (int ca = 0; ca < 8; ca++) {

			 System.out.println(c.buscarListaDeCallCpfCnpj(ca++));

		}

		System.out.println(bb);
		System.out.println(aa);

	}
}
