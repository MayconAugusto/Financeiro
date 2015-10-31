package br.com.mribeiro.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MeuBean {

	private String nome;
	private int quantidadeCaracteres;
	
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
	
	public void transformar() {
		this.nome = this.nome.toUpperCase();
		this.quantidadeCaracteres = this.nome.length();
	}
	
	/**
	public void transformar(AjaxBehaviorEvent event) {
		this.nome = this.nome.toUpperCase();
		this.quantidadeCaracteres = this.nome.length();
	}**/

	/**
	 * @return the quantidadeCaracteres
	 */
	public int getQuantidadeCaracteres() {
		return quantidadeCaracteres;
	}
	
}
