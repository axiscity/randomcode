package utils;

import leg.LAdjust;
import leg.packt;

public final class Calculatethis {

	public LAdjust Calculatethis(packt journey) {
		// TODO Auto-generated constructor stub

		LAdjust adjustments = new LAdjust();
		
		Double  distance = (double) 0;

		
        for(int i=0; i<journey.legParts.length -1 ; i++){
           
        	distance = distance + journey.legParts[i];       			
        	System.out.println("Count is: " + i);
            
       }
		
        adjustments.Distance = distance;
        adjustments.AltRate = distance / journey.altDiff;
        
        
		return adjustments;
        
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
