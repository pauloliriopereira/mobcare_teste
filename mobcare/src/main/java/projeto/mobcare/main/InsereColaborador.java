package projeto.mobcare.main;

import javax.persistence.EntityManager;

import projeto.mobcare.dao.GerenciadorDePersistencia;
import projeto.mobcare.tabelas.Colaborador;
import projeto.mobcare.tabelas.Setor;

public class InsereColaborador 
{
	public static void main( String[] args ) 
	{
		EntityManager manager = GerenciadorDePersistencia.getEntityManager();
		manager.getTransaction().begin();
		Colaborador colaborador = new Colaborador();
		Setor setor = new Setor();
		setor.setId( 1L );
		setor.setDescricao( "Recursos Humanos" );
		colaborador.setCpf( "30727280899" );
		colaborador.setEmail( "a_vanessinha_1990@hotmail.com" );
		colaborador.setNome( "ALEXANDRA FERREIRA DA SILVA" );
		colaborador.setTelefone( "339200017" );
		
		colaborador.setSetor( setor );
		manager.persist( colaborador );
		manager.getTransaction().commit();
		manager.close();
		GerenciadorDePersistencia.fechar();
	}
}