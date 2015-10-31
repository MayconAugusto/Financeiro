/**
 * 
 */
package br.com.mribeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.com.mribeiro.model.Pessoa;
import br.com.mribeiro.repository.Pessoas;
import br.com.mribeiro.util.JpaUtil;

/**
 * @author MayconRibeiro
 * Classe que converte uma string com o codigo da pessoa em objeto do tipo Pessoa e vice-versa
 */
@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter02 implements Converter {

	/**
	 * Converte de String para Pessoa 
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Pessoa pessoa = null;
		EntityManager manager = JpaUtil.getEntityManager();
		
		try {
			if(value != null && !"".equals(value)) {
				Pessoas pessoas = new Pessoas(manager);
				pessoa = pessoas.getId(new Long(value));
			}
			
			return pessoa;
			
		} finally {
			manager.close();
		}
		
	}

	/**
	 * Converte de Pessoa para String
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if(value != null) {
			return ((Pessoa) value).getId().toString();
		}
		
		return null;
	}

}
