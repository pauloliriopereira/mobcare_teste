package projeto.mobcare.main;

import javax.persistence.EntityManager;

import projeto.mobcare.dao.GerenciadorDePersistencia;
import projeto.mobcare.tabelas.Colaborador;

public class RemoveColaborador
{
	public static void main( String[] args ) 
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		Colaborador colaborador = manager.find( Colaborador.class, 14L );
		manager.remove( colaborador );
		manager.getTransaction().commit();
		manager.close();
		GerenciadorDePersistencia.fechar();
	}

}
