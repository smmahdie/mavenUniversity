package ir.maktab.manager;

import java.util.ArrayList;
import java.util.List;

import ir.maktab.dao.TeacherDAO;
import ir.maktab.entities.Person;
import ir.maktab.entities.Teacher;

public class TeacherManager {
	private static TeacherManager instance;
	private TeacherDAO teacherDao = TeacherDAO.getInstance();
	
	public static TeacherManager getInstance(){
		if(instance == null){
			instance = new TeacherManager();
		}
		return instance;
	}
	
	public boolean save(Teacher t) {
		return teacherDao.save(t);
	}
	
	public Teacher load(Integer id){
		return (Teacher)teacherDao.load(id);
	}
	
	public boolean update(Teacher t) {
		return teacherDao.update(t);
	}
	
	public boolean delete(Integer id) {
		return teacherDao.delete(id);
	}
	
	public List<Teacher> list(){
		List<Teacher> lt = new ArrayList<>();
		for (Person p : teacherDao.list()) {
			lt.add((Teacher)p);
		}
		return lt;
	}
}
