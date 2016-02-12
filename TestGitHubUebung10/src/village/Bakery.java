/**
 * 
 */
package village;

/**
 * @author Louis Kr�ger
 *
 */
public class Bakery extends Plant {

	//Attribute
	int ovenCount;
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Bakery
	 * @param aName Name der B�ckerei
	 * @param Oven Anzahl der �fen
	 */
	public Bakery(String aName, int Oven) {
		super(aName);
		ovenCount = Oven;
		if (ovenCount < 1) throw new IllegalArgumentException("Die Mindestanzahlan �fen muss mindestens 1 betragen. Eingegeben: " + ovenCount);

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
	 * Bestimmt die Produktionszeit f�r ein Brot bei gegebener Ofen-Anzahl
	 */
	@Override
	public double productionTime() {
		return (double) 1/this.ovenCount;
	}
	
	

}
