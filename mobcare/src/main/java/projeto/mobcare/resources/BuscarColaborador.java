package projeto.mobcare.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projeto.mobcare.tabelas.Colaborador;

@Path("/buscar")
public class BuscarColaborador 
{
	@GET
	@Path( "/id" )
	@Produces( MediaType.APPLICATION_JSON )
	public Colaborador getColaborador( @PathParam( "id" ) long id  )
	{
		return new Colaborador();
	}
}