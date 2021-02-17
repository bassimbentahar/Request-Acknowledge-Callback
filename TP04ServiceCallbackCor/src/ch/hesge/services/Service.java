package ch.hesge.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.apache.http.client.ClientProtocolException;

import ch.hesge.callback.CallBack;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


@Path("/service")
public class Service {

@GET 
@Path("/calcul")
@Produces(MediaType.TEXT_PLAIN)
public String methode1(@HeaderParam(HttpHeaders.LOCATION) String url, @Context HttpServletResponse response) throws ClientProtocolException, IOException   {
	response.setStatus(HttpServletResponse.SC_ACCEPTED); 
	try { 
		response.flushBuffer(); 
	}catch(Exception e){
		
	}
	System.out.println("......................");
	System.out.println("==> Retourne 202 (request accepted) ");
	System.out.println("==> lance un Thread l'url qui devra recevoir la réponse au 'Request Processor' (Callback) ");
	new CallBack(url).start();
	return " ";
	
}

}
