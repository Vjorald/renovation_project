import java.lang.Math;

public class Flooring extends Material{
	
	private double limit = 0.02;
	private double widthOfFlooring;
	
	
	public Flooring (String name, double price, double width) {
		super(name,price);
		if(name.equals(null))
			throw new NullPointerException("Name gleich null!");
		else if (name == "")
			throw new IllegalArgumentException("Leerer Name!");
		else if(price < 0 || width < 0)
			throw new IllegalArgumentException("Negtiver Argument");
		else if(width == 0)
			throw new IllegalArgumentException("Width gleich null!");
		
		widthOfFlooring = width;
	}
	
	
	public double getWidth() {
		return widthOfFlooring;
	}
	
	
	public int getMaterialRequirements(Surface surface) {
		
		double number_of_panels = surface.getArea() / widthOfFlooring;
		int number_of_panels_rounded;
		
		
		if(Math.round((number_of_panels - Math.floor(number_of_panels))*100)/100.0  >= limit) {
			
			number_of_panels = Math.ceil(number_of_panels);
		}
		else
		{
			number_of_panels = Math.floor(number_of_panels);
		}
		
		number_of_panels_rounded = (int) number_of_panels;
		
		return number_of_panels_rounded;
		
	}

}
