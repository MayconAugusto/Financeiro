package br.com.mribeiro.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Um interceptador é uma classe usada para intervir em chamadas de métodos de
 * classes. Podemos usar interceptadores para várias coisas, como registrar logs ou
 * executar tarefas repetitivas e que não fazem parte da regra de negócio do sistema.
 * @author MayconRibeiro
 *
 */
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;
		
		try {
			if(!trx.isActive()) {
				/**
				 * Truque para fazer rollback no que já passou (senão, um futuro commit, confirmaria até mesmo operacões sem transação)
				 */
				trx.begin();
				trx.rollback();
				
				//agora sim inicia a transação
				trx.begin();
				criador = true;
			}
			
			return context.proceed();
		} catch (Exception e) {
			if(trx != null && criador) {
				trx.rollback();
			}
			
			throw e;
		} finally {
			if(trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
	}
	
	
}
