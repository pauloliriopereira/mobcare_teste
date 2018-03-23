package projeto.mobcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.mobcare.tabelas.Colaborador;

public class ColaboradorDao implements Dao 
{
	@Override
	public Object buscar( String cpf ) 
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		Query query = manager.createNamedQuery( "Colaborador.buscaPorCpf" ) ;
		query.setParameter( "cpf", cpf );
		Colaborador colaborador = ( Colaborador ) query.getSingleResult();
		manager.close();
		return colaborador;
	}

	@Override
	public void inserir( Object objeto ) 
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		Colaborador colaborador = ( Colaborador ) objeto;
		
		manager.persist( colaborador.getSetor() );
		manager.persist( colaborador );
		manager.close();
	}

	@Override
	public void remover( String cpf ) 
	{
		Colaborador colaborador = ( Colaborador ) buscar( cpf );
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		manager.remove( colaborador );
		manager.close();
	}
}