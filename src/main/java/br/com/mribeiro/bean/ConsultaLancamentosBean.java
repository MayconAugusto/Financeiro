package br.com.mribeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mribeiro.exceptions.NegocioException;
import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.repository.Lancamentos;
import br.com.mribeiro.service.CadastroLancamentos;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroLancamentos cadastro;
	
	@Inject
	private Lancamentos lancamentosRepository;
	
	private List<Lancamento> lancamentos;
	
	private Lancamento lancamentoSelecionado;
	
	public void consultar() {
		this.lancamentos = lancamentosRepository.getAll();
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void excluir() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			this.cadastro.excluir(this.lancamentoSelecionado);
			this.consultar();
			
			context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso!"));
			
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
	}

	/**
	 * @return the lancamentoSelecionado
	 */
	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	/**
	 * @param lancamentoSelecionado the lancamentoSelecionado to set
	 */
	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}