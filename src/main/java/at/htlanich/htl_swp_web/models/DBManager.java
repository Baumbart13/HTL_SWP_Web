package at.htlanich.htl_swp_web.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class DBManager {
    // SINGLETON PATTERN

    private DBManager() {

    }

    private static DBManager INSTANCE = null;

    private String driver = "";
    private String dbUrl = "";
    private String user = "";
    private String pwd = "";

    public static DBManager getInstance() {
        return INSTANCE == null ? new DBManager() : INSTANCE;
    }

    public Connection getConnection() throws SQLException { // TODO
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.printf("JDBC is not installed. Please first install the driver and try to run this program afterwards.%n");
            System.exit(-1);
        }
        return DriverManager.getConnection(String.format(
                        "jdbc:mysql://%s/%s", "localhost:3306", "swp5ag1"),
                "root",
                "DuArschloch4"
        );
    }

    public void releaseConnection(Connection con) throws SQLException {
        if (con == null || con.isClosed()) {
            return;
        }
        con.close();
    }

    public boolean canLogin(Connection con, String email, String pwd) {
        // TODO
        var sql = "select count(*) from benutzer where email = ? and passwort = ?;";
        var success = false;

        try (var stmnt = con.prepareStatement(sql)) {
            stmnt.setString(1, email);
            stmnt.setString(2, pwd);

            var rs = stmnt.executeQuery();
            if (rs != null) {
                var count = rs.getInt(1);
                if (count > 0) success = true;
            }
        } catch (SQLException e) {

        }
        return success;
    }

    public boolean canRegister(Connection con, String email, String pwd){
        var sql = "";
        var success = false;

        try(var stmnt = con.prepareStatement(sql)){
            stmnt.setString(1, email);
            stmnt.setString(2, pwd);

            var rs = stmnt.executeQuery();
            if(rs != null){
                var count = rs.getInt(1);
                if(count > 0) success = true;
            }
        }catch (SQLException e){

        }
        return success;
    }
}
