package projeto.mobcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorDePersistencia 
{
	private static EntityManagerFactory factory;
	
	public static EntityManager getEntityManager()
	{
		if( factory == null ) 
		{
			factory = Persistence.createEntityManagerFactory( "paulolirio_mobcare_pu" );
		}
		return factory.createEntityManager();
	}
	
	public static void fechar() 
	{
		factory.close();
	}
}