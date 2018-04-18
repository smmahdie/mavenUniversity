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

import ir.maktab.dto.StudentDTO;
import ir.maktab.entities.Person;
import ir.maktab.entities.Student;
import ir.maktab.entities.Teacher;
import ir.maktab.manager.StudentManager;
import ir.maktab.manager.TeacherManager;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentService {

	@POST
	@Path("/add")
	public boolean add(StudentDTO studentDTO) {
		return new StudentManager().save(new Student(studentDTO));
	}

	@POST
	@Path("/setTeacher")
	public boolean setTeacher(@QueryParam(value = "id") int studentId, String teachername) {
		Student student = new StudentManager().load(studentId);
		for (Teacher t : new TeacherManager().list()) {
			if (t.getName().equals(teachername)) {
				student.setProfid(t.getId());
				break;
			}
		}
		return new StudentManager().update(student);
	}

	@POST
	@Path("/edit")
	public boolean update(@QueryParam(value = "id") int id, StudentDTO studentDTO) {
		studentDTO.setId(id);
		return new StudentManager().update(new Student(studentDTO));
	}

	@GET
	@Path("/delete")
	public boolean delete(@QueryParam(value = "id") int id) {
		return new StudentManager().delete(id);
	}

	@GET
	@Path("/items")
	public List<StudentDTO> listAll() {
		List<StudentDTO> ls = new ArrayList<>();
		for (Person p : new StudentManager().list()) {
			ls.add(new StudentDTO((Student) p));
		}
		return ls;
	}

	@GET
	@Path("/item")
	public StudentDTO getById(@QueryParam(value = "id") int id) {
		Student student = new StudentManager().load(id);
		StudentDTO studentDTO = new StudentDTO(student);
		return studentDTO;
	}

	@GET
	@Path("/teachers")
	public List<String> listOfStudentTeacher() {
		List<String> ls = new ArrayList<>();
		for (Person p : new StudentManager().list()) {
			ls.add((new TeacherManager().load(((Student) p).getProfid())).getName());
		}
		return ls;
	}

	@GET
	@Path("/teacher")
	@Produces(MediaType.TEXT_PLAIN)
	public String teacherof(@QueryParam(value = "id") int id) {
		Student student = new StudentManager().load(id);
		return new TeacherManager().load(student.getProfid()).getName();
	}
}