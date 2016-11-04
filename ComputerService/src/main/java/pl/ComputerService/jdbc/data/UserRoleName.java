package pl.ComputerService.jdbc.data;

public enum UserRoleName {
	CLIENT("client"), SERVICEMAN("serviceman"), MANAGER("manager");

	private String roleDescription;

	public String getRoleDescription() {
		return roleDescription;
	}

	UserRoleName(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	

}
