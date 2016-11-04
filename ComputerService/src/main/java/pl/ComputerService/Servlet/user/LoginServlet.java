package pl.ComputerService.Servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.ComputerService.jdbc.dao.UserDAO;
import pl.ComputerService.jdbc.data.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("LoginServlet");
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		User user;
		UserDAO dao = new UserDAO();	
	    boolean result = false;
		
		 user = dao.selectByUsername(userName);
		 result = user!=null? true:false;
  
         if(user != null && result && password.equals(user.getUserPassword())) {   
             request.setAttribute("user", user);  
             request.getRequestDispatcher("/AuthorisationServlet").forward(request, response);
         } else {
             request.getRequestDispatcher("loginError.html").forward(request, response);
         }
	}

}
















/*
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println(userName + " " + password);
	UserDAO dao = new UserDAO();
	User user;
	String operation;
    boolean result = false;
	
  
	 user = dao.selectByUsername(userName);
	 result = user!=null? true:false;
     operation = "search";

     if(user != null && result && password.equals(user.getUserPassword()) && UserRoleName.CLIENT.getRoleDescription().equals(user.getUserRoleName())) {
         request.setAttribute("option", operation);
         request.setAttribute("user", user);          
         request.getRequestDispatcher("clientIndex.jsp").forward(request, response);
     } else if (user != null && result && password.equals(user.getUserPassword()) && UserRoleName.SERVICEMAN.getRoleDescription().equals(user.getUserRoleName())){
    	  request.setAttribute("option", operation);
          request.setAttribute("user", user);          
          request.getRequestDispatcher("servicemanIndex.jsp").forward(request, response);
     } else if (user != null && result && password.equals(user.getUserPassword()) && UserRoleName.MANAGER.getRoleDescription().equals(user.getUserRoleName())){
    	  request.setAttribute("option", operation);
          request.setAttribute("user", user);          
          request.getRequestDispatcher("managerIndex.jsp").forward(request, response);
     } else {
         request.getRequestDispatcher("error.jsp").forward(request, response);
     }
}

}*/
