package br.com.mribeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.mribeiro.model.Lancamento;
import br.com.mribeiro.repository.Lancamentos;

@FacesConverter(forClass=Lancamento.class)
public class LancamentoConverter implements Converter {

	@Inject
	private Lancamentos lancamentos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Lancamento lancamento = null;
		
		if(value != null && !"".equals(value)) {
			lancamento = this.lancamentos.porId(new Long(value));
		}
		
		return lancamento;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if(value != null) {
			Lancamento lancamento = ((Lancamento) value);
			return lancamento.getId() == null ? null : lancamento.getId().toString();
		}
		
		return null;
	}

}
