import java.util.TreeMap;
import java.util.Map;



public abstract class RenovationObject {
	public Map<String,Integer> material = new TreeMap <String,Integer>();
	public Surface surface_of_renovationObject;
	
	
	public abstract double getPrice();
	
	
	public abstract Map<String,Integer> addMaterialRequirements (Map<String,Integer> materials);
	
	public static void main(String [] args) {
		
	}
	
}
