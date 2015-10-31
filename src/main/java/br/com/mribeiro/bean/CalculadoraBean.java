package br.com.mribeiro.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private Double valorA;
	private Double valorB;
	private Double resultado;
	
	public void somar() {
		this.resultado = this.valorA + this.valorB;
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
	 * @return the valorA
	 */
	public Double getValorA() {
		return valorA;
	}

	/**
	 * @param valorA the valorA to set
	 */
	public void setValorA(Double valorA) {
		this.valorA = valorA;
	}

	/**
	 * @return the valorB
	 */
	public Double getValorB() {
		return valorB;
	}

	/**
	 * @param valorB the valorB to set
	 */
	public void setValorB(Double valorB) {
		this.valorB = valorB;
	}

	/**
	 * @return the resultado
	 */
	public Double getResultado() {
		return resultado;
	}
	
}
