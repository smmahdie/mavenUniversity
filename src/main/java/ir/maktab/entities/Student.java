package ir.maktab.entities;

import ir.maktab.dto.StudentDTO;

public class Student extends Person {
	private String dprt;
	private int profid;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(StudentDTO studentDTO) {
		super(studentDTO.getId(), studentDTO.getName());
		setDprt(studentDTO.getDprt());
		setProfid(0);
	}

	public int getProfid() {
		return profid;
	}

	public void setProfid(int profid) {
		this.profid = profid;
	}

	public String getDprt() {
		return dprt;
	}

	public void setDprt(String dprt) {
		this.dprt = dprt;
	}

}
