package projeto.mobcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import projeto.mobcare.dao.modelo.ListarPorDepartamento;
import projeto.mobcare.tabelas.Colaborador;

public class ColaboradorDao implements Dao
{
	@Override
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
	
	@Override
	public void inserir( Object objeto ) throws RollbackException
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		manager.persist( manager.merge( objeto ) );
		try 
		{
			manager.getTransaction().commit();
		} 
		catch( RollbackException e ) 
		{
			throw new RollbackException( "Colaborador já cadastrado." );
		}
		finally
		{
			manager.close();
		}
	}
	
	@Override
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
		manager.remove( manager.merge( colaborador ) );
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<ListarPorDepartamento> listarPorDepartamento()
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		String consulta = "select new projeto.mobcare.dao.modelo.ListarPorDepartamento(c.nome, c.email, c.setor.descricao) from Colaborador c"
				          + " inner join Setor s on c.setor.id = s.id order by s.id desc";
		Query query = manager.createQuery( consulta ) ;
		List<ListarPorDepartamento> lista = query.getResultList();
		manager.close();
		
		return lista;
	}
}