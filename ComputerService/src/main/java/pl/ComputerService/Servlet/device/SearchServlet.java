package pl.ComputerService.Servlet.device;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.jdbc.dao.DeviceDAO;
import pl.ComputerService.jdbc.data.Device;



public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("deviceId"));
        DeviceDAO dao = new DeviceDAO();
        Device device;
        String operation;
        boolean result = false;
       
            device = dao.selectById(id);
            result = device!=null? true:false;
            operation = "search";
        
        
        if(device != null && result) {
            request.setAttribute("option", operation);
            request.setAttribute("device", device);          
            request.getRequestDispatcher("tableView.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
	}
}
