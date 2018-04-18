package ir.maktab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ir.maktab.entities.Person;

public abstract class DAO {
	protected Connection con;
	protected PreparedStatement ps;
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/uni?user='root'";
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract Boolean save(Person p);
	public abstract Person load(Integer id);
	public abstract Boolean update(Person p);
	public abstract Boolean delete(Integer id);
	public abstract List<Person> list();
	
	@Override
	protected void finalize(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}