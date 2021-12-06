package at.htlanich.htl_swp_web.servlets;

import at.htlanich.htl_swp_web.models.RegisterService;
import at.htlanich.htl_swp_web.models.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/DoRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Register.jsp");
	}

	/*<form action="RegistrationServlet" method="post">
		<label>Email</label>
		<input type="text" name="email">
		<br>
		<label>Username</label>
		<input type="text" name="username">
		<br>
		<label>Firstname</label>
		<input type="text" name="firstname">
		<br>
		<label>Lastname</label>
		<input type="text" name="lastname">
		<br>
		<label>Password</label>
		<input type="password" name="password">
		<br>
		<label>Repeat password</label>
		<input type="password" name="passwordrepeated">
		<br>
		<input type="submit" value="Registrate">
	</form>
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String ERROR_KEY = "error";
		var email = request.getParameter("email");
		var uName = request.getParameter("username");
		var fName = request.getParameter("firstname");
		var lName = request.getParameter("lastname");
		var pwd = request.getParameter("password");
		var pwdRepeat = request.getParameter("passwordrepeated");

		var user = new User(email, uName, fName, lName, pwd);

		if(!pwd.equals(pwdRepeat)){
			request.setAttribute(ERROR_KEY, "Password must be identical!");
		}

		var canRegister = RegisterService.getInstance().canRegister(user);
		if(canRegister){
			canRegister = RegisterService.getInstance().insertUser(user);
		}

		if(!canRegister){
			request.setAttribute(ERROR_KEY, "We were unable to register your account. Probably it is already registered.");
		}

		/*var session = request.getSession();
		session.setAttribute("username", user.getUsername());*/

		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
	}

}
