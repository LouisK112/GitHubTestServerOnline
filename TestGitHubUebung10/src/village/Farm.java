package village;

public class Farm extends Plant{

	//Attribute
	double workers;
	boolean locustPlaque; 
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Farm
	 * @param aName Name des Bauernhofs
	 * @param workers Anzahl der Arbeiter dort
	 * @param locustPlaque Gibt es eine Plage?
	 */
	public Farm(String aName,int workers, boolean locustPlaque) {
		super(aName);
		
		//Achtung: keine setProcessibleProduct-Methode nötig! Produziert ohne Vorbedingung! --> Attribut = null
		this.workers = workers;
		this.locustPlaque = locustPlaque;
		if (workers < 1) throw new IllegalArgumentException("Die Anzahl der Arbeiter muss größer 1 sein. Eingegeben: " + workers);
	}
	
	
	//Methoden
	
	/**
	 * Eine Farm produziert Corn und speichert es
	 */
	@Override
	public void produce(){
		Product prod = new Product("Corn");
		this.setStorage(prod);		
	}

	/**
	 * Berechnung der Produktionszeit
	 * @return Produktionszeit
	 */
	@Override
	public double productionTime() {
				if (this.locustPlaque)
					return  (20*(1/this.workers));
					return  (10* (1/this.workers));	
	}
	
	
	/**
	 * Diese Überschreibung erleichtert deutlich die Produce-Methode in ProductionPipeline!
	 * Man kann nicht davon ausgehen, dass der Bauernhof immer an erster Stelle steht, bzw überhaupt vorkommt.
	 * In der for-Schleife in ProductionPipeline kommt es mit der canProcess-Methode der Oberklasse immer zu einer NullPointException, da dass 'processibleProduct' immer null ist.
	 * Da er ohne Bedinung mit leerem Speicher produzieren kann, wird hier immer true ausgegeben.
	 * 
	 * @return true
	 */
	@Override
	public boolean canProcess (Product prod) {	
		return true;	
	}


}
