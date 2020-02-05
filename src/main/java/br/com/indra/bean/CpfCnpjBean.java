package br.com.indra.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.indra.DAO.CpfCnpjDAO;
import br.com.indra.entity.CpfCnpj;

public class CpfCnpjBean {
	
	private CpfCnpj cpfCnpj1 = new CpfCnpj();
	private List<CpfCnpj>cpfCnpj = new ArrayList<CpfCnpj>();
	private CpfCnpjDAO cpfCnpjDAO = new CpfCnpjDAO();
	
	public void ListarCpfCnpj(){
		
	}
	
	public CpfCnpj getCpfCnpj1() {
		return cpfCnpj1;
	}
	public void setCpfCnpj1(CpfCnpj cpfCnpj1) {
		this.cpfCnpj1 = cpfCnpj1;
	}
	public List<CpfCnpj> getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(List<CpfCnpj> cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public CpfCnpjDAO getCpfCnpjDAO() {
		return cpfCnpjDAO;
	}
	public void setCpfCnpjDAO(CpfCnpjDAO cpfCnpjDAO) {
		this.cpfCnpjDAO = cpfCnpjDAO;
	}
	
	
	
	
}
