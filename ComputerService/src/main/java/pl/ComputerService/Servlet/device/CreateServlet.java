package pl.ComputerService.Servlet.device;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.jdbc.dao.DeviceDAO;
import pl.ComputerService.jdbc.data.Device;
import pl.ComputerService.jdbc.data.DeviceRepairStatus;


public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        Random r = new Random();
        
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
	        int deviceId = r.nextInt(9000000)+1000000;
	    	String deviceName = request.getParameter("deviceName");
	    	DeviceRepairStatus deviceRepairStatus = DeviceRepairStatus.UNREPAIRED;
	    	String deviceDescription = request.getParameter("deviceDescription");
	        DeviceDAO dao = new DeviceDAO();
	        Device device;
	        String operation;
	        boolean result = false;
	    
	            device = new Device(deviceId, deviceName, deviceDescription, deviceRepairStatus);
	            result = dao.createNewDevice(device);
	            operation = "add";
	        
	          if(device != null && result) {
	                request.setAttribute("option", operation);
	                request.setAttribute("device", device);          
	                request.getRequestDispatcher("tableView.jsp").forward(request, response);
	            } else {
	                request.getRequestDispatcher("error.jsp").forward(request, response);
	            }
	}

	
}
