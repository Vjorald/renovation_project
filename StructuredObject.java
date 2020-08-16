import java.util.*;
import java.util.Map;


public class StructuredObject extends RenovationObject {

	private Set<RenovationObject> parts = new HashSet<RenovationObject>();
    
	
	public StructuredObject() {
		
	}
	
	public void add(RenovationObject renovationObject) {
		if(renovationObject.equals(null))
			throw new NullPointerException("RenovationObject gleich Null!");
		parts.add(renovationObject);
		
	}
	
	public double getPrice() {
		double cost = 0;
		for(RenovationObject entry : parts) {
			cost += entry.getPrice();
		}
		
		return cost;
	}
	
	public Map<String,Integer> addMaterialRequirements (Map<String,Integer> materials) {
		if (materials.equals(null))
			throw new NullPointerException("Nullargument!");
		for(Map.Entry<String,Integer> entry : materials.entrySet())
		{
			if(entry.getKey() == null || entry.getValue() == null)
				throw new NullPointerException("Unzulaessiger Wert!!");
			
			if(entry.equals(null))
				throw new NullPointerException("Unzulaessiger Mapping!");
			
		}
		
		
		for(RenovationObject entry : parts) {
			if(entry instanceof Surface )
				material.put((((Surface) entry).selectedMaterial.getName()),((Surface) entry).selectedMaterial.getMaterialRequirements((Surface)entry));
			else if(entry instanceof StructuredObject)
				for(RenovationObject subentry : ((StructuredObject) entry).parts)
				{
					if(subentry instanceof Surface)
						material.put((((Surface) subentry).selectedMaterial.getName()),((Surface) subentry).selectedMaterial.getMaterialRequirements((Surface)subentry));
				}
				
		}
		
		
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


	

