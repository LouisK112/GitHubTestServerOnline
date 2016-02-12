/**
 * 
 */
package village;

/**
 * @author Louis Krüger
 *
 */
public class Product {
	
	// Attribute
	String name;
	
	//Konstruktor
	
	/**
	 * Erstellt ein Objekt der Klasse Product
	 * @param aName Name des Objekts
	 */
	public Product(String aName) {
		this.name = aName;
	}
	
	
	//Getter/Setter
	
	/**
	 * Get-Methode des Attributs Name
	 * @return Name des Attributs
	 */
	public String getName() {
		return name;	
	}
	
	
	
	//Methoden
	
	/**
	 * Diese Methode überschreibt die bereits in Java implementierte equals-Methode der Klasse Object
	 * @param obj ein beliebiges Objekt
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null) return false;
		if (obj == this) return true;
		if (!obj.getClass().equals(getClass())) return false;
		
		Product that = (Product) obj;  //cast
		
		if (that.getName()== this.getName())return true;
		else return false;
		
	}
	

}































