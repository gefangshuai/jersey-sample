package jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class ClientDemo {
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/api/hello/dddd");

		String username = "root";
		String password = "secret";
		final HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(username, password);
		client.addFilter(authFilter);
		String s = webResource.get(String.class);
		System.out.println(s);
	}
}
