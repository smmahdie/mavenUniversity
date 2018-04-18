package ir.maktab.dto;

import ir.maktab.entities.Student;

public class StudentDTO extends DTO {

	private String dprt;

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(Student student) {
		super(student.getId(), student.getName());
		setDprt(student.getDprt());
	}
	
	public String getDprt() {
		return dprt;
	}

	public void setDprt(String dprt) {
		this.dprt = dprt;
	}
}
