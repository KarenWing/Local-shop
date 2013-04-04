/*
 * Stores attributes for food
 */
package LocalShop;

import glos.IO;
/**
 *
 * @author Karen
 */
public class Food extends Item {
	public static String storageFormat;
	public Food(String productName, double price, double weight, int packOf, String storageFormat) {
            
            super (productName , price, weight, packOf);
            this.storageFormat = storageFormat;
	}
	
	public String getStorageFormat() {
            return storageFormat;
	
	}
	
	public void setStorageFormat(String fstorageFormat) {
	
            storageFormat = fstorageFormat;
	}
        @Override
	public void print() {
            super.print();
            
            System.out.println("Storage format: " + storageFormat + "\n");
            //IO.display("Storage format: " + storageFormat);
	
	}
}

