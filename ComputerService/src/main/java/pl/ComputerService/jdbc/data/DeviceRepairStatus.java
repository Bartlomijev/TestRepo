package pl.ComputerService.jdbc.data;

public enum DeviceRepairStatus {

	UNREPAIRED("unrepaired"), PROCESSING("processing"), REPAIRED("repaired");
	
	private String repairStatusDescription;
	
	public String getRepairStatusDescription() {
		return repairStatusDescription;
	}
	
	DeviceRepairStatus(String repairStatusDescription){
		this.repairStatusDescription = repairStatusDescription;
	}

	

	
}
