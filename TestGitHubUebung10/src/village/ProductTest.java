package village;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Louis Kr�ger
 *
 */
public class ProductTest {


	Product p1 = new Product ("TEST");
	Product p2 = new Product ("TEST");
	
	
	@Test
	/**
	 * Test f�r Equals-Methode
	 */
	public void test1 (){
		assertEquals(p1, p2);
		
	}
	
	 @Test
	 /**
	  * Test f�r Equals-Methode
	  */
	 public void test2 () {
		 assertFalse(p1==p2);  
		 
		 
		 /**
		  * ERKL�RUNG
		  * mit der normalen equals (object == object) Methode wird nur der hashcode verglichen
		  * --> Objekte sind aber nicht so trivial vergleichbar
		  * <-->es ist nur der gleiche Hashcode, wenn es sich um das selbe Objekt handelt (deswegen test2 = false)
		  * 
		  * man schreibt die Methode Equal der Klasse Object so um, dass
		  * auch ein true ausgegeben wird, wenn die Objekte die gleichen Attribute haben!!
		  * 
		  * Es ist egal, was f�r ein Brot es ist (wo es gespeichert ist).. hauptsache ein Objekt Brot (gleiche Attribute)!
		  * 
		  */
		 
		 
	 }
}

