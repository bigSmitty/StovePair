
public class Burner {
	//Temperature is burner-specific, so no need for its own class
	public enum Temperature {BLAZING, HOT, WARM, COLD};
	private Temperature myTemperature;
	
	//References Setting.java
	private Setting mySetting;
	
	//Timer not set, it's always set by other methods when relevant
	private int timer;
	public static final int TIME_DURATION = 2;
	
	//Auto-generated getter
	public Temperature getMyTempereature() {
		return myTemperature;
	}
	
	//Only ever use default constructor, no reason for arguments
	public Burner() {
		super();
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
		
	}
}
