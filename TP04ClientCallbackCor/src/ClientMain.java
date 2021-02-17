
import javax.ws.rs.core.MediaType;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
public class ClientMain {

	public static void main(String[] args) throws Exception { 
		String url = "http://localhost:8080/TP04ServiceCallbackCor/service/calcul";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		request.setHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN);
		request.setHeader(HttpHeaders.LOCATION,"http://localhost:8080/TP04ServiceCallbackCor/serviceCallback/resultat");
		HttpResponse response = client.execute(request);
		
		System.out.println("==> Appel au service");
		int statusReq1=response.getStatusLine().getStatusCode();
		System.out.println("status: "+statusReq1);

		System.out.println("----");

   }
}
