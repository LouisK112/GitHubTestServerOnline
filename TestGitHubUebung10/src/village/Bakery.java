/**
 * 
 */
package village;

/**
 * @author Louis Krüger
 *
 */
public class Bakery extends Plant {

	//Attribute
	int ovenCount;
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Bakery
	 * @param aName Name der Bäckerei
	 * @param Oven Anzahl der Öfen
	 */
	public Bakery(String aName, int Oven) {
		super(aName);
		ovenCount = Oven;
		if (ovenCount < 1) throw new IllegalArgumentException("Die Mindestanzahlan Öfen muss mindestens 1 betragen. Eingegeben: " + ovenCount);

		Product Flour = new Product ("Flour");
		this.setProcessibleProduct(Flour);
	}

	
	//Methoden
	
	/**
	 * Produziert ein Brot, wenn Mehl im Speicher ist und lagert es
	 */
	@Override
	public void produce() {
		if (!(this.getStorage() == null) && this.getStorage().equals(this.getProcessibleProduct())){
			Product Bread = new Product ("Bread");
			this.setStorage(Bread);
		}
	}
	
	/**
	 * Bestimmt die Produktionszeit für ein Brot bei gegebener Ofen-Anzahl
	 */
	@Override
	public double productionTime() {
		return (double) 1/this.ovenCount;
	}
	
	

}
