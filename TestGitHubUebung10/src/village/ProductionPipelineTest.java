
package village;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Louis Krüger
 *
 */
public class ProductionPipelineTest {

	// deklariere Testobjekte
	private Farm farm1;
	private Farm farm2;
	private Watermill watermill;
	private Windmill windmill;
	private Bakery bakeryNo1;
	private Bakery bakeryNo2;
	private Plant [] plants1;
	private Plant [] plants2;
	private Plant [] plants3;
	private ProductionPipeline line1;
	private ProductionPipeline line2;
	private ProductionPipeline line3;
	private Product Bread;
	private Product Corn;
	
	
	@Before
	public void BaueReihe (){
	farm1 = new Farm ("Farm1",5,false);
	farm2 = new Farm ("Farm2",8,true);
	watermill = new Watermill ("watermill", 0.5);
	windmill = new Windmill ("windmill", 0.2);
	bakeryNo1 = new Bakery ("bakeryNo1",4);
	bakeryNo2 = new Bakery ("bakeryNo2",2);
	
	plants1 = new Plant [] {windmill, bakeryNo1};
	plants2 = new Plant [] {farm2, watermill,bakeryNo2};
	plants3 = new Plant [] {farm1};
	
	
	line1 = new ProductionPipeline("line1", plants1);
	line2 = new ProductionPipeline("line2", plants2);
	line3 = new ProductionPipeline("line3", plants3);
	
	Bread = new Product ("Bread");
	Corn = new Product ("Corn");
	}
	
	@Test
	public void produceTest () {
		
		line1.setProcessibleProduct(Corn); //soll laut Aufgabenstellung nicht in den Konstruktor?!Muss per Hand zugewiesen werden, wenn erster Betrieb keine Farm ist!
		line1.produce();
		
		assertEquals(Bread, line1.getStorage());
		line2.produce();
		assertEquals(Bread, line2.getStorage());
		line3.produce();
		assertEquals(Corn, line3.getStorage());
		
		
		
	}
	
	
	@Test
	public void productionTimeTest() {
		
		line1.setProcessibleProduct(Corn); //soll laut Aufgabenstellung nicht in den Konstruktor?!Muss per Hand zugewiesen werden, wenn erster Betrieb keine Farm ist!
		line1.produce();			
		
		assertEquals(5.25,line1.productionTime(),0.0001);
		line2.produce();
		assertEquals(4, line2.productionTime(), 0.0001);
		line3.produce();
		assertEquals(2.0, line3.productionTime(), 0.0001);
		
	}
	
	
	


}
