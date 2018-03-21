package projeto.mobcare.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import projeto.mobcare.tabelas.Setor;

public class GeraTabelas 
{
	private static EntityManagerFactory factory;
	
	public static void main( String[] args )
	{
		geraTabelas();
		try {
			carregaTabelas();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void geraTabelas()
	{
		factory = Persistence.createEntityManagerFactory( "bd_quadroDeHorarios" );
	}
	
	private static void carregaTabelas() throws FileNotFoundException
	{
		Scanner entrada = new Scanner( new FileInputStream( "setores" ) ).useDelimiter( ";" );
	    EntityManager manager = factory.createEntityManager();
	    manager.getTransaction().begin();
	    Setor setor;
	    
		while( entrada.hasNext() )
		{
			setor = new Setor();
			setor.setDescricao( entrada.nextLine() );
			manager.persist( setor );
		}
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		entrada.close();
	}
}