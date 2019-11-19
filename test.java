package interpolo;


import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		betweenThis();
		

	}
	
	
	static void betweenThis()
	{
	
		int cr = 5;
		cr = between(cr, 8 , 2);
		
	}


	private static int between(int cr, int upperValue, int lowerValue) {
		// TODO Auto-generated method stub
		
		int middle = (upperValue - lowerValue) / 2;
		System.out.println(middle);
		
		return middle;
	}
	

	

}
