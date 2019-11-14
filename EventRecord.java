package def;

public class EventRecord {

	private Long validFrom;
	private Long validTo;
	private int setPosition;
	private boolean valid;

	
	public Long getValidFrom() {
		return validFrom;
	}
	
	
	public void setValidFrom(Long validFrom) {
		
		this.validFrom = validFrom; 
		
	}
	

	public int getPosition() {
	
		return setPosition;
	
	}

	public void setPosition(int setPosition) {
	
		this.setPosition = setPosition;
	
	}



	public Long getValidTo() {
		
		return validTo;
	
	}
	
	
	public void setValidTo(Long validto) {
		
		this.validTo = validto; 
		
	}

	public boolean getValid() {
	
		return valid;
	
	}
	
	public void setValid(boolean valid) {

		this.valid = valid;
		
	}





	
	
}
