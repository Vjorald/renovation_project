import java.util.Map;

public class Surface extends RenovationObject {
	
	private double length;
	private double width;
	public Material selectedMaterial;
	
	public Surface(double length, double width) {
		
		if(length < 0 || width < 0) 
			throw new IllegalArgumentException("Negative Argument!!");
		if(length == 0 || width == 0)
			throw new IllegalArgumentException("Null Argument!");
		
		this.length = length;
		this.width = width;
	}
	
	public void setMaterial(Material material) {
		if (material.equals(null))
			throw new NullPointerException("Argument nicht akzeptabel!");
		
		selectedMaterial = material;
		
	}
	
	public double getArea() {
		return length*width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getPrice() {
		Surface surface = new Surface (this.length,this.width);
		return selectedMaterial.getPriceOfASurface(surface);
	}
	
	
	public Map<String,Integer> addMaterialRequirements (Map<String,Integer> materials) {
		if (materials.equals(null))
			throw new NullPointerException("Nullargument!");
		if (selectedMaterial.equals(null))
			throw new NullPointerException("Selected Material gleich null!");
		for(Map.Entry<String,Integer> entry : materials.entrySet())
		{
			if(entry.getKey() == null || entry.getValue() == null)
				throw new NullPointerException("Unzulaessiger Wert!!");
			
			if(entry.equals(null))
				throw new NullPointerException("Unzulaessiger Mapping!");
			
		}
		
		material.clear();
		
		Surface surface = new Surface(getLength(), getWidth());
	    material.put(selectedMaterial.getName(), selectedMaterial.getMaterialRequirements(surface));
		
		int c;
		for(Map.Entry<String,Integer> entry : materials.entrySet() ) {
			
			if(material.containsKey(entry.getKey()) != true) // New mapping if no such mapping available
				material.put(entry.getKey(),entry.getValue());
			else
			{
			for(Map.Entry<String, Integer> subentry : material.entrySet()) {  
				if(subentry.getKey().equals(entry.getKey())) {
					c = subentry.getValue() + entry.getValue();
					if(subentry.getValue() == null)
						material.merge(entry.getKey(), entry.getValue() , null);
					else
					    material.put(entry.getKey(), c);
					
				}
					
				}
			}
			
		}
		
		return material;
	}

}
