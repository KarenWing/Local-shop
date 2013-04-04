/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalShop;

import glos.IO;
import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author s1102312
 */
public class Actions extends JFrame 
{
    private String isSelected = "selected"; 
    
    private JButton addProduct = new JButton("Add Product");
    private JButton editProduct = new JButton("Edit Product");
    private JButton deleteProduct = new JButton("Delete Product");
    private JTextArea displayArea1 = new JTextArea(8, 45);
    
    
    private  JPanel addPanel1 = new JPanel();
    private  JPanel addPanel2 = new JPanel();
    private  JPanel addPanel3 = new JPanel();
    boolean addPanelVisible = false;
    private JTextArea displayArea2 =  new JTextArea(8,45);
    
    private  JTextField nameField =  new JTextField(20);
    private  JTextField priceField =  new JTextField(10);
    private  JTextField weightField =  new JTextField(10);
    private  JTextField packOfField =  new JTextField(5);
    
    private  JTextField storageField =  new JTextField(10);
    private JButton addFood = new JButton("Add Food");
    
    private  JTextField typeField =  new JTextField(10);
    private  JTextField idField =  new JTextField(10);
    private JButton addDrinks = new JButton("Add Drinks");
    
    private  JTextField ageField =  new JTextField(10);
    private JButton addMisc = new JButton("Add Miscellaneous");
    
    private JButton editFood = new JButton("Edit Food");
    private JButton editDrinks = new JButton("Edit Drinks");
    private JButton editMisc = new JButton("Edit Miscellaneous");
    private JButton deleteFood = new JButton("Add Food");
    private JButton deleteDrinks = new JButton("Add Drinks");
    private JButton deleteMisc = new JButton("Add Miscellaneous");
    private JButton searchProduct = new JButton("Search");
    

    public Actions() 
            //throws Exception 
    {
        add(addProduct);
        add(editProduct);
        add(deleteProduct);
        add(searchProduct);
        addProduct.setBackground(Color.green);
        
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Local Shop");
        setSize(550, 450);
        setLocation(400, 100);
        getContentPane().setBackground(Color.cyan);

        displayArea1.setBorder(new TitledBorder(new LineBorder(Color.black),
                "Products", TitledBorder.CENTER, TitledBorder.TOP));

        setVisible(true);
        
        class OpenAddListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                addPanelVisible = !addPanelVisible;
                addPanel1.setVisible(addPanelVisible);
                        addPanel2.setVisible(addPanelVisible);
                        addPanel3.setVisible(addPanelVisible);
                if (addPanelVisible)
                {
                    setSize(550, 600);
                } 
                else
                {
                    setSize(550, 300);
                }
            }
        }
        ActionListener addListener = new OpenAddListener();
		addProduct.addActionListener(addListener);

        // enable the buttons to listen for a mouse-click
        class AddProductButton implements ActionListener 
        {
            //event handler

            Connection con = null;

        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addProduct) 
                { 
                    
                    addPanel1.add(nameField);
                    nameField.setBorder(new TitledBorder("Name"));
                    addPanel1.add(priceField);
                    priceField.setBorder(new TitledBorder("Price"));
                    addPanel1.add(weightField);
                    addPanel1.add(packOfField);
                    addPanel1.add(storageField);
                    addPanel1.add(addFood);
                    addPanel1.setBackground(Color.LIGHT_GRAY);
                    addPanel1.setLocation(0, 200);

                    addPanel2.add(addDrinks);
                    addPanel2.add(nameField);
                    addPanel2.add(priceField);                
                    addPanel2.add(weightField);
                    addPanel2.add(packOfField);
                    addPanel2.add(typeField);
                    addPanel2.add(idField);
                    addPanel2.setBackground(Color.LIGHT_GRAY);
                    addPanel1.setLocation(0, 300);

                    addPanel3.add(addMisc);
                    addPanel3.add(nameField);
                    addPanel3.add(priceField);                
                    addPanel3.add(weightField);
                    addPanel3.add(packOfField);
                    addPanel3.add(ageField);
                    addPanel3.setBackground(Color.LIGHT_GRAY);
                    addPanel1.setLocation(0, 400);
                    
                    displayArea2.setBorder(new TitledBorder(new LineBorder(Color.black),
				"Add Products",TitledBorder.CENTER,TitledBorder.TOP));
                }
            }
        }//HappyButtonAction
        ActionListener addAction = new AddProductButton();
        addProduct.addActionListener(addAction); 
        
        addPanel1.setVisible(addPanelVisible);
        addPanel2.setVisible(addPanelVisible);
        addPanel2.setVisible(addPanelVisible);

		add(addPanel1,BorderLayout.SOUTH);
                add(addPanel2,BorderLayout.SOUTH);
                add(addPanel3,BorderLayout.SOUTH);
		// make GUI visible
		setVisible(true);
    }
}
