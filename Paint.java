import java.lang.Math;

public class Paint extends Material{
	
	private double limit= 0.02;
	private int numberOfCoats;
	public double squareMetersPerLiter;
	
	public Paint (String name, double price, int numberOfCoats, double squareMetersPerLiter) {
		super(name,price);
		if(name.equals(null))
			throw new NullPointerException("Name gleich null!");
		if (name == "")
			throw new IllegalArgumentException("Leerer Name!");
		if(numberOfCoats == 0)
			throw new IllegalArgumentException("NumberOfCoats gleich null!");
		if (numberOfCoats < 0)
			throw new IllegalArgumentException("NumberOfCoats ist Negativ!");
		if (squareMetersPerLiter == 0)
			throw new IllegalArgumentException("NoofsquareMetersPerLiter gleich null.");
		if (squareMetersPerLiter < 0)
			throw new IllegalArgumentException("NoofsquareMetersPerLiter gleich Null.");
		if(price == 0)
			throw new IllegalArgumentException("Preis gleich Null!");
		if(price < 0)
			throw new IllegalArgumentException("Preis kleiner als Null!");
		this.numberOfCoats = numberOfCoats;
		this.squareMetersPerLiter = squareMetersPerLiter;
	}
	
	
	public int getNumberOfCoats() {
		return numberOfCoats;
	}
	
	
	public double getSquareMetersPerLiter() {
		return squareMetersPerLiter;
	}
	

	public int getMaterialRequirements(Surface surface) {
		double amount_in_liters = surface.getArea() * numberOfCoats / squareMetersPerLiter;
		int amount_in_liters_rounded;
		double amount_in_liters_int;
		int number_of_buckets = 0; // For one liter two buckets needed
		
		
		
		
		if(Math.round((amount_in_liters - Math.floor(amount_in_liters))*100)/100.0 < (0.5 + limit) && Math.round((amount_in_liters - Math.floor(amount_in_liters))*100)/100.0 >= limit )
		{
			amount_in_liters_int = Math.floor(amount_in_liters);
			amount_in_liters_rounded = (int) amount_in_liters_int;
			number_of_buckets = amount_in_liters_rounded * 2 + 1;
		}
		else if (Math.round((amount_in_liters - Math.floor(amount_in_liters))*100)/100.0 < limit){
		  	amount_in_liters_int = Math.floor(amount_in_liters);
			amount_in_liters_rounded = (int) amount_in_liters_int;
			number_of_buckets = amount_in_liters_rounded * 2;
		}
		else if (Math.round((amount_in_liters - Math.floor(amount_in_liters))*100)/100.0 >= (0.5 + limit))
		{
		    amount_in_liters_int = Math.floor(amount_in_liters);
			amount_in_liters_rounded = (int) amount_in_liters_int;
			number_of_buckets = amount_in_liters_rounded * 2 + 2;
		    
		    
		}
		
		return number_of_buckets;
		
	}
	
	
	
}
