/*
 * Stores all attributes that are common
 */
package LocalShop;

import glos.IO;

/**
 *
 * @author Karen
 */
public class Item {
	public static String productName;
	public static double price;
	public static double weight;
	public static int packOf;
        
	public Item(String productName, double price, double weight, int packOf) {
            this.productName = productName;
            this.price = price;
            this.weight = weight;
            this.packOf = packOf;
	
	}
	
	public String getProductName() {
	
            return productName;
	}
	
	public void setProductName(String name) {
            
	}
	
	public double getPrice() {
            
            return price;
	}
	
	public void setPrice(double itemPrice) {
	
	}
	
	public double getWeight() {
	
            return weight;
            
	}
	
	public void setWeight(double itemWeight) {
	
	}
	
	public int getPackOf() {
	
            return packOf;
	}
	
	public void setPackOf(int itemPackOf) {
	
	}
        public void print() {
            
            System.out.println("Product Name: " + productName);
            System.out.println("Price: £" + price);
            System.out.println("Weight: " + weight +"g/ml");
            System.out.println("Product is a pack of " + packOf);
            
            //IO.display("Product Name: " + productName + "Price: £" + price + "Weight: " + 
                 //weight +"g/ml" + "Product is a pack of " + packOf);
            
	
	}
}

