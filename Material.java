
public class Material {
	
	private String name;
	private double price;
	
	
	public Material (String name, double price) {
		if(name.equals(null)) 			
			throw new NullPointerException("Name gleich null!");
		else if (name == "")
			throw new IllegalArgumentException("Name ist leer!");
		else if (price < 0)
			throw new IllegalArgumentException("Negativer Preis!");
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPricePerUnit() {
		return price;
	}
	
	public int getMaterialRequirements(Surface surface) {
		
		Paint paint = (Paint)surface.selectedMaterial;
		
		if (surface.selectedMaterial instanceof Flooring ) { 
			Flooring flooring = (Flooring)surface.selectedMaterial;
			return flooring.getMaterialRequirements(surface);
		}
		
		return paint.getMaterialRequirements(surface); // If selected material instance of paint
		
	}
	
	public double getPriceOfASurface(Surface surface) {
		if(surface.equals(null))
			throw new NullPointerException("Name gleich null!");
		return getPricePerUnit() *  getMaterialRequirements(surface);
	}

}
