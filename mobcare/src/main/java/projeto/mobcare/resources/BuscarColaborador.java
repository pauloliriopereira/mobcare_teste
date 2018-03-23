package projeto.mobcare.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projeto.mobcare.dao.ColaboradorDao;
import projeto.mobcare.dao.Dao;
import projeto.mobcare.tabelas.Colaborador;

@Path("/buscar")
public class BuscarColaborador 
{
	@GET
	@Path( "/{cpf}/json" )
	@Produces( MediaType.APPLICATION_JSON )
	public Colaborador getColaborador( @PathParam( "cpf" ) String cpf  )
	{
		Dao dao = new ColaboradorDao();
		Colaborador colaborador = ( Colaborador ) dao.buscar( cpf );
		return colaborador;
	}
}