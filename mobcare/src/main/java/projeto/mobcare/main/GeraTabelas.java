package projeto.mobcare.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import projeto.mobcare.tabelas.Colaborador;
import projeto.mobcare.tabelas.Setor;

public class GeraTabelas 
{	
	public static void main( String[] args ) throws IOException 
	{
	    Set<Colaborador> colaboradores = geraListaDeColaboradores( "colaboradores.txt" );
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory( "paulolirio_mobcare_pu" );
	    
	    EntityManager manager = factory.createEntityManager();
	    manager.getTransaction().begin();
	    
	    for( Colaborador colaborador : colaboradores ) 
	    {
			manager.persist( colaborador );
		}
	    
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	private static List<Setor> geraListaDeSetores( String nomeDoArquivo ) throws FileNotFoundException
	{
		Scanner entrada = new Scanner( new FileInputStream( "setores.txt" ), "utf-8" );
		List<Setor> setores = new ArrayList<Setor>();
		Setor setor = new Setor();
		while( entrada.hasNext() ) 
		{
			setor.setDescricao( entrada.nextLine() );
			setores.add( setor );
		}
		entrada.close();
		return setores;
	}
	
	private static Set<Colaborador> geraListaDeColaboradores( String nomeDoArquivo ) throws FileNotFoundException
	{
		Scanner entrada = new Scanner( new FileInputStream( nomeDoArquivo ), "utf-8" ).useDelimiter( ";" );
		Set<Colaborador> colaboradores = new HashSet<Colaborador>();
		List<Setor> setores = geraListaDeSetores( "setores.txt" );
		int contador = 0;
		int index = 0;
		while( !entrada.hasNext() ) 
		{
			Colaborador colaborador = new Colaborador();
			colaborador.setCpf( entrada.next() );
			colaborador.setNome( entrada.next() );
			colaborador.setTelefone( entrada.next() );
			colaborador.setEmail( entrada.next() );
			colaborador.setSetor( setores.get( index ) );
			if( contador != 0 && contador % 5 == 0 ) 
			{
				index++;
			}
			contador++;
			colaboradores.add( colaborador );
		}
		entrada.close();
		
		return colaboradores;
	}
}