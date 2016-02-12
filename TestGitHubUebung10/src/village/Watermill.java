/**
 * 
 */
package village;

/**
 * @author Louis Krüger
 *
 */
public class Watermill extends Mill {

	//Attribute
	
	double waterSpeed;
	
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Watermill
	 * @param aName Name der Wassermühle
	 * @param Speed aktuelle Wassergeschwindigkeit
	 */
	public Watermill(String aName, double Speed) {
		super(aName);
		waterSpeed = Speed;
		if (waterSpeed < 0.1) throw new IllegalArgumentException("Die Mindestgeschwindigkeit des Wassers muss mindestens 0.1 betragen. Eingegeben: " + waterSpeed);
	}

	
	//Methoden
	
	/**
	 * Berechnet die Produktionszeit für Mehl bei gegebener Wassergeschwindigkeit
	 */
	@Override
	public double productionTime() {
		return  0.5 * (1/this.waterSpeed);
	}

}
