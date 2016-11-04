package pl.ComputerService.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.ComputerService.jdbc.data.User;
import pl.ComputerService.jdbc.provider.ConnectionProvider;
import pl.ComputerService.jdbc.selects.UserSelects;

public class UserDAO {

	
	
	
	public boolean createNewUser(User user) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        boolean result = false;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(UserSelects.CREATE);
	            prepStmt.setInt(1, user.getUserId());
	            prepStmt.setString(2, user.getUserName());
	            prepStmt.setString(3, user.getUserPassword());
	            prepStmt.setString(4, user.getUserEmail());
	            prepStmt.setString(5, user.getUserFirstAndLastName());
	            prepStmt.setString(6, user.getUserRoleName());
	            prepStmt.setString(7, user.getUserPhoneNumber());
	            prepStmt.setString(8, user.getUserAddress());
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
	 
	 public User selectByUsername(String userName) {
	        Connection conn = null;
	        PreparedStatement prepStmt = null;
	        ResultSet resultSet = null;
	        User resultUser = null;
	        try {
	            conn = ConnectionProvider.getConnection();
	            prepStmt = conn.prepareStatement(UserSelects.SEARCH);
	            prepStmt.setString(1, userName);
	            resultSet = prepStmt.executeQuery();
	            if(resultSet.next()) {
	                resultUser = new User(); 
	                resultUser.setUserId(resultSet.getInt("USER_ID"));
	                resultUser.setUserPassword(resultSet.getString("PASSWORD"));
	                resultUser.setUserRoleName(resultSet.getString("ROLE_NAME"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseResources(prepStmt, resultSet, conn);
	        }
	        return resultUser;
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
