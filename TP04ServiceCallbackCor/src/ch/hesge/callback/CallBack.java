package ch.hesge.callback;

import java.io.IOException;


import javax.ws.rs.core.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class CallBack  extends Thread{
	private String url;
	
	
	public CallBack(String url) {
		super();
		this.url = url;
	}

	//Ne pas modifier cette méthode
	public void run() {

	System.out.println("==>callBackProcess()");

	System.out.println("==> simulation d'un long calcule......");
	int cpt=0;
	while (cpt<9000000) {
		cpt++;
		int cpt2=0;
		while (cpt2<900) {
			cpt2++;
			int cpt3=0;
			while (cpt3<4) {
				cpt3++;
			}
		}
	}
	envoieCallback(url);
	}
	
	//Méthode a  modifier
	public  void envoieCallback(String url) {
		System.out.println("==> envoieCallback(url)");

    	HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url); 
		request.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN); 
		try {
			request.setEntity(new StringEntity("reponse envoyee"));
			HttpResponse response=client.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	

}
