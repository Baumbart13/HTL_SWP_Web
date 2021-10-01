package at.htlanich.htl_swp_web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet(name = "DoRegister", value = "/DoRegister")
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
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        for(String x : request.getParameterMap().keySet()){
            System.out.println(request.getParameter(x));
        }

        while(request.getAttributeNames().hasMoreElements()){
            System.out.println(request.getAttributeNames().nextElement());
        }

        String fName = (String)request.getParameter("fname");
        String lName = (String)request.getParameter("lname");
        String pwd = (String)request.getParameter("pwd");
        String nickName = (String)request.getParameter("nname");

        RequestDispatcher d;
        boolean loopBackToRegister = true;

        if(fName.equalsIgnoreCase(nickName)){
            request.setAttribute("fail", "ForeName cannot equal nickname");

        }else if(lName == null){
            request.setAttribute("fail", "Last name cannot be empty");

        } else if(nickName == null){
            request.setAttribute("fail", "You must set a nickname");

        }else if(pwd == null){
            request.setAttribute("fail", "Why don't you want to set a password?!?!");

        }else{
            request.setAttribute("foreName", fName);
            request.setAttribute("lastName", lName);
            request.setAttribute("passwd", pwd);
            request.setAttribute("nickName", nickName);
            loopBackToRegister = false;
        }

        if(loopBackToRegister){
            d = request.getRequestDispatcher("Register.html");
        }else{
            d = request.getRequestDispatcher("Welcome.jsp");
        }

        d.forward(request, response);
    }
}
