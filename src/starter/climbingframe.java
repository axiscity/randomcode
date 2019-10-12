package starter;

import leg.LAdjust;
import leg.packt;
import utils.Calculatethis;

public class climbingframe {
	
	
	static Double fuel = 0.0;
	static Double altrate = 0.0;
	static boolean valid = false; 

	public climbingframe() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		packt journey = new packt();

		LAdjust Adjustments = new Calculatethis().Calculatethis(journey);
		
		
		System.out.println("::" + Adjustments.Distance);
		System.out.println("::" + Adjustments.AltRate);
		System.out.println("::" + Adjustments.fuel);
		

		if(fuel > 0.0) {
			valid = true;
		}
		
		System.out.println(valid + "::" + fuel);
		
		fuel = fuel + Adjustments.fuel;
		altrate = Adjustments.AltRate;

		
		if(fuel > 0.0) {
			valid = true;
		}
		
		System.out.println(valid + "::" + fuel + "::" + altrate);
		
		
		
		

	}

}
