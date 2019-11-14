package def;

public class EventChunk {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//eventDurationTime Event1 = new eventDurationTime();
		
		 Object Event1 = eventDurationTime(0, 10, 0, true);
		 Object Event2 = eventDurationTime(10, 20, 1, true);
		 Object Event3 = eventDurationTime(20, 30, 3, true);
		 Object Event4 = eventDurationTime(30, 40, 4, true);
		
		
		 
		 
	}
	
	
static EventRecord eventDurationTime(long validFrom, long validto, int position, boolean valid){
		
	EventRecord event = new EventRecord();

	event.setValidFrom(validFrom);
	event.setValidTo(validto);
	event.setPosition(position);
	event.setValid(valid);
	
	return (EventRecord) event;
		
		
	}
	
	
	
	
	
	
	

}
