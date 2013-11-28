package jersey;

import javax.ws.rs.core.MediaType;

import jersey.model.Student;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class ClientDemo {
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/ws/admin/save");

		String username = "root";
		String password = "secret";
		final HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(username, password);
		client.addFilter(authFilter);

		Student student = new Student();
		student.setId(1);
		student.setName("葛方帅");
		student.setDept("汉龙思琪");
		webResource.type(MediaType.APPLICATION_JSON).post(student);
		System.out.println();
	}
}
