package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * The ProductsGUI class provides a graphical user interface for managing products.
 * It includes functionalities to add, edit, delete, and view products.
 */
public class ProductsGUI {
    Font myFont = new Font("Courier",Font.ITALIC, 15);
    JFrame myFrame, productAdd, productEdit, productDelete, productView;
    JButton add, edit, delete, viewAll;
    JLabel name1, quantity1, price1;
    JTextField name1Field, quantity1Field, price1Field;
    JButton add1;
    JLabel id2, name2, quantity2, price2;
    JComboBox<String> idSelect;
    String[] ids;
    JTextField name2Field, quantity2Field, price2Field;
    JButton edit2;
    JLabel id3;
    JComboBox<String> idSelect3;
    JLabel name3, quantity3, price3;
    JLabel name3Field, quantity3Field, price3Field;
    JButton delete3;
    JTable productsTable;
    String[][] tableData;
    ProductsGUI(){
        myFrame = new JFrame("Products Management");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(300,400);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        add = new JButton("Add product");
        add.setFont(myFont);
        add.setFocusable(false);
        add.setBackground(new java.awt.Color(255,153,255));
        add.setBounds(70,30,150,50);
        myFrame.add(add);

        edit = new JButton("Edit product");
        edit.setFont(myFont);
        edit.setFocusable(false);
        edit.setBackground(new java.awt.Color(255,153,255));
        edit.setBounds(70, 100,150, 50);
        myFrame.add(edit);

        delete = new JButton("Delete product");
        delete.setFont(myFont);
        delete.setFocusable(false);
        delete.setBackground(new java.awt.Color(255,153,255));
        delete.setBounds(70, 170,150, 50);
        myFrame.add(delete);

        viewAll = new JButton("View all products");
        viewAll.setFont(myFont);
        viewAll.setFocusable(false);
        viewAll.setBackground(new java.awt.Color(255,153,255));
        viewAll.setBounds(60, 240,170, 50);
        myFrame.add(viewAll);

        myFrame.setVisible(true);
    }
    public void addProduct()
    {
        productAdd = new JFrame("Add Product");
        productAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productAdd.setSize(400,300);
        productAdd.setLayout(null);
        productAdd.setLocationRelativeTo(null);
        productAdd.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        name1 = new JLabel("Name: ");
        name1.setBounds(50, 30,150,25);
        name1.setFont(myFont);
        productAdd.add(name1);

        name1Field = new JTextField();
        name1Field.setBounds(180, 30, 150, 25);
        name1Field.setFont(myFont);
        productAdd.add(name1Field);

        quantity1 = new JLabel("Quantity: ");
        quantity1.setBounds(50, 60,150,25);
        quantity1.setFont(myFont);
        productAdd.add(quantity1);

        quantity1Field = new JTextField();
        quantity1Field.setBounds(180, 60, 150, 25);
        quantity1Field.setFont(myFont);
        productAdd.add(quantity1Field);

        price1 = new JLabel("Price: ");
        price1.setBounds(50,90,150,25);
        price1.setFont(myFont);
        productAdd.add(price1);

        price1Field = new JTextField();
        price1Field.setBounds(180,90,150,25);
        price1Field.setFont(myFont);
        productAdd.add(price1Field);

        add1 = new JButton("Add");
        add1.setFont(myFont);
        add1.setFocusable(false);
        add1.setBackground(new java.awt.Color(255,153,255));
        add1.setBounds(130, 160,150, 50);
        productAdd.add(add1);

        productAdd.setVisible(true);

    }
    public void editProduct()
    {
        productEdit = new JFrame("Edit Product");
        productEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productEdit.setSize(400,300);
        productEdit.setLayout(null);
        productEdit.setLocationRelativeTo(null);
        productEdit.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        id2 = new JLabel("ID: ");
        id2.setBounds(50,30,150,25);
        id2.setFont(myFont);
        productEdit.add(id2);

        idSelect = new JComboBox<>(ids);
        idSelect.setBounds(180, 30,150, 25);
        idSelect.setFont(myFont);
        productEdit.add(idSelect);

        name2 = new JLabel("Name: ");
        name2.setBounds(50, 60,150,25);
        name2.setFont(myFont);
        productEdit.add(name2);

        name2Field = new JTextField();
        name2Field.setBounds(180, 60, 150, 25);
        name2Field.setFont(myFont);
        productEdit.add(name2Field);

        quantity2 = new JLabel("Quantity: ");
        quantity2.setBounds(50, 90,150,25);
        quantity2.setFont(myFont);
        productEdit.add(quantity2);

        quantity2Field = new JTextField();
        quantity2Field.setBounds(180, 90, 150, 25);
        quantity2Field.setFont(myFont);
        productEdit.add(quantity2Field);

        price2 = new JLabel("Price: ");
        price2.setBounds(50,120,150,25);
        price2.setFont(myFont);
        productEdit.add(price2);

        price2Field = new JTextField();
        price2Field.setBounds(180,120,150,25);
        price2Field.setFont(myFont);
        productEdit.add(price2Field);

        edit2 = new JButton("Edit");
        edit2.setFont(myFont);
        edit2.setFocusable(false);
        edit2.setBackground(new java.awt.Color(255,153,255));
        edit2.setBounds(130, 190,150, 50);
        productEdit.add(edit2);

        productEdit.setVisible(true);

    }
    public void deleteProduct()
    {
        productDelete = new JFrame("Delete Product");
        productDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productDelete.setSize(400,300);
        productDelete.setLayout(null);
        productDelete.setLocationRelativeTo(null);
        productDelete.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        id3 = new JLabel("ID: ");
        id3.setBounds(50,30,150,25);
        id3.setFont(myFont);
        productDelete.add(id3);

        idSelect3 = new JComboBox<>(ids);
        idSelect3.setBounds(180, 30,150, 25);
        idSelect3.setFont(myFont);
        productDelete.add(idSelect3);

        name3 = new JLabel("Name: ");
        name3.setBounds(50, 60,150,25);
        name3.setFont(myFont);
        productDelete.add(name3);

        name3Field = new JLabel("");
        name3Field.setBounds(180, 60, 150, 25);
        name3Field.setFont(myFont);
        productDelete.add(name3Field);

        quantity3 = new JLabel("Quantity: ");
        quantity3.setBounds(50, 90,150,25);
        quantity3.setFont(myFont);
        productDelete.add(quantity3);

        quantity3Field = new JLabel("");
        quantity3Field.setBounds(180, 90, 150, 25);
        quantity3Field.setFont(myFont);
        productDelete.add(quantity3Field);

        price3 = new JLabel("Price: ");
        price3.setBounds(50,120,150,25);
        price3.setFont(myFont);
        productDelete.add(price3);

        price3Field = new JLabel("");
        price3Field.setBounds(180,120,150,25);
        price3Field.setFont(myFont);
        productDelete.add(price3Field);

        delete3 = new JButton("Delete");
        delete3.setFont(myFont);
        delete3.setFocusable(false);
        delete3.setBackground(new java.awt.Color(255,153,255));
        delete3.setBounds(130, 190,150, 50);
        productDelete.add(delete3);

        productDelete.setVisible(true);

    }
    public void viewProducts()
    {
        productView = new JFrame("View products");
        productView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productView.setSize(500,500);
        productView.setLocationRelativeTo(null);
        productView.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        String[] columnNames = {"Name", "Quantity", "Price"};
        productsTable = new JTable(tableData, columnNames);
        productsTable.setBackground(new java.awt.Color(255, 204, 255));
        productsTable.setBounds(30,40,200,300);
        JScrollPane scrollPane = new JScrollPane(productsTable);
        productView.add(scrollPane);

        productView.setVisible(true);
    }
}
