package br.com.mribeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mribeiro.model.Lancamento;

public class Lancamentos02 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Lancamentos02(EntityManager manager) {
		this.manager = manager;
	}
	
	/**
	 * Consulta todos os lançamentos
	 * @return
	 */
	public List<Lancamento> getAll() {
		
		TypedQuery<Lancamento> query = manager.createQuery("FROM Lancamento", Lancamento.class);
		
		return query.getResultList();
	}

	/**
	 * Adiciona lancamento
	 * @param lancamento
	 */
	public void add(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}
}
