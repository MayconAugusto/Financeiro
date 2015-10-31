package br.com.mribeiro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
//@RequestScoped
@ViewScoped
public class NomesBean {

	private String nome;
	private List<String> nomes = new ArrayList<String>();
	
	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdicionar;
	
	public void adicionar() {
		this.nomes.add(nome);
		
		/**
		 *  desativa campo e botao quando estiver mais de 3 nomes
		 */

		if(this.nomes.size() > 3) {
			this.inputNome.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Muitos nomes adicionados");
		}
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
	 * @return the nomes
	 */
	public List<String> getNomes() {
		return nomes;
	}

	/**
	 * @return the inputNome
	 */
	public HtmlInputText getInputNome() {
		return inputNome;
	}

	/**
	 * @param inputNome the inputNome to set
	 */
	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}

	/**
	 * @return the botaoAdicionar
	 */
	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	/**
	 * @param botaoAdicionar the botaoAdicionar to set
	 */
	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}
	
}
