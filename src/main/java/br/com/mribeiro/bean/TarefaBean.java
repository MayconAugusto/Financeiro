package br.com.mribeiro.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TarefaBean {

	private String nome;
	private int qtdeTarefasPendentes;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the qtdeTarefasPendentes
	 */
	public int getQtdeTarefasPendentes() {
		return qtdeTarefasPendentes;
	}
	
	/**
	 * @param qtdeTarefasPendentes the qtdeTarefasPendentes to set
	 */
	public void setQtdeTarefasPendentes(int qtdeTarefasPendentes) {
		this.qtdeTarefasPendentes = qtdeTarefasPendentes;
	}
	
}
