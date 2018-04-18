package ir.maktab.manager;

import java.util.ArrayList;
import java.util.List;

import ir.maktab.dao.StudentDAO;
import ir.maktab.entities.Person;
import ir.maktab.entities.Student;

public class StudentManager {
	private static StudentManager instance;
	private StudentDAO studentDao = StudentDAO.getInstance();
	
	public static StudentManager getInstance(){
		if(instance == null){
			instance = new StudentManager();
		}
		return instance;
	}
	
	public boolean save(Student s) {
		return studentDao.save(s);
	}
	
	public Student load(Integer id){
		return (Student)studentDao.load(id);
	}
	
	public boolean update(Student s) {
		return studentDao.update(s);
	}
	
	public boolean delete(Integer id) {
		return studentDao.delete(id);
	}
	
	public List<Student> list(){
		List<Student> ls = new ArrayList<>();
		for (Person p : studentDao.list()) {
			ls.add((Student)p);
		}
		return ls;
	}
}
