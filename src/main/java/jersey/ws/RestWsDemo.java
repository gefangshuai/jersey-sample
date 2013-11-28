package jersey.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.model.Student;

@Path("/students")
public class RestWsDemo {
	private List<Student> students;

	public RestWsDemo() {
		students = new ArrayList<Student>();

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("葛方帅");
		s1.setDept("一年级");

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("张三");
		s2.setDept("二年级");

		students.add(s1);
		students.add(s2);
	}

	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Student> getAllStudents() {
		return students;
	}
}
