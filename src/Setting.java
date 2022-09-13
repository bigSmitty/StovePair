/**
 * Setting enum. 
 *  
 * @author Eli Irvine
 * @author Ruddock Matthew Smith
 * 
 * Purpose: Enum for the four settings on a stove
 */
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String value;
	private Setting(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}
