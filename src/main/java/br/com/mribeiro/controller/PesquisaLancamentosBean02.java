package br.com.mribeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.repository.Lancamentos;
import br.com.mribeiro.util.JpaUtil;

@ManagedBean
@ViewScoped
public class PesquisaLancamentosBean02 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Lancamento> lancamentos;
	
	public void consultar() {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Lancamentos lancamentos = new Lancamentos(manager);
		this.lancamentos = lancamentos.getAll();
		
		/** Foi criado no repositorio
		TypedQuery<Lancamento> query = manager.createQuery("FROM Lancamento", Lancamento.class);
		this.lancamentos = query.getResultList(); **/
		
		manager.close();
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
