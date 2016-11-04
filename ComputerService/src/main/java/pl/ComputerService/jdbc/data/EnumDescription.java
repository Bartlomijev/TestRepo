package pl.ComputerService.jdbc.data;

public class EnumDescription {

	public static DeviceRepairStatus deviceFromDescription(String desc) {
        for(DeviceRepairStatus u: DeviceRepairStatus.values()) {
            if(u.getRepairStatusDescription().equals(desc))
                return u;
        }
        return DeviceRepairStatus.UNREPAIRED;
    }
	
	 public static UserRoleName userFromDescription(String desc) {
	        for(UserRoleName u: UserRoleName.values()) {
	            if(u.getRoleDescription().equals(desc))
	                return u;
	        }
	        return UserRoleName.CLIENT;
	    }
	 
	
}
