package ir.maktab.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ir.maktab.entities.Person;
import ir.maktab.entities.Student;
import ir.maktab.manager.StudentManager;

@Path("/uni")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Uni {

	@POST
	@Path("/add")
	public Student add(Student student) {
		
		return student;
	}

	@GET
	@Path("/items")
	public List<Student> get() {
		List<Student> ls = new ArrayList<>();
		for (Person p : new StudentManager().list()) {
			ls.add((Student)p);
		}
		return ls;
	}
	
	
	
	@GET
	@Path("/i")
	public String gets() {
		return "ooooooooo";
	}
}