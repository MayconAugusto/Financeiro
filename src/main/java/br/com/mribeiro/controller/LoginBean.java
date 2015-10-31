package br.com.mribeiro.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private Usuario usuario;
	
	private String nomeUsuario;
	private String senha;
	
	public String login() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if("admin".equals(this.nomeUsuario) && "123".equals(this.senha)) {
			this.usuario.setNome(this.nomeUsuario);
			this.usuario.setDataLogin(new Date());
			
			return "/PesquisaLancamento?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/Senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
		return null;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * @param nomeUsuario the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logout() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
	}
	
}
