/**
 * 
 */
package village;

/**
 * @author Louis Krüger
 *
 */
public class Windmill extends Mill {

	
	//Attribute
	
	double windSpeed;
	
	
	//Konstruktor
	
	/**
	 * Erstellt eine Instanz der Klasse Windmill
	 * @param aName Name der Windmühle
	 * @param Speed Aktuelle Windgeschwindigkeit
	 */
	public Windmill(String aName, double Speed) {
		super(aName);	
		windSpeed = Speed;
		if (windSpeed < 0.1) throw new IllegalArgumentException("Die Mindestgeschwindigkeit des Windes muss mindestens 0.1 betragen. Eingegeben: " + windSpeed);

	}
	
	/**
	 * Berechnet die Produktionszeit für Mehl bei gegebener Windgeschwindigkeit
	 */
	@Override
	public double productionTime() {
		return 1/this.windSpeed;
		
	}

}
