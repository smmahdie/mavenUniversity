package ir.maktab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ir.maktab.entities.Person;
import ir.maktab.entities.Student;

public class StudentDAO extends DAO {

	private static StudentDAO instance;
	public static StudentDAO getInstance() {
		// TODO Auto-generated constructor stub
		if(instance == null)
			instance = new StudentDAO();
		return instance;
	}
	
	@Override
	public Boolean save(Person p) {
		// TODO Auto-generated method stub
		try {
			Student me = (Student) p;
			String query = "insert into student (id, name, dprt, profid) values(?,?,?,?);";
			ps = con.prepareStatement(query);
			ps.setInt(1, me.getId());
			ps.setString(2, me.getName());
			ps.setString(3, me.getDprt());
			ps.setInt(4, me.getProfid());

			ps.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public Person load(Integer id) {
		// TODO Auto-generated method stub
		String query = "select * from student where id = ?";
		try {
			
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Student me = new Student();
			me.setId(rs.getInt("id"));
			me.setName(rs.getString("name"));
			me.setDprt(rs.getString("dprt"));
			me.setProfid(rs.getInt("profid"));
			return me;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Boolean update(Person p) {
		// TODO Auto-generated method stub
		try {
			Student me = (Student) p;
			String query = "update student set name=?, dprt=?, profid=? where id=?;";
			ps = con.prepareStatement(query);
			ps.setString(1, me.getName());
			ps.setString(2, me.getDprt());
			ps.setInt(3, me.getProfid());
			ps.setInt(4, me.getId());

			ps.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			String query = "delete from student where id = ?;";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		String query = "select * from student;";
		try {
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.last();
			List<Person> al = new ArrayList<>();
			Student s;
			rs.first();
			do {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setDprt(rs.getString("dprt"));
				s.setProfid(rs.getInt("profid"));
				
				al.add(s);
			} while (rs.next());
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
