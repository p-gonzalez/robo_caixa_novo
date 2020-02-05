package br.com.indra.teste;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import br.com.indra.DAO.CadastroDAO;

public class LigacaoPorMinuto {

	private static int antigo;
	private static int atual;
  
	

public static void main(String[] args) throws SQLException {
	  CadastroDAO cl1 = new CadastroDAO();
	  antigo = cl1.numeroLigacoes();
	  
	  System.out.println(antigo);
	  
     Timer timer = new Timer();
     final long SEGUNDOS = (1000 * 60);
     
     TimerTask tarefa = new TimerTask() {
		
		@Override
		public void run() {
			 CadastroDAO cl = new CadastroDAO();
			try {
				atual = cl.numeroLigacoes();
				
				System.out.println(atual - antigo);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
	};
	
	
	timer.scheduleAtFixedRate(tarefa, 0, SEGUNDOS);
     
   }




public static int getAtual() {
	return atual;
}


public static void setAtual(int atual) {
	LigacaoPorMinuto.atual = atual;
}


public static int getAntigo() {
	return antigo;
}

public static void setAntigo(int antigo) {
	LigacaoPorMinuto.antigo = antigo;
}
} 