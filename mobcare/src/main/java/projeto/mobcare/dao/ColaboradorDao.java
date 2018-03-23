package projeto.mobcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import projeto.mobcare.tabelas.Colaborador;

public class ColaboradorDao implements Dao
{
	public Object buscar( String cpf ) throws NoResultException
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		Query query = manager.createNamedQuery( "Colaborador.buscaPorCpf" ) ;
		query.setParameter( "cpf", cpf );
		Colaborador colaborador = null;
		
		try 
		{
			colaborador = ( Colaborador ) query.getSingleResult();
		} 
		catch ( NoResultException e ) 
		{
			throw new NoResultException( "Colaborador não entrado." );
		}
		return colaborador;
	}

	public void inserir( Object objeto )
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		Colaborador colaborador = ( Colaborador ) objeto;
		
		manager.persist( colaborador.getSetor() );
		manager.persist( colaborador );
		manager.getTransaction().commit();
	}

	public void remover( String cpf )
	{
		Colaborador colaborador = null; 
		
		try 
		{
			colaborador = ( Colaborador ) buscar( cpf );
		} 
		catch ( NoResultException e ) 
		{
			throw new NoResultException( "Colaborador não entrado." );
		}
		
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		manager.remove( colaborador );
		manager.getTransaction().commit();
	}
}