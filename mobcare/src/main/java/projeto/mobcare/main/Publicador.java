package projeto.mobcare.main;

import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class Publicador 
{
	public static void main( String[] args ) 
	{
		ResourceConfig rc = new ResourceConfig()
			.packages( new String[] { "projeto.mobcare.resources" } );
		HttpServer server = JdkHttpServerFactory.
							createHttpServer( URI.create( "http://localhost:8080/" ), rc );
	}
}