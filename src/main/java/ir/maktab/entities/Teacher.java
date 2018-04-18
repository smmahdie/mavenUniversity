package ir.maktab.entities;

import ir.maktab.dto.TeacherDTO;

public class Teacher extends Person{
	
	private String degree;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(TeacherDTO teacherDTO) {
		super(teacherDTO.getId(), teacherDTO.getName());
		setDegree(teacherDTO.getDegree());
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
}
