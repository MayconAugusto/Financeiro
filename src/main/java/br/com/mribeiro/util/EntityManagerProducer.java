package br.com.mribeiro.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Normalmente, usamos métodos produtores quando queremos injetar um objeto que
 *não é um bean CDI, quando o tipo concreto do objeto a ser injetado pode variar em
 *tempo de execução ou quando a instanciação do objeto requer algum procedimento
 *adicional.
 * @author MayconRibeiro
 *
 */
@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("FinanceiroPU");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}

