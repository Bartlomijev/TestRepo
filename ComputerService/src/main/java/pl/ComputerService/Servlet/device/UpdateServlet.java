package pl.ComputerService.Servlet.device;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ComputerService.jdbc.dao.DeviceDAO;
import pl.ComputerService.jdbc.data.Device;
import pl.ComputerService.jdbc.data.DeviceRepairStatus;
import pl.ComputerService.jdbc.data.EnumDescription;



public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        DeviceRepairStatus deviceRepairStatus = EnumDescription.deviceFromDescription(request.getParameter("deviceRepairStatus"));
        String deviceName = null;
    	String deviceDescription = null;
        DeviceDAO dao = new DeviceDAO();
        Device device;
        String operation;
        boolean result = false;
        
      
            device = new Device(deviceId, deviceName, deviceDescription, deviceRepairStatus);
            result = dao.updateDevice(device);
            operation = "update";
        
        if(device != null && result) {
            request.setAttribute("option", operation);
            request.setAttribute("device", device);          
            request.getRequestDispatcher("tableView.html").forward(request, response);
        } else {
            request.getRequestDispatcher("error.html").forward(request, response);
        }
	}

}
