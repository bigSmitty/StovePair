
public class Burner {
	//Temperature is burner-specific, so no need for its own class
	public enum Temperature {BLAZING, HOT, WARM, COLD};
	private Temperature myTemperature;
	
	//References Setting.java
	private Setting mySetting;
	
	
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
		//We *shouldn't* have to set timer, but this might help avoid errors in the future
		this.timer = 0;
	}
	
	//Cycle burner up one heat, if possible
	public void plusButton() {
		//Using a switch statement for the purposes of learning
		switch (this.mySetting) {
			//using the "this" keyword isn't necessary
			//But I like the legibility of it
			case OFF:
				this.mySetting = Setting.LOW;
				break;
				
			case LOW:
				this.mySetting = Setting.MEDIUM;
				break;
				
			case MEDIUM:
				this.mySetting = Setting.HIGH;
				break;
			
			//Already on high, can't increase setting more
			case HIGH:
				break;
		}
		
		//Reset time to update burner heat
		this.timer = TIME_DURATION;
	}
	
	//Cycle burner down one heat, if possible
	public void minusButton() {
		//Reset time to update burner heat
		this.timer = TIME_DURATION;
		
		//Using a switch statement for the purposes of learning
		switch (this.mySetting) {
		    
			case OFF:
				//Already on low, can't decrease setting more
				break;
						
			case LOW:
				this.mySetting = Setting.OFF;
				break;
						
			case MEDIUM:
				this.mySetting = Setting.LOW;
				break;
		
			
			case HIGH:
				this.mySetting = Setting.MEDIUM;
				break;
		}
				
		
	}
	
	
}
