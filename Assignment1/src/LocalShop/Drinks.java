/*
 * Stores attributes for drinks
 */
package LocalShop;

import glos.IO;

/**
 *
 * @author Karen
 */
public class Drinks extends Item {
	public static String type;
	
        public static int idRequired;
	public Drinks(String productName, double price, double weight, int packOf, String type, int idRequired) {
	
            super (productName , price, weight, packOf);
            this.type = type;
            this.idRequired = idRequired;
	}
	
	public String getType() {
	
            return type;
	}
	
	public void setType(String drinkType) {
	
            type = drinkType;
	}
	
	public int getIdRequired() {
	
            
            return idRequired;
	}
	
	public void setIdRequired(int requireId) {
	
            idRequired = requireId;
	}       
	@Override
	public void print() {
            super.print();
            
            System.out.println("Type of drink: " + type);
            System.out.println("Id required: " + idRequired);
            //IO.display("Type of drink: " + type + "Id required: " + idRequired);
	
	
	}
}

