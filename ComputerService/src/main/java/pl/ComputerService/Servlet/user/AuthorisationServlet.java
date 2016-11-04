package pl.ComputerService.Servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.ComputerService.jdbc.data.User;
import pl.ComputerService.jdbc.data.UserRoleName;

public class AuthorisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		User user;
		Boolean flag;
		String role;
		HttpSession session = request.getSession(true);
		user = (User) session.getAttribute("user");
		flag = (Boolean) session.getAttribute("flag"); 
		role = (String) session.getAttribute("role");
		
		if(user == null || flag == null || role==null) {
			user = (User) request.getAttribute("user");
			session.setAttribute("user", user);
			session.setAttribute("role", user.getUserRoleName());
			session.setAttribute("flag", true);
			user = (User) session.getAttribute("user");
			flag = (Boolean) session.getAttribute("flag"); 
			role = (String) session.getAttribute("role");
		}
		
		if (UserRoleName.CLIENT.getRoleDescription().equals(role)) {
			request.getRequestDispatcher("clientIndex.jsp").forward(request, response);
		} else if (UserRoleName.SERVICEMAN.getRoleDescription().equals(role)) {
			request.getRequestDispatcher("servicemanIndex.jsp").forward(request, response);
		} else if (UserRoleName.MANAGER.getRoleDescription().equals(role)) {
			request.getRequestDispatcher("managerIndex.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
