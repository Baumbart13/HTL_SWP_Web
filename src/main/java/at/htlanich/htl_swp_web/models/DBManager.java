package at.htlanich.htl_swp_web.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Datenbank modell erzeugen in workbench
// connector in lib hinzufügen
public class DBManager {
	private static DBManager instance = null;

	private DBManager() {
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	// java sql conneciton

	public Connection getConnection() throws SQLException { // TODO
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/swp5ag1?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "DuArschloch4");
		}catch (ClassNotFoundException e){
			System.err.printf("Please consider to install the correct JDBC-Driver and correct database-credentials%n");
		}
		return con;

	}

	public void relesaeConnection(Connection con) throws SQLException {
		con.close();
	}

	public boolean canLogin(Connection con, String user, String password)
			throws Exception {
		var sql = "select count(*) from benutzer where username = ? and password = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) == 1;
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return false;
	}

	public boolean canRegister(Connection con, User user) {
		var sql = "SELECT count(*) AS 'benutzercount' FROM benutzer where email = ? OR username = ?;";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getUsername());

			var rs = stmt.executeQuery();
			if(rs.next()){
				if(rs.getInt("benutzercount") > 0){
					return false;
				}
			}
		}catch(Exception ex){
			
		}
		return true;
	}

	public boolean insertUser(Connection con, User user) throws Exception {
		var sql = "INSERT INTO benutzer (email, username, firstname, lastname, password) VALUES (?, ?, ?, ?, ?);";
		var success = false;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getForename());
			stmt.setString(4, user.getLastname());
			stmt.setString(5, user.getPassword());
			success = stmt.execute();
		}
		return success;
	}

	public List<User> getUsers(Connection con) throws SQLException{
		var sql = "SELECT email,firstname,lastname,password,username FROM benutzer;";
		var l = new ArrayList<User>();

		try(var stmt = con.createStatement()){

			var rs = stmt.executeQuery(sql);
			while(rs.next()){
				var mail = rs.getString(1);
				var fName = rs.getString(2);
				var lName = rs.getString(3);
				var pwd = rs.getString(4);
				var uName = rs.getString(5);
				l.add(new User(mail, uName, fName, lName, pwd));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return l;
	}
}
