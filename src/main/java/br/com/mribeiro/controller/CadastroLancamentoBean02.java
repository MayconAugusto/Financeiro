package br.com.mribeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.mribeiro.exceptions.NegocioException;
import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.model.Pessoa;
import br.com.mribeiro.model.TipoLancamento;
import br.com.mribeiro.repository.Pessoas;
import br.com.mribeiro.service.CadastroLancamentos;
import br.com.mribeiro.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean02 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> pessoas;
	
	
	/**
	 * Carrega uma lista com todas as pessoas cadastradas
	 */
	public void prepararCadastro() {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		try {
			Pessoas pessoas = new Pessoas(manager);
			this.pessoas = pessoas.getAll();
		} finally {
			manager.close();
		}
	}

	
	/**
	 * Metodo responsavel por salvar o lançamento
	 */
	public void salvar() {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			trx.begin();
			
			CadastroLancamentos cadastro = new CadastroLancamentos();
			cadastro.salvar(lancamento);
			
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
			
			trx.commit();
		} catch (NegocioException e) {
			trx.rollback();
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}
	
	
	/**
	 * Consulta todas as pessoas cadastradas
	 * @return
	 */
	public List<Pessoa> getAllPessoas()  {
		return this.pessoas;
	}

	
	/**
	 * Consulta todos os tipos de lançamentos
	 * @see TipoLancamento
	 * @return
	 */
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}


	/**
	 * @return the lancamento
	 */
	public Lancamento getLancamento() {
		return lancamento;
	}


	/**
	 * @param lancamento the lancamento to set
	 */
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
}
