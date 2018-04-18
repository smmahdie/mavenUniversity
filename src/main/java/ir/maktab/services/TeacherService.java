package ir.maktab.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ir.maktab.dto.TeacherDTO;
import ir.maktab.entities.Person;
import ir.maktab.entities.Teacher;
import ir.maktab.manager.TeacherManager;

@Path("/teacher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherService {

	@POST
	@Path("/add")
	public boolean add(TeacherDTO teacherDTO) {
		return new TeacherManager().save(new Teacher(teacherDTO));
	}

	@POST
	@Path("/edit")
	public boolean update(@QueryParam(value = "id") int id, TeacherDTO teacherDTO) {
		return new TeacherManager().update(new Teacher(teacherDTO));
	}

	@GET
	@Path("/delete")
	public boolean delete(@QueryParam(value = "id") int id) {
		return new TeacherManager().delete(id);
	}

	@GET
	@Path("/items")
	public List<TeacherDTO> listAll() {
		List<TeacherDTO> ls = new ArrayList<>();
		for (Person p : new TeacherManager().list()) {
			ls.add(new TeacherDTO((Teacher) p));
		}
		return ls;
	}

	@GET
	@Path("/item")
	public TeacherDTO getById(@QueryParam(value = "id") int id) {
		return new TeacherDTO(new TeacherManager().load(id));
	}
}
