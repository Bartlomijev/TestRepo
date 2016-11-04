package pl.ComputerService.jdbc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import pl.ComputerService.jdbc.data.Device;
import pl.ComputerService.jdbc.provider.ConnectionProvider;
import pl.ComputerService.jdbc.selects.DeviceSelects;
 
public class DeviceDAO {
 
	List<Device> allData; 
	
    public boolean createNewDevice(Device device) {
        Connection conn = null; 
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
        	conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DeviceSelects.CREATE);
            prepStmt.setInt(1, device.getDeviceId());
            prepStmt.setString(2, device.getDeviceName());
            prepStmt.setString(3, device.getDeviceDescription());
            prepStmt.setString(4, device.getDeviceRepairStatus()/*.getRepairStatusDescription()*/);
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }
 
    public Device selectById(int id) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        Device resultdevice = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DeviceSelects.SEARCH);
            prepStmt.setInt(1, id);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()) { 
                resultdevice = new Device(); 
                resultdevice.setDeviceId(resultSet.getInt("DEVICE_ID"));
                resultdevice.setDeviceName(resultSet.getString("DEVICE_NAME"));
                resultdevice.setDeviceDescription(resultSet.getString("PROBLEM_DESCRIPTION"));
                resultdevice.setDeviceRepairStatus(resultSet.getString("REPAIR_STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return resultdevice;
    }
    
    public List<Device> readAll() {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        Device resultDevice = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DeviceSelects.READ_ALL);
            resultSet = prepStmt.executeQuery();
            allData = new ArrayList<>();
            while(resultSet.next()) {
                resultDevice = new Device();
                resultDevice.setDeviceId(resultSet.getInt("DEVICE_ID"));
                resultDevice.setDeviceName(resultSet.getString("DEVICE_NAME"));
                resultDevice.setDeviceDescription(resultSet.getString("PROBLEM_DESCRIPTION"));
                resultDevice.setDeviceRepairStatus(resultSet.getString("REPAIR_STATUS"));
                allData.add(resultDevice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return allData;
    }
 
    public boolean updateDevice(Device device) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DeviceSelects.UPDATE);
            prepStmt.setString(1, device.getDeviceRepairStatus().toString());
            prepStmt.setInt(2, device.getDeviceId());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }
 
    public boolean deleteDevice(Device device) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(DeviceSelects.DELETE);
            prepStmt.setInt(1, device.getDeviceId());
            int rowsAffected = prepStmt.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, null, conn);
        }
        return result;
    }
 
    private void releaseResources(PreparedStatement prepStmt, ResultSet res,
            Connection conn) {
        try {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
            if (res != null && !res.isClosed()) {
                res.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
}