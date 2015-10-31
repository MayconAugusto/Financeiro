package br.com.mribeiro.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculadoraDataBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dataBase;
	private Integer dias;
	private Date resultado;
	
	public void adicionar() {
		
		Calendar dataCalculo = Calendar.getInstance();
		dataCalculo.setTime(this.dataBase);
		dataCalculo.add(Calendar.DAY_OF_MONTH, dias);
		
		this.resultado = dataCalculo.getTime();
	}

	/**
	 * @return the dataBase
	 */
	public Date getDataBase() {
		return dataBase;
	}

	/**
	 * @param dataBase the dataBase to set
	 */
	public void setDataBase(Date dataBase) {
		this.dataBase = dataBase;
	}

	/**
	 * @return the dias
	 */
	public Integer getDias() {
		return dias;
	}

	/**
	 * @param dias the dias to set
	 */
	public void setDias(Integer dias) {
		this.dias = dias;
	}

	/**
	 * @return the resultado
	 */
	public Date getResultado() {
		return resultado;
	}
	
	
}
