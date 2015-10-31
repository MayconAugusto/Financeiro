package br.com.mribeiro.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private Date dataLogin;
	
	public boolean isLogado() {
		return nome != null;
	}

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
	 * @return the dataLogin
	 */
	public Date getDataLogin() {
		return dataLogin;
	}

	/**
	 * @param dataLogin the dataLogin to set
	 */
	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}
	
}
