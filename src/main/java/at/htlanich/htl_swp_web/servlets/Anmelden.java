package at.htlanich.htl_swp_web.servlets;

import at.htlanich.htl_swp_web.models.LoginService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSuccess
 */
@WebServlet("/LoginSuccess")
public class Anmelden extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anmelden() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        out.append("<html>");
        out.append("<body>");
        out.append("<p>Willkommen, lol... [get]</p>");
        out.append("</body>");
        out.append("</html>");
        out.flush();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Auslesen der Parameter
        String fName = request.getParameter("fname");
        String lName = request.getParameter("lname");
        String pwd = request.getParameter("pwd");

        // Lösung der Aufgabe
        boolean success = LoginService.getInstance().canLogin(fName, lName, pwd);

        // Werte für die JSP als Attribute festhalten
        request.setAttribute("foreName", fName);
        request.setAttribute("lastName", lName);
        request.setAttribute("passwd", pwd);
        request.setAttribute("nickName", "Baumi");

        // Weiterleitung
        if(success) {
            RequestDispatcher d = request.getRequestDispatcher("Welcome.jsp"); // Ziel wohin weitergeleitet werden soll angeben
            d.forward(request, response);
        }else{
            RequestDispatcher d = request.getRequestDispatcher("index.html"); // Ziel wohin weitergeleitet werden soll angeben
            d.forward(request, response);
        }

    }

}
