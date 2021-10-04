package at.htlanich.htl_swp_web.models;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class LoginService {
    // SINGLETON PATTERN

    private LoginService() {

    }

    private static LoginService INSTANCE = null;

    public static LoginService getInstance() {
        return INSTANCE == null ? new LoginService() : INSTANCE;
    }

    public boolean canLogin(String fName, String lName, String pwd) throws ServletException {

        DBManager db = DBManager.getInstance();
        Connection con = null;
        var email = fName + "." + lName + "@gmail.com";

        try {
            con = db.getConnection();
            db.canLogin(con, email, pwd);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    db.releaseConnection(con);
                }
            }catch (Exception e){
                // NO Action
            }
        }

        return false;
    }
}
