package ir.maktab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ir.maktab.entities.Person;
import ir.maktab.entities.Teacher;

public class TeacherDAO extends DAO {

	private static TeacherDAO instance;

	public static TeacherDAO getInstance() {
		// TODO Auto-generated constructor stub
		if (instance == null)
			instance = new TeacherDAO();
		return instance;
	}

	@Override
	public Boolean save(Person p) {
		// TODO Auto-generated method stub
		try {
			Teacher me = (Teacher) p;
			String query = "insert into prof (id, name, degree) values(?,?,?);";
			ps = con.prepareStatement(query);
			ps.setInt(1, me.getId());
			ps.setString(2, me.getName());
			ps.setString(3, me.getDegree());

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
		String query = "select * from prof where id =?;";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Teacher me = new Teacher();
			rs.next();
			me.setId(rs.getInt("id"));
			me.setName(rs.getString("name"));
			me.setDegree(rs.getString("degree"));
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
			Teacher me = (Teacher) p;
			String query = "update prof set name=?, degree=? where id=?;";
			ps = con.prepareStatement(query);
			ps.setString(1, me.getName());
			ps.setString(2, me.getDegree());
			ps.setInt(3, me.getId());

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
			String query = "delete from prof where id = ?;";
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
		String query = "select * from prof;";
		try {
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.last();
			Teacher t;
			List<Person> al = new ArrayList<>();
			rs.first();
			do {
				t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setDegree(rs.getString("degree"));
				
				al.add(t);
			} while (rs.next());
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
