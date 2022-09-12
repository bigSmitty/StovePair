
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
	
	
	//This returns a Temperature to make the "red light" functionality more robust later
	public Temperature display() {
		
		//Boring way of displaying the right message per temperature
		//Might have been better (if more verbose) to give "Temperature" string values and tostring and whatnot
		String myTempString = "";
		switch (this.myTemperature) {
			case COLD:
				myTempString = "cooool";
				break;
			case WARM:
				myTempString = "warm";
				break;
			case HOT:
				myTempString = "CAREFUL";
				break;
			case BLAZING:
				myTempString = "VERY HOT! DON'T TOUCH";
				break;
		}
		
		//Output final message
		System.out.println("[" + this.mySetting.toString() + "]....." + myTempString);
		
		//Return temperature for use in "red light" function
		return myTemperature;
	}
	
	public void updateTemperature() {
		
		if(this.timer > 0) {
			//Nothing to change yet, too early
			timer -= 1;
			return;
		}
		
		
		//Get the # of possible setting values
		int settingLength = Setting.values().length;
		
		//Evil ordinal hack
		int tempIndex = this.myTemperature.ordinal();
		int settingIndex = this.mySetting.ordinal();
		
		//Set the setting to be descending order (0 = hottest)
		//Could also change the enum declaration if we wanted to chance not matching the instructions
		settingIndex = settingLength - settingIndex - 1;
		
		//remember that 0=HOTTEST, 4=COLDEST
		if(tempIndex < settingIndex) {
			//Temp is *higher* than setting allows
			//decrease temperature
			tempIndex++;
			this.myTemperature = Temperature.values()[tempIndex];
		} else if(tempIndex > settingIndex) {
			//Temp is too low for burner setting
			//increase temp
			tempIndex--;
			this.myTemperature = Temperature.values()[tempIndex];
		}
		
		//If we still haven't reached equilibrium, reset timer to 2
		if(tempIndex != settingIndex) {
			this.timer = 2;
		}
	}
}
