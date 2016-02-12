package village;

/**
 * @author Louis Krüger
 *
 */
public abstract class Plant {
	
	//Attribute
	String name;
	Product storage; 
	Product processibleProduct; 
	
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Plant
	 * @param aName Name der Instanz
	 */
	public Plant (String aName){
		this.name = aName;
	}

	
	//Getter/Setter
	
	/**
	 * Get-Methode des Speichers
	 * @return Objekt des Speichers
	 */
	public Product getStorage() {
		return storage;
	}

	/**
	 * Set-Methode des Speichers
	 * @param storage beliebiges Product
	 */
	public void setStorage(Product storage) {
		this.storage = storage;
	}

	/**
	 * Get-Methode des ProcessibleProduct
	 * @return Product welches der Betrieb verarbeiten kann
	 */
	public Product getProcessibleProduct() {
		return processibleProduct;
	}

	/**
	 * Set-Methode des processibleProduct 
	 * @param processibleProduct ein Product, welches der Betrieb verarbeiten kann
	 */
	public void setProcessibleProduct(Product processibleProduct) {
		this.processibleProduct = processibleProduct;
	}

	/**
	 * Get-Methode des Namens
	 * @return der Name des Betriebs
	 */
	public String getName() {
		return name;
	}
	
	
	
	//Methoden
		
	/**
	 * Überprüft, ob Betrieb eingegebens Produkt verarbeiten kann
	 * @param prod beliebiges Produkt
	 * @return true/false
	 */
	public boolean canProcess (Product prod) {	
		if (this.getProcessibleProduct().equals(prod)) 
			return true;
			return false;	
	}
	
	/**
	 * Legt eingegebens Produkt im Speicher des Betriebes ab, wenn der Betrieb es verarbeiten kann
	 * @param prod beliebiges Produkt
	 */
	public void receive (Product prod){
		if (canProcess(prod))
		this.setStorage(prod);
	}
	
	/**
	 * Entfernt Produkt aus Lager und liefert es an einen beliebigen Betrieb aus (schreibt es dort in den Speicher)
	 * @param aPlant ein beliebiger Betrieb
	 */
	public void deliver(Plant aPlant){
		 aPlant.setStorage(this.getStorage()); //Achtung: ggf werden vorhandene Produkte überschrieben, ABER in Aufgabenstellung nicht verlangt diesen Fall abzufangen
		 this.setStorage(null);
		
	}
	
	/**
	 * Abstrakte produce Methode --> Je nach Betrieb unterschiedliche Implementierung.
	 * Ein Betrieb soll etwas produzieren
	 */
	public abstract void produce();  
	
	
	/**
	 * Abstrakte ProductionTime Methode --> jeder Betrieb berechnet Produktionszeit anders.
	 * Produktionszeit wird berechnet!
	 * @return Produktionszeit (Typ: double)
	 */
	public abstract double productionTime (); 
		
	
	
	
	

}
