package projeto.mobcare.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas 
{

	public static void main( String[] args )
	{
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory( "paulolirio_mobcare_pu" );
		factory.close();
	}
}