package br.com.indra.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.indra.connections.Conexoes;
import br.com.indra.entity.Cadastros;


public class CadastroDAO {
	Cadastros cadastro = new Cadastros();

	public void salvar(Cadastros cadastro) {

		try {

			Connection conexao = Conexoes.getConexao();

			PreparedStatement ps = conexao.prepareCall(
					"INSERT INTO  cadastros(duracao_1,duracao_total,habilidades,call_id,inicio_contato,interlocutores,proprietario,servico,udf,id_chamado,DataHoraProcessamento,cpf_cnpj,num_chamador, id_operador,id_contratada, status, num_tel, nome_titular,nome_arquivo,dt_atendimento,tempo_atend,tempo_atendimento ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, cadastro.getDuracao1());
			ps.setString(2, cadastro.getDuracaoTotal());
			ps.setString(3, cadastro.getHabilidades());
			ps.setString(4, cadastro.getCallId());
			//ps.setDate(5,cadastro.getInicioContato());
			Calendar cal = Calendar.getInstance();
			cal.setTime(cadastro.getInicioContato());
			ps.setTimestamp(5, new Timestamp(cadastro.getInicioContato().getTime()), cal);
			//new java.sql.Timestamp(cadastro.getInicioContato().getTime()));
			//ps.setDate(5, new java.sql.Date(cadastro.getInicioContato().getTime());
			ps.setString(6, cadastro.getInterlocutores());
			ps.setString(7, cadastro.getProprietario());
			ps.setString(8, cadastro.getServico());
			ps.setString(9, cadastro.getUdf());
			ps.setString(10, cadastro.getIdChamado());
			//ps.setDate(11, new java.sql.Date(cadastro.getDataHoraProcessamento().getTime()));
			ps.setTimestamp(11, new Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
			ps.setString(12, cadastro.getCfpCnpj());
			ps.setString(13, cadastro.getNumChamador());
			ps.setString(14, cadastro.getIdOperador());
			ps.setString(15,  cadastro.getIdContratada());
			ps.setInt(16, cadastro.getStatus());
			ps.setString(17, cadastro.getNumTel());
			ps.setString(18, cadastro.getNomeTitular());
			ps.setString(19,  cadastro.getNomeArquivo());
			
			ps.setString(20, cadastro.getDtAtendimento());
			ps.setString(21, cadastro.getTempoAtend());
			
			ps.setString(22, cadastro.getTempoAtend());
//			Calendar ta = Calendar.getInstance();
//			ta.setTime(cadastro.getTempoAtendimento());
//			ps.setTimestamp(22, new Timestamp(cadastro.getTempoAtendimento().getTime()),ta );
//			
			ps.executeUpdate();
			System.out.println("Enserido com sucesso");
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public void salvar_call_id(Cadastros cadastro) {

		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement call = conexao.prepareCall("INSERT INTO cadastros(call_id)values('6')");
			call.setString(1, cadastro.getCallId());
			call.executeUpdate();
			System.out.println("Enserido com sucesso");

		} catch (Exception e) {
			System.out.println("Não foi possivel incluir call_id");
			System.out.println(e);
		}

	}

	public List<Cadastros> buscar() {

		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cadastros");
			ResultSet resultSet = ps.executeQuery();
			List<Cadastros> cadastros = new ArrayList<Cadastros>();
			while (resultSet.next()) {
				Cadastros cadastro = new Cadastros();
				cadastro.setId(resultSet.getInt("id"));
				cadastro.setDuracao1(resultSet.getString("duracao_1"));
				cadastro.setDuracaoTotal(resultSet.getString("duracao_total"));
				cadastro.setHabilidades(resultSet.getString("habilidades"));
				cadastro.setIdChamado(resultSet.getString("id_chamado"));
				cadastro.setInicioContato(resultSet.getDate("inicio_contato"));
				//cadastro.setInicio_contato(resultSet.getString("inicio_contato"));
				cadastro.setInterlocutores(resultSet.getString("interlocutores"));
				cadastro.setProprietario(resultSet.getString("proprietario"));
				cadastro.setServico(resultSet.getString("servico"));
				cadastro.setUdf(resultSet.getString("udf"));
				cadastro.setCallId(resultSet.getString("call_id"));
				cadastro.setIdChamado(resultSet.getString("id_chamado"));
				cadastro.setDataHoraProcessamento(resultSet.getTimestamp("dataHoraProcessamento"));
				cadastros.add(cadastro);
			}
			return cadastros;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	
	public Date buscarUltimoProcessamento() {

		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT MAX(cad.dataHoraProcessamento) FROM cadastros cad");
			ResultSet resultSet = ps.executeQuery();
			List<Cadastros> cadastros = new ArrayList<Cadastros>();
			while (resultSet.next()) {
				
				java.sql.Date date = resultSet.getDate(1);
				if(date != null) {
					return new Date(date.getTime());
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	
	public List<Cadastros> renomearArq(){

		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT call_id  FROM cadastros");
			ResultSet resultSet = ps.executeQuery();
			List<Cadastros> cadastros = new ArrayList<Cadastros>();
			while (resultSet.next()) {
				cadastro.setIdChamado(resultSet.getString("id_chamado"));	
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public void atualizarNomeArquivo(String nomeArquivo, Cadastros cadastro){
		try {
			Connection conexao = Conexoes.getConexao();
			PreparedStatement ps = conexao.prepareStatement("UPDATE cadastros SET nome_arquivo = ?  WHERE id_chamado = ? ");
			ps.setString(1, nomeArquivo);
			ps.setString(2, cadastro.getIdChamado());
			boolean execute = ps.execute();
			if(!execute){
				System.out.println("Erro ao executar update no nome do arquivo " + nomeArquivo);
			}
			

		} catch (Exception e) {

			System.out.println(e);

		}

	}
	
	public List<Cadastros>call_id() throws SQLException{
		Cadastros call = null;
		Connection conexao = Conexoes.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cadastros WHERE call_id=? ");
		ResultSet resultSet = ps.executeQuery();
		
		List<Cadastros> cadastros = new ArrayList<Cadastros>();
			
		if(resultSet.next()){
			
			cadastro.setCallId(resultSet.getString("call_id"));
			
		}
		return cadastros;
	
	}
	
public int numeroLigacoes() throws SQLException{
		
		Connection conexao = Conexoes.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT COUNT(call_id) AS valor FROM cadastros");
		ResultSet resultSet = ps.executeQuery();
		int tot = 0;
		while(resultSet.next()) {
			tot = resultSet.getInt("valor");
		}
		
		return tot;
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(java.util.Calendar.getInstance().getTimeInMillis());
		System.out.println(java.util.Calendar.getInstance());
		System.out.println(new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
	}
}