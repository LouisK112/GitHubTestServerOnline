
package village;

/**
 *  kann man Vererben? Ja!
 * Begrüdnung: 
 * ProductionPipline führt eine Anweisungsreihenfolge von Betrieben aus.
 * Es ist ein Betrieb der Abläufe koordiniert. 
 * Er produziert an sich nichts, aber koordiniert die Zusammenarbeit. 
 * Somit ist es ein "höher gestellter" Betrieb, der die Arbeit von anderen Betrieben koordiniert.  
 * 
 * @author Louis Krüger
 * 
 */
public class ProductionPipeline extends Plant {
	
	// Attribute
	Plant [] chainedPlants;
	
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse ProductionPipeline
	 * @param Name Name der Produktionskette
	 * @param ChainedPlants Array mit Betrieben, die in der gegeben Reihenfolge produzieren
	 */
	public ProductionPipeline(String Name, Plant [] ChainedPlants) {
		super(Name);
		this.chainedPlants = ChainedPlants; 
		if (this.chainedPlants.length == 0) throw new IllegalArgumentException("Die Liste der Betriebe, die produzieren sollen darf nicht leer sein! Eingegeben: " + this.chainedPlants);
	}
	
	
	//Methoden
	
	/**
	 * Produziert das mögliche Endprodukt der Angegeben Betriebe.
	 * Hier habe ich vielleicht sehr viele Fälle abgefangen, allerdings ist es meiner Meinung nach auch notwendig! 
	 * In der Aufgabenstellung steht besipielsweise nicht, dass die Betriebe in der richtigen Reihenfolge sein müssen oder was geschieht, wenn der erste Betrieb kein Bauernhof ist!
	 * Da alles sehr undeutlich formuliert ist habe ich die Variable processibleProduct ausgenutzt, um angeben zu können welches Produkt im Dorf vorhanden ist, sodass man auch Produktionsketten ausführen kann, die nicht mit einem Bauernhof starten (in Realität ist es so)
	 */
	@Override
	public void produce (){

		Farm farm1 = new Farm ("Farm1",1,false);

		if (!(this.chainedPlants[0].getClass().equals(farm1.getClass()))){ //Wenn der erste Betrieb keine Farm ist (nur Farm kann mit leerem Speicher produzieren)			
			
			if (chainedPlants[0].canProcess(this.getProcessibleProduct())) {  //Betrieb kann Produkt der ProductionPipeline verwenden (processibleProduct) [Beispiel im Dorf ist Überschuss an Corn --> dann muss nur die Mühle und die Bäckerei produzieren <--> Mühle bekommt Corn über processibleProdukt Attribut]
				chainedPlants[0].setStorage(this.getProcessibleProduct());  //ja--> setze es in Speicher von Betrieb
			}
			 else throw new IllegalArgumentException("Das Produkt, welches vom ersten Betrieb verarbeitet werden soll, und der Betrieb passen nicht zusammen. Die Produktionskette kann nicht gestartet werden. Überprüfen Sie ihre Reihenfolge der Betriebe oder die setProcessibleStorage Anweisung für die ProductionPipeline! ");
		}
		
		for (int i = 0; i < chainedPlants.length; i++){  //Durchlaufe das Array mit Betrieben
			
			if(chainedPlants[i].canProcess(chainedPlants[i].getStorage())){  //Abfrage, ob Produkt im Speicher überhaupt verwendbar ist (falsch sortierte Firmenliste wird hier nicht weiter abgearbeitet)
				
				if (i < (chainedPlants.length -1)) {  //laufe bis zur vorletzten Firma --> die letzte Firma kann nichts an die Nächste senden!	
					chainedPlants[i].produce();
					chainedPlants[i].deliver(chainedPlants[i+1]);
				} 
				else { //letzter Betrieb nur Produzieren --> nicht schicken --> anschließend Produkt in Lager von Produktionskette schreiben
					chainedPlants[i].produce();
					this.setStorage(chainedPlants[i].getStorage());
				}
			} else throw new IllegalArgumentException("Die Reihenfolge der Betriebe innerhalb der Produktionskette stimmt nicht! Bitte überprüfen sie diese!");
		}	
	}
			
	
	/**
	 * Berechnet die Produktionszeit vom Erstprodukt bis zum Endprodukt
	 * @return Produktionszeit
	 */
	@Override
	public double productionTime () {
		double x = 0.0;
		
		for(int i=0; i < chainedPlants.length; i++) {
			x += chainedPlants[i].productionTime();
		}
		
		return x;
	}
}
