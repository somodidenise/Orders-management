package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * The OrderGUI class provides a graphical user interface for managing orders.
 * It includes functionalities to select a client, select a product, specify the desired quantity,
 * and confirm the order while handling insufficient stock scenarios.
 */

public class OrderGUI {
    Font myFont = new Font("Courier",Font.ITALIC, 15);
    JFrame myFrame;
    JButton confirm;
    JLabel selectClient, selectProduct, selectQuantity, insufficientStock;
    String[] idsClient, idsProduct;
    JComboBox<String> clients, products;
    JTextField quantity;
    OrderGUI(){
        myFrame = new JFrame("Order Management");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(300,400);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        selectClient = new JLabel("Select client: ");
        selectClient.setBounds(100, 30,150,25);
        selectClient.setFont(myFont);
        myFrame.add(selectClient);

       /* clients = new JComboBox<>(idsClient);
        clients.setBounds(70, 70,150, 25);
        clients.setFont(myFont);
        myFrame.add(clients);*/

        selectProduct = new JLabel("Select product: ");
        selectProduct.setBounds(90, 110,150,25);
        selectProduct.setFont(myFont);
        myFrame.add(selectProduct);

      /*  products = new JComboBox<>(idsProduct);
        products.setBounds(70, 150,150, 25);
        products.setFont(myFont);
        myFrame.add(products);*/

        selectQuantity = new JLabel("Quantity desired: ");
        selectQuantity.setBounds(90, 190,150,25);
        selectQuantity.setFont(myFont);
        myFrame.add(selectQuantity);

        quantity = new JTextField();
        quantity.setBounds(70, 230, 150, 25);
        quantity.setFont(myFont);
        myFrame.add(quantity);

        confirm  = new JButton("Confirm");
        confirm.setFont(myFont);
        confirm.setFocusable(false);
        confirm.setBackground(new java.awt.Color(255,153,255));
        confirm.setBounds(70, 270,150, 50);
        myFrame.add(confirm);

        insufficientStock = new JLabel("Insufficient stock!");
        insufficientStock.setVisible(false);
        insufficientStock.setBounds(80, 330,150,25);
        insufficientStock.setFont(myFont);
        myFrame.add(insufficientStock);

        //myFrame.setVisible(true);
    }
    public void addComboBoxes()
    {
        clients = new JComboBox<>(idsClient);
        clients.setBounds(70, 70,150, 25);
        clients.setFont(myFont);
        myFrame.add(clients);
        products = new JComboBox<>(idsProduct);
        products.setBounds(70, 150,150, 25);
        products.setFont(myFont);
        myFrame.add(products);
        myFrame.setVisible(true);

    }
    public void insufficientStock(){
        insufficientStock.setVisible(true);
        myFrame.repaint();
    }
    public void insufficientStockFalse(){
        insufficientStock.setVisible(false);
        myFrame.repaint();
    }
}
