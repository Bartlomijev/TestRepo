package pl.ComputerService.jdbc.selects;

public class UserSelects {

	public final static String CREATE = "INSERT INTO user(USER_ID, USERNAME, PASSWORD, EMAIL, FIRST_AND_LAST_NAME, ROLE_NAME, PHONE_NUMBER, ADDRESS) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
	public final static String SEARCH = "SELECT USER_ID, PASSWORD, ROLE_NAME FROM user WHERE USERNAME = ?;";
	
}
