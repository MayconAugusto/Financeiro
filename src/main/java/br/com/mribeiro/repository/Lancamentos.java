package br.com.mribeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mribeiro.model.Lancamento;

public class Lancamentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Lancamentos(EntityManager manager) {
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
		
		//EntityTransaction trx = this.manager.getTransaction();
		//trx.begin();
		this.manager.persist(lancamento);
		//trx.commit();
	}
	
	public List<String> descricaoQueContem(String descricao) {
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("SELECT DISTINCT descricao FROM Lancamento")
			.append(" WHERE upper(descricao) LIKE upper(:descricao)");
		
		TypedQuery<String> query = manager.createQuery(jpql.toString(), String.class);
		query.setParameter("descricao", "%" + descricao + "%");
		
		return query.getResultList();
	}
	
	public Lancamento porId(Long id) {
		return manager.find(Lancamento.class, id);
	}

	public Lancamento guardar(Lancamento lancamento) {
		return manager.merge(lancamento);
	}

	public void remover(Lancamento lancamento) {
		this.manager.remove(lancamento);
	}
}
