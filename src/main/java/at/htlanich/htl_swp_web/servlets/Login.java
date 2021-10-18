package at.htlanich.htl_swp_web.servlets;

import at.htlanich.htl_swp_web.models.LoginService;
import at.htlanich.htl_swp_web.models.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Anmelden")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var username = request.getParameter("username");
		var password = request.getParameter("password");

		var user = new User(username, password);
		
		var session = request.getSession();
		session.setAttribute("username", user.getUsername());
		
		var success = LoginService.getInstance().canLogin(user.getUsername(), user.getPassword());
		if (success) {	
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}else{
			request.setAttribute("errorMessage", "Username does not exist or password is wrong");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
