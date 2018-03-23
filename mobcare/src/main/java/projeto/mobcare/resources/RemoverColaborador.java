package projeto.mobcare.resources;

import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import projeto.mobcare.dao.ColaboradorDao;
import projeto.mobcare.dao.Dao;

@Path("/remover")
public class RemoverColaborador 
{
	@GET
	@Path( "/{cpf}" )
	@Produces
	public Response removeColaborador( @PathParam( "cpf" ) String cpf  )
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
}