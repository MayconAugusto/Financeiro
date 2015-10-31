package br.com.mribeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.repository.Lancamentos;

@Named
@ViewScoped
public class PesquisaLancamentosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Lancamentos lancamentosRepository;
	
	private List<Lancamento> lancamentos;
	
	public void consultar() {
		this.lancamentos = lancamentosRepository.getAll();
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
