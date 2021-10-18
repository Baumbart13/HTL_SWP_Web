package at.htlanich.htl_swp_web.models;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;

public class LoginService {
	private static LoginService instance = null;

	private LoginService() {
	}

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	public boolean canLogin(String user, String password)
			throws ServletException {
		//System.out.println(user + password);
		var db = DBManager.getInstance();
		Connection con = null;
		var success = false;

		try {
			con = db.getConnection();
			success = db.canLogin(con, user, password);
		} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
		}finally{
			try{
				if(con != null){
						db.relesaeConnection(con);
				}
			
			}catch(Exception ex){
				throw new ServletException(ex.getMessage());
			}
		}
		return success;
	}

	public List<User> getUsers() throws ServletException{
		//System.out.println(user + password);
		var db = DBManager.getInstance();
		Connection con = null;
		List<User> l;

		try {
			con = db.getConnection();
			l = db.getUsers(con);
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}finally{
			try{
				if(con != null){
					db.relesaeConnection(con);
				}

			}catch(Exception ex){
				throw new ServletException(ex.getMessage());
			}
		}
		return l;
	}
}
