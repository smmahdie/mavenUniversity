package ir.maktab.dto;

import ir.maktab.entities.Teacher;

public class TeacherDTO extends DTO {
	private String degree;

	public TeacherDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherDTO(Teacher teacher) {
		super(teacher.getId(), teacher.getName());
		setDegree(teacher.getDegree());
	}
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
}
