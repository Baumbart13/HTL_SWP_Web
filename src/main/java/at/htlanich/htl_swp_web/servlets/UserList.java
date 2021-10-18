package at.htlanich.htl_swp_web.servlets;

import at.htlanich.htl_swp_web.models.LoginService;
import com.google.gson.Gson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Parameter einlesen - brauchn ma do nid
        var serv = LoginService.getInstance();
        var l = serv.getUsers();
        var g = new Gson();
        var json = g.toJson(l);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        var out = response.getWriter();
        out.append(json);
        out.flush();
    }
}
