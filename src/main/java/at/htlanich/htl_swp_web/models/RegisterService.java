package at.htlanich.htl_swp_web.models;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterService {
	private static RegisterService instance = null;

	private RegisterService() {
	}

	public static RegisterService getInstance() {
		if (instance == null) {
			instance = new RegisterService();
		}
		return instance;
	}
	
	public boolean canRegister(User user) throws ServletException {
		// only check if this email is already inside of the database
		var db = DBManager.getInstance();
		Connection con = null;
		var success = true;

		try{
			con = db.getConnection();
			success = db.canRegister(con, user);
		}catch (SQLException e){
			success = false;
			throw new ServletException(e.getMessage());
		}finally{
			try{
				if(con!=null){
					db.relesaeConnection(con);
				}
			}catch (SQLException e){
				success = false;
				throw new ServletException(e.getMessage());
			}
		}
		return success;
	}
	
	public boolean insertUser(User user) throws ServletException{
		// insert the requested user into the database
		var db = DBManager.getInstance();
		Connection con = null;

		try{
			con = db.getConnection();
			return db.insertUser(con, user);
		}catch (Exception e){
			throw new ServletException(e.getMessage());
		}finally{
			try{
				if(con!=null){
					db.relesaeConnection(con);
				}
			}catch (SQLException e){
				throw new ServletException(e.getMessage());
			}
		}
	}
}
