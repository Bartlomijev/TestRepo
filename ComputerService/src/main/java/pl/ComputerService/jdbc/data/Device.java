package pl.ComputerService.jdbc.data;

public class Device {

	private int deviceId;
	private String deviceName;
	private String deviceDescription; 
	private DeviceRepairStatus deviceRepairStatus;
	
	
	public Device(int deviceId, String deviceName, String deviceDescription, DeviceRepairStatus deviceRepairStatus) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceDescription = deviceDescription;
		this.deviceRepairStatus = deviceRepairStatus;
	}
	
	public Device() {
		super();
	}
	
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceDescription() {
		return deviceDescription;
	}
	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}
	public String getDeviceRepairStatus() {
		return deviceRepairStatus.getRepairStatusDescription();
	}
	public void setDeviceRepairStatus(String deviceRepairStatus) {
		this.deviceRepairStatus = EnumDescription.deviceFromDescription(deviceRepairStatus) ;
	}
	
	@Override
	public String toString() {
		return "CurrentDevice [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceDescription="
				+ deviceDescription + ", deviceRepairStatus=" + deviceRepairStatus.getRepairStatusDescription() + "]";
	}
	
	
}
