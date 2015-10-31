package br.com.mribeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mribeiro.exceptions.NegocioException;
import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.model.Pessoa;
import br.com.mribeiro.model.TipoLancamento;
import br.com.mribeiro.repository.Lancamentos;
import br.com.mribeiro.repository.Pessoas;
import br.com.mribeiro.service.CadastroLancamentos;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroLancamentos cadastro;
	
	@Inject
	private Pessoas pessoas;
	
	@Inject
	private Lancamentos lancamentos;
	
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> pessoasAll;
	
	/**
	 * Carrega uma lista com todas as pessoas cadastradas
	 */
	public void prepararCadastro() {
	
		this.pessoasAll = this.pessoas.getAll();
		
		if(this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
	}

	
	/**
	 * Metodo responsavel por salvar o lançamento
	 */
	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			this.cadastro.salvar(this.lancamento);
			
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
			
		} catch (NegocioException e) {
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} 
	}
	
	
	/**
	 * Consulta todas as pessoas cadastradas
	 * @return
	 */
	public List<Pessoa> getAllPessoas()  {
		return this.pessoasAll;
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
	

	public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
		
		if(this.lancamento.getDataPagamento() == null) {
			this.lancamento.setDataPagamento(this.lancamento.getDataVencimento());
		}
	}
	
	public List<String> pesquisarDescricoes(String descricao) {
		return this.lancamentos.descricaoQueContem(descricao);
	}
}
