package pl.ComputerService.jdbc.selects;

public class DeviceSelects {

	public final static String SEARCH = "SELECT DEVICE_ID, DEVICE_NAME, PROBLEM_DESCRIPTION, REPAIR_STATUS FROM device WHERE DEVICE_ID = ?;";
	public final static String CREATE = "INSERT INTO device(DEVICE_ID, DEVICE_NAME, PROBLEM_DESCRIPTION, REPAIR_STATUS) VALUES(?, ?, ?, ?);";
	public final static String UPDATE = "UPDATE device SET REPAIR_STATUS = ? WHERE DEVICE_ID = ?;";
	public final static String DELETE = "DELETE FROM device WHERE DEVICE_ID = ?;";
	public final static String READ_ALL = "SELECT DEVICE_ID, DEVICE_NAME, PROBLEM_DESCRIPTION, REPAIR_STATUS FROM device;";
}
