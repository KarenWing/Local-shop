/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalShop;

import glos.IO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Karen
 */
public class LocalShop {

    public static void main(String[] arg) {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://projects01.glos.ac.uk/ct5005_12f?"
                    + "user=ct5005-12f&password=J5f8drUw");
            Statement stmt = con.createStatement();

            int menu;
            //set exit to 2, so while loop is implemented
            int exit = 2;
            while (exit == 2) {
                //menu
                menu = IO.readInt("Do you want to:" + "\n"
                        + "1. Add Product" + "\n"
                        + "2. Delete Product" + "\n"
                        + "3. View Products" + "\n"
                        + "4. Search" + "\n");

                while (menu < 1 || menu > 4) {
                    menu = IO.readInt("Please choose an option 1-4" + "\n"
                            + "1. Add Product" + "\n"
                            + "2. Delete Product" + "\n"
                            + "3. View Products" + "\n"
                            + "4. Search" + "\n");
                }

                switch (menu) {
                    //add
                    case 1:
                        int add;
                        add = IO.readInt("Do you want to add:" + "\n"
                                + "1.Add Food" + "\n"
                                + "2.Add Drink" + "\n"
                                + "3.Add Miscellaneous");
                        while (add < 1 || add > 3) {
                            add = IO.readInt("Please choose an option 1-3" + "\n"
                                    + "1.Add Food" + "\n"
                                    + "2.Add Drink" + "\n"
                                    + "3.Add Miscellaneous");
                        }
                        switch (add) {
                            case 1:
                                Food.productName = IO.readString("Enter product name");
                                Food.price = IO.readDouble("Enter price");
                                Food.weight = IO.readDouble("Enter weight");
                                Food.packOf = IO.readInt("Enter amount in pack");
                                Food.storageFormat = IO.readString("Enter storage format");

                                String insertQuery = "INSERT INTO Food VALUES (NULL, '" + Food.productName + "' , '" + Food.price
                                        + "' , '" + Food.weight + "' , '" + Food.packOf + "' , '" + Food.storageFormat + "')";
                                System.out.println("Record added");
                                System.out.println(insertQuery);
                                stmt.execute(insertQuery);

                                break;
                            case 2:
                                Drinks.productName = IO.readString("Enter product name");
                                Drinks.price = IO.readDouble("Enter price");
                                Drinks.weight = IO.readDouble("Enter weight");
                                Drinks.packOf = IO.readInt("Enter amount in pack");
                                Drinks.type = IO.readString("Enter type of drink");
                                Drinks.idRequired = IO.readInt("Is ID required: " + "\n" + "Enter 0 if No" + "\n" + "Enter 1 if Yes");

                                insertQuery = "INSERT INTO Drinks VALUES (NULL, '" + Drinks.productName + "' , '" + Drinks.price
                                        + "' , '" + Drinks.weight + "' , '" + Drinks.packOf + "' , '" + Drinks.type + "' , '" + Drinks.idRequired + "')";
                                System.out.println("Record added");
                                System.out.println(insertQuery);
                                stmt.execute(insertQuery);

                                break;
                            case 3:
                                Misc.productName = IO.readString("Enter product name");
                                Misc.price = IO.readDouble("Enter price");
                                Misc.weight = IO.readDouble("Enter weight");
                                Misc.packOf = IO.readInt("Enter amount in pack");
                                Misc.ageRestriction = IO.readInt("Enter ageRestriction (Enter 0 if no restriction)");

                                insertQuery = "INSERT INTO Misc VALUES (NULL, '" + Misc.productName + "' , '" + Misc.price
                                        + "' , '" + Misc.weight + "' , '" + Misc.packOf + "' , '" + Misc.ageRestriction + "')";
                                System.out.println("Record added");
                                System.out.println(insertQuery);
                                stmt.execute(insertQuery);

                                break;
                        }
                        break;
                    //delete  
                    case 2:
                        int delete;
                        delete = IO.readInt("Do you want delete:" + "\n"
                                + "1.A Food product" + "\n"
                                + "2.A Drink" + "\n"
                                + "3.A Miscellaneous product");
                        while (delete < 1 || delete > 3) {
                            delete = IO.readInt("Choose an option 1-3:" + "\n"
                                    + "1.A Food product" + "\n"
                                    + "2.A Drink" + "\n"
                                    + "3.A Miscellaneous product");
                        }
                        switch (delete) {

                            case 1:
                                int del = IO.readInt("Enter the id of product you want to delete");
                                String deleteQuery = "DELETE FROM Food where id = '" + del + "'";

                                System.out.println("Record deleted");
                                System.out.println(deleteQuery);
                                stmt.execute(deleteQuery);
                                break;
                            case 2:
                                del = IO.readInt("Enter the id of product you want to delete");
                                deleteQuery = "DELETE FROM Drinks where id = '" + del + "'";

                                System.out.println("Record deleted");
                                System.out.println(deleteQuery);
                                stmt.execute(deleteQuery);
                                break;
                            case 3:
                                del = IO.readInt("Enter the id of product you want to delete");
                                deleteQuery = "DELETE FROM Misc where id = '" + del + "'";

                                System.out.println("Record deleted");
                                System.out.println(deleteQuery);
                                stmt.execute(deleteQuery);
                                break;
                        }
                        break;
                    case 3:
                        //view
                        int view;
                        view = IO.readInt("Do you want view:" + "\n"
                                + "1.View Foods" + "\n"
                                + "2.View Drinks" + "\n"
                                + "3.View Miscellaneous");
                        while (view < 1 || view > 3) {
                            view = IO.readInt("Choose an option 1-3" + "\n"
                                    + "1.View Foods" + "\n"
                                    + "2.View Drinks" + "\n"
                                    + "3.View Miscellaneous");
                        }
                        switch (view) {
                            case 1:
                                // code to show all records from database
                                ResultSet rs = stmt.executeQuery("SELECT * FROM Food");

                                while (rs.next()) {

                                    String id = rs.getString("id");
                                    Food.productName = rs.getString("productName");
                                    Food.price = rs.getInt("price");
                                    Food.weight = rs.getInt("weight");
                                    Food.packOf = rs.getInt("packOf");
                                    Food.storageFormat = rs.getString("storageFormat");

                                    String result = (id + "\t" + Food.productName + "\t" + Food.price + "\t" + Food.weight + "\t" + Food.packOf + "\t" + Food.storageFormat);
                                    Item food = new Food(Food.productName, Food.price, Food.weight, Food.packOf, Food.storageFormat);
                                    food.print();
                                }
                                break;
                            case 2:
                                rs = stmt.executeQuery("SELECT * FROM Drinks");

                                while (rs.next()) {

                                    String id = rs.getString("id");
                                    Drinks.productName = rs.getString("productName");
                                    Drinks.price = rs.getInt("price");
                                    Drinks.weight = rs.getInt("weight");
                                    Drinks.packOf = rs.getInt("packOf");
                                    Drinks.type = rs.getString("type");
                                    Drinks.idRequired = rs.getInt("idRequired");

                                    String result = (id + "\t" + Drinks.productName + "\t" + Drinks.price + "\t" + Drinks.weight + "\t" + Drinks.packOf + "\t" + Drinks.type + "\t" + Drinks.idRequired);
                                    Item drinks = new Drinks(Drinks.productName, Drinks.price, Drinks.weight, Drinks.packOf, Drinks.type, Drinks.idRequired);
                                    drinks.print();
                                }
                                break;
                            case 3:
                                rs = stmt.executeQuery("SELECT * FROM Misc");

                                while (rs.next()) {

                                    String id = rs.getString("id");
                                    Misc.productName = rs.getString("productName");
                                    Misc.price = rs.getInt("price");
                                    Misc.weight = rs.getInt("weight");
                                    Misc.packOf = rs.getInt("packOf");
                                    Misc.ageRestriction = rs.getInt("ageRestriction");

                                    String result = (id + "\t" + Misc.productName + "\t" + Misc.price + "\t" + Misc.weight + "\t" + Misc.packOf + "\t" + Misc.ageRestriction);
                                    Item misc = new Misc(Misc.productName, Misc.price, Misc.weight, Misc.packOf, Misc.ageRestriction);
                                    misc.print();
                                }
                                break;
                        }
                        break;
                    //search
                    case 4:
                        int search;
                        search = IO.readInt("Do you want view:" + "\n"
                                + "1.View Foods" + "\n"
                                + "2.View Drinks" + "\n"
                                + "3.View Miscellaneous");
                        while (search < 1 || search > 3) {

                            search = IO.readInt("Choose an option 1-3" + "\n"
                                    + "1.View Foods" + "\n"
                                    + "2.View Drinks" + "\n"
                                    + "3.View Miscellaneous");

                        }
                        switch (search) {
                            //search food
                            case 1:
                                int foodSearch = IO.readInt("Enter the id you wish to search for");
                                ResultSet rs = stmt.executeQuery("SELECT * FROM Food WHERE id ='" + foodSearch + "'");
                                while (rs.next()) {

                                    String id = rs.getString("id");
                                    Food.productName = rs.getString("productName");
                                    Food.price = rs.getInt("price");
                                    Food.weight = rs.getInt("weight");
                                    Food.packOf = rs.getInt("packOf");
                                    Food.storageFormat = rs.getString("storageFormat");

                                    String result = (id + "\t" + Food.productName + "\t" + Food.price + "\t" + Food.weight + "\t" + Food.packOf + "\t" + Food.storageFormat);
                                    Item food = new Food(Food.productName, Food.price, Food.weight, Food.packOf, Food.storageFormat);
                                    food.print();
                                }
                                break;
                            //seacrh drinks
                            case 2:
                                int drinkSearch = IO.readInt("Enter the id you wish to search for");

                                rs = stmt.executeQuery("SELECT * FROM Drinks WHERE id ='" + drinkSearch + "'");
                                while (rs.next()) {

                                    String id = rs.getString("id");
                                    Drinks.productName = rs.getString("productName");
                                    Drinks.price = rs.getInt("price");
                                    Drinks.weight = rs.getInt("weight");
                                    Drinks.packOf = rs.getInt("packOf");
                                    Drinks.type = rs.getString("type");
                                    Drinks.idRequired = rs.getInt("idRequired");

                                    String result = (id + "\t" + Drinks.productName + "\t" + Drinks.price + "\t" + Drinks.weight + "\t" + Drinks.packOf + "\t" + Drinks.type + "\t" + Drinks.idRequired);
                                    Item drinks = new Drinks(Drinks.productName, Drinks.price, Drinks.weight, Drinks.packOf, Drinks.type, Drinks.idRequired);
                                    drinks.print();
                                }
                                break;
                            //search misc    
                            case 3:
                                int miscSearch = IO.readInt("Enter the id you wish to search for");

                                rs = stmt.executeQuery("SELECT * FROM Misc WHERE id ='" + miscSearch + "'");
                                while (rs.next()) {
                                    String id = rs.getString("id");
                                    Misc.productName = rs.getString("productName");
                                    Misc.price = rs.getInt("price");
                                    Misc.weight = rs.getInt("weight");
                                    Misc.packOf = rs.getInt("packOf");
                                    Misc.ageRestriction = rs.getInt("ageRestriction");

                                    String result = (id + "\t" + Misc.productName + "\t" + Misc.price + "\t" + Misc.weight + "\t" + Misc.packOf + "\t" + Misc.ageRestriction);
                                    Item misc = new Misc(Misc.productName, Misc.price, Misc.weight, Misc.packOf, Misc.ageRestriction);
                                    misc.print();
                                }
                                break;
                        }
                        break;
                }
                //End of each process ask user if they want to exit and go back to the main menu
                exit = IO.readInt("1.Exit" + "\n" + "2.Main Menu");
                //exits if user enters one
                if (exit == 1) {
                    System.exit(0);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}