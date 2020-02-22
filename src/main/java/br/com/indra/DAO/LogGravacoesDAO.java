package br.com.indra.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.indra.entity.LogGravacoes;
import br.com.indra.teste.Robo;


public class LogGravacoesDAO {
	
	private Connection conexao;
	private static final Logger logger = LogManager.getLogger(Robo.class.getName());
	
	public LogGravacoesDAO (Connection c) {
		this.conexao = c;
	}

	public void salvar(LogGravacoes cadastro) {

		try {
			PreparedStatement ps = conexao.prepareCall(
					"INSERT INTO  tb_log_gravacoes(duracao_1,duracao_total,habilidades,call_id,inicio_contato,interlocutores,proprietario,servico,udf,id_chamado,dataHoraProcessamento,cpf_cnpj,num_chamador, id_operador,id_contratada, status, num_tel, nome_titular,nome_arquivo,dt_atendimento,tempo_atend,tempo_atendimento,existe_gravacao ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, cadastro.getDuracao1());
			ps.setString(2, cadastro.getDuracaoTotal());
			ps.setString(3, cadastro.getHabilidades());
			ps.setString(4, cadastro.getCallId());
			Calendar cal = Calendar.getInstance();
			cal.setTime(cadastro.getInicioContato());
			ps.setTimestamp(5, new Timestamp(cadastro.getInicioContato().getTime()), cal);
			ps.setString(6, cadastro.getInterlocutores());
			ps.setString(7, cadastro.getProprietario());
			ps.setString(8, cadastro.getServico());
			ps.setString(9, cadastro.getUdf());
			ps.setString(10, cadastro.getIdChamado());
			ps.setTimestamp(11, new Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));
			ps.setString(12, cadastro.getCfpCnpj());
			ps.setString(13, cadastro.getNumChamador());
			ps.setString(14, cadastro.getIdOperador());
			ps.setString(15, cadastro.getIdContratada());
			ps.setInt(16, cadastro.getStatus());
			ps.setString(17, cadastro.getNumTel());
			ps.setString(18, cadastro.getNomeTitular());
			ps.setString(19, cadastro.getNomeArquivo());
			ps.setString(20, cadastro.getDtAtendimento());
			ps.setString(21, cadastro.getTempoAtend());
			ps.setString(22, cadastro.getTempoAtend());
			ps.setInt(23, (cadastro.isExisteGravacao() == false) ? 0 : 1);
			ps.executeUpdate();
			logger.info("Classe: CadastroDAO, Método: salvar(), Mensagem: Código Inserido com sucesso !");
		} catch (Exception e) {
			logger.error("Classe: CadastroDAO, Método: salvar(), Error:  " + e);
		}
	}

	public List<LogGravacoes> buscar() {

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM tb_log_gravacoes");
			ResultSet resultSet = ps.executeQuery();
			List<LogGravacoes> cadastros = new ArrayList<LogGravacoes>();
			while (resultSet.next()) {
				LogGravacoes cadastro = new LogGravacoes();
				cadastro.setId(resultSet.getInt("id"));
				cadastro.setDuracao1(resultSet.getString("duracao_1"));
				cadastro.setDuracaoTotal(resultSet.getString("duracao_total"));
				cadastro.setHabilidades(resultSet.getString("habilidades"));
				cadastro.setIdChamado(resultSet.getString("id_chamado"));
				cadastro.setInicioContato(resultSet.getDate("inicio_contato"));
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

	public void atualizarNomeArquivo(String nomeArquivo, LogGravacoes cadastro) {
		try {
			PreparedStatement ps = conexao
					//.prepareStatement("UPDATE cadastros SET nome_arquivo = ?  WHERE id_chamado = ? ");
			.prepareStatement("UPDATE tb_log_gravacoes SET nome_arquivo = ?  WHERE id_chamado = ? ");
			ps.setString(1, nomeArquivo);
			ps.setString(2, cadastro.getIdChamado());
			boolean execute = ps.execute();
			if (!execute) {
				System.out.println("Erro ao executar update no nome do arquivo " + nomeArquivo);
			}

		} catch (Exception e) {

			System.out.println(e);

		}

	}
}