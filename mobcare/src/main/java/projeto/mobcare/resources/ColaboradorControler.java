package projeto.mobcare.resources;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import projeto.mobcare.dao.ColaboradorDao;
import projeto.mobcare.dao.Dao;
import projeto.mobcare.tabelas.Colaborador;

@Path( "/colaborador" )
public class ColaboradorControler 
{
	@GET
	@Path( "/buscar/{cpf}/json" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response buscarColaborador( @PathParam( "cpf" ) String cpf  )
	{
		Dao dao = new ColaboradorDao();
		Colaborador colaborador = null; 
		try 
		{
			colaborador = ( Colaborador ) dao.buscar( cpf );
		} 
		catch( NoResultException e )
		{
			return Response.status( Response.Status.NOT_FOUND )
					       .build();
		}
		
		return Response.ok( colaborador )
				       .build();
	}
	
	@POST
	@Path( "/inserir/json" )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response inserirColaborador( Colaborador colaborador ) 
	{
		Dao dao = new ColaboradorDao();
		try 
		{
			dao.inserir( colaborador );
		} 
		catch( RollbackException e )
		{
			return Response.status( Response.Status.BAD_REQUEST )
					       .build();
		}
		return Response.status( Response.Status.CREATED )
			       .build();
	}
	
	@DELETE
	@Path( "/remover/{cpf}" )
	@Produces
	public Response removerColaborador( @PathParam( "cpf" ) String cpf  )
	{
		Dao dao = new ColaboradorDao();
		try 
		{
			dao.remover(cpf);
		} 
		catch( NoResultException e )
		{
			return Response.status( Response.Status.BAD_REQUEST )
					       .build();
		}
		return  Response.ok()
				       .build();
	}
	
	@GET
	@Path( "/listarPorDepartamento/json" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response listarPorDepartamento()
	{
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		return Response.ok( colaboradorDao.listarPorDepartamento() )
			       .build();
	} 
}
