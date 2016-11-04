package pl.ComputerService.Servlet.user;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.jdbc.dao.UserDAO;
import pl.ComputerService.jdbc.data.User;
import pl.ComputerService.jdbc.data.UserRoleName;
import pl.ComputerService.jdbc.data.EnumDescription;




public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	   Random r = new Random();
       
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			  request.setCharacterEncoding("UTF-8");
			  int userId = r.nextInt(9000000)+1000000;
			String userName = request.getParameter("userLogin");
			String userPassword = request.getParameter("userPassword");
			String userEmail = request.getParameter("userEmail");
			String userFirstAndLastName = request.getParameter("userFirstName") + " " + request.getParameter("userLastName");
		 UserRoleName userRoleName = EnumDescription.userFromDescription("client_role");
		 String userPhoneNumber = request.getParameter("userPhone");
		 String userAddress = request.getParameter("userAddress");
		     
		 UserDAO dao = new UserDAO();
		      
		    	User user;
		        String operation;
		        boolean result = false;
		    
		            user = new User(userId, userName, userPassword, userEmail, userFirstAndLastName, userRoleName, userPhoneNumber, userAddress);
		            result = dao.createNewUser(user);
		            operation = "add";
		        
		          if(user != null && result) {
		                request.setAttribute("option", operation);
		                request.setAttribute("user", user);          
		                request.getRequestDispatcher("index.html").forward(request, response);
		            } else {
		                request.getRequestDispatcher("error.html").forward(request, response);
		            }
		}


}
