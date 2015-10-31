package br.com.mribeiro.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.mribeiro.exceptions.NegocioException;
import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.repository.Lancamentos;
import br.com.mribeiro.util.Transactional;

public class CadastroLancamentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Lancamentos lancamentos;
	
	/** Pelo inject nao precisamos do construtor
	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}**/
	
	
	/**
	 * Metodo responsavel por salvar um novo lançamento
	 * @param lancamento
	 * @throws NegocioException
	 */
	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		
		if(lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		
		//this.lancamentos.add(lancamento);
		this.lancamentos.guardar(lancamento);
	}
	
	
	/**
	 * Metodo responsavel por exluir um lançamento
	 * @param lancamento
	 * @throws NegocioException
	 */
	@Transactional
	public void excluir(Lancamento lancamento) throws NegocioException {
		
		lancamento = this.lancamentos.porId(lancamento.getId());
		
		if(lancamento.getDataPagamento() != null) {
			throw new NegocioException("Não é possivel excluir um lançamento pago!");
		}
		
		this.lancamentos.remover(lancamento);
	}
}
