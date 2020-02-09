package br.com.indra.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.indra.DAO.CadastroDAO;
import br.com.indra.entity.Cadastros;

@ManagedBean(name="CadastrosBean")
@SessionScoped
public class CadastrosBean {
	
	private Cadastros cadastro = new Cadastros();
	private List<Cadastros> cadastros = new ArrayList<Cadastros>();
	private CadastroDAO cadastroDAO = new CadastroDAO();


	public void init(){
		cadastro = new Cadastros();
	}
	
	public void adicionar() {
		cadastroDAO.salvar(cadastro);
		cadastros.add(cadastro);
		cadastro = new Cadastros();

	}
	public void adicionar_call_id(){
		cadastroDAO.salvar_call_id(cadastro);
		cadastros.add(cadastro);
		cadastro = new Cadastros();
	}

	public void listar() {
		cadastros = cadastroDAO.buscar();
	}
	
	public Cadastros getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastros cadastro) {
		this.cadastro = cadastro;
	}

	public List<Cadastros> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastros> cadastros) {
		this.cadastros = cadastros;
	}

}
