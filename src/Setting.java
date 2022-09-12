
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
