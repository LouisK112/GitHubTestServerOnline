/**
 * 
 */
package village;

/**
 * @author Louis Krüger
 *
 */
public abstract class Mill extends Plant {

	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Mill (Achtung abstrakt!--> gilt für Unterklasse)
	 * und setzt produzierbares Produkt auf Corn fest
	 * @param aName Name der Mühle 
	 */
	public Mill(String aName) {
		super(aName);
		
		Product Corn = new Product ("Corn");
		this.setProcessibleProduct(Corn);
	
	}

	
	//Methoden
	
	/**
	 * Produziert Mehl , wenn sich Corn im Speicher befindet und lagert es ein
	 */
	@Override
	public void produce() {
		if (!(this.getStorage() == null) && this.getStorage().equals(this.getProcessibleProduct())){
			Product Flour = new Product ("Flour");
			this.setStorage(Flour);
		}				
	}
		
}
