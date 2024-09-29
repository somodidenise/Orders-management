package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * The View class provides the main graphical user interface for the Orders Management System.
 * It includes options to manage clients, products, and create new orders.
 */
public class View {
    Font myFont = new Font("Courier",Font.ITALIC, 15);
    JFrame myFrame;
    JButton clients, products, orders;
    JLabel label1;
    View(){
        myFrame = new JFrame("Orders Management System");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(540,250);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        label1 = new JLabel("Select one: ");
        label1.setBounds(200, 30,150,25);
        label1.setFont(myFont);
        myFrame.add(label1);

        clients = new JButton("Clients");
        clients.setFont(myFont);
        clients.setFocusable(false);
        clients.setBackground(new java.awt.Color(255,153,255));
        clients.setBounds(60,100,100,50);
        myFrame.add(clients);

        products = new JButton("Products");
        products.setFont(myFont);
        products.setFocusable(false);
        products.setBackground(new java.awt.Color(255,153,255));
        products.setBounds(190, 100,100, 50);
        myFrame.add(products);

        orders = new JButton("New order");
        orders.setFont(myFont);
        orders.setFocusable(false);
        orders.setBackground(new java.awt.Color(255,153,255));
        orders.setBounds(320, 100,150, 50);
        myFrame.add(orders);

        myFrame.setVisible(true);
    }

}
