package pl.ComputerService.jdbc.data;

public class User {
 
	private int userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userFirstAndLastName;
	private UserRoleName userRoleName;
	private String userPhoneNumber;
	private String userAddress;

	public User(int userId, String userName, String userPassword, String userEmail, String userFirstAndLastName,
			UserRoleName userRoleName, String userPhoneNumber, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userFirstAndLastName = userFirstAndLastName;
		this.userRoleName = userRoleName;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
	}

	public User() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserFirstAndLastName() {
		return userFirstAndLastName;
	}
	public void setUserFirstAndLastName(String userFirstAndLastName) {
		this.userFirstAndLastName = userFirstAndLastName;
	}
	public String getUserRoleName() {
		return userRoleName.getRoleDescription();
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = EnumDescription.userFromDescription(userRoleName);
	}
	
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userFirstAndLastName=" + userFirstAndLastName + ", userRoleName=" + userRoleName.getRoleDescription()
				+ ", userPhoneNumber=" + userPhoneNumber + ", userAddress=" + userAddress + "]";
	}

	
	
	
	
	
	
	
}
