/*
 * Stores attributes for Miscellaneous
 */
package LocalShop;

import glos.IO;

/**
 *
 * @author Karen
 */

public class Misc extends Item {
	public static int ageRestriction;
	public Misc(String productName, double price, double weight, int packOf, int ageRestriction) {
	
            super (productName , price, weight, packOf);
	}
	
	public int getAgeRestriction() {
	
            return ageRestriction;
	}
	
	public void setAgeRestriction(int age) {
	
            ageRestriction = age;
	}
	
	@Override
	public void print() {
            super.print();
            
            System.out.println("Age Restriction: " + ageRestriction);
	
	}
}
