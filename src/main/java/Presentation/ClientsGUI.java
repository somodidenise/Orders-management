package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * The ClientsGUI class provides a graphical user interface for managing clients.
 * It includes functionalities to add, edit, delete, and view clients.
 */
public class ClientsGUI {
    Font myFont = new Font("Courier",Font.ITALIC, 15);
    JFrame myFrame, clientAdd, clientEdit, clientDelete, clientView;
    JButton add, edit, delete, viewAll;
    JLabel name1, address1, email1, age1;
    JTextField name1Field, address1Field, email1Field, age1Field;
    JButton add1;
    JLabel id2, name2, address2, email2, age2;
    JComboBox<String> idSelect;
    String[] ids;
    JTextField name2Field, address2Field, email2Field, age2Field;
    JButton edit2;
    JLabel id3;
    JComboBox<String> idSelect3;
    JLabel name3, address3, email3, age3;
    JLabel name3Field, address3Field, email3Field, age3Field;
    JButton delete3;
    JTable clientsTable;
    String[][] tableData;


    ClientsGUI(){
        myFrame = new JFrame("Clients Management");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(300,400);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        add = new JButton("Add client");
        add.setFont(myFont);
        add.setFocusable(false);
        add.setBackground(new java.awt.Color(255,153,255));
        add.setBounds(70,30,150,50);
        myFrame.add(add);

        edit = new JButton("Edit client");
        edit.setFont(myFont);
        edit.setFocusable(false);
        edit.setBackground(new java.awt.Color(255,153,255));
        edit.setBounds(70, 100,150, 50);
        myFrame.add(edit);

        delete = new JButton("Delete client");
        delete.setFont(myFont);
        delete.setFocusable(false);
        delete.setBackground(new java.awt.Color(255,153,255));
        delete.setBounds(70, 170,150, 50);
        myFrame.add(delete);

        viewAll = new JButton("View all clients");
        viewAll.setFont(myFont);
        viewAll.setFocusable(false);
        viewAll.setBackground(new java.awt.Color(255,153,255));
        viewAll.setBounds(70, 240,150, 50);
        myFrame.add(viewAll);

        myFrame.setVisible(true);
    }

    public void addClient()
    {
        clientAdd = new JFrame("Add Client");
        clientAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientAdd.setSize(400,300);
        clientAdd.setLayout(null);
        clientAdd.setLocationRelativeTo(null);
        clientAdd.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        name1 = new JLabel("Name: ");
        name1.setBounds(50, 30,150,25);
        name1.setFont(myFont);
        clientAdd.add(name1);

        name1Field = new JTextField();
        name1Field.setBounds(180, 30, 150, 25);
        name1Field.setFont(myFont);
        clientAdd.add(name1Field);

        address1 = new JLabel("Address: ");
        address1.setBounds(50, 60,150,25);
        address1.setFont(myFont);
        clientAdd.add(address1);

        address1Field = new JTextField();
        address1Field.setBounds(180, 60, 150, 25);
        address1Field.setFont(myFont);
        clientAdd.add(address1Field);

        email1 = new JLabel("Email: ");
        email1.setBounds(50,90,150,25);
        email1.setFont(myFont);
        clientAdd.add(email1);

        email1Field = new JTextField();
        email1Field.setBounds(180,90,150,25);
        email1Field.setFont(myFont);
        clientAdd.add(email1Field);

        age1 = new JLabel("Age: ");
        age1.setBounds(50,120,150,25);
        age1.setFont(myFont);
        clientAdd.add(age1);

        age1Field = new JTextField();
        age1Field.setBounds(180,120,150,25);
        age1Field.setFont(myFont);
        clientAdd.add(age1Field);

        add1 = new JButton("Add");
        add1.setFont(myFont);
        add1.setFocusable(false);
        add1.setBackground(new java.awt.Color(255,153,255));
        add1.setBounds(130, 160,150, 50);
        clientAdd.add(add1);

        clientAdd.setVisible(true);

    }
    public void editClient()
    {
        clientEdit = new JFrame("Edit Client");
        clientEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientEdit.setSize(400,300);
        clientEdit.setLayout(null);
        clientEdit.setLocationRelativeTo(null);
        clientEdit.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        id2 = new JLabel("ID: ");
        id2.setBounds(50,30,150,25);
        id2.setFont(myFont);
        clientEdit.add(id2);

        idSelect = new JComboBox<>(ids);
        idSelect.setBounds(180, 30,150, 25);
        idSelect.setFont(myFont);
        clientEdit.add(idSelect);

        name2 = new JLabel("Name: ");
        name2.setBounds(50, 60,150,25);
        name2.setFont(myFont);
        clientEdit.add(name2);

        name2Field = new JTextField();
        name2Field.setBounds(180, 60, 150, 25);
        name2Field.setFont(myFont);
        clientEdit.add(name2Field);

        address2 = new JLabel("Address: ");
        address2.setBounds(50, 90,150,25);
        address2.setFont(myFont);
        clientEdit.add(address2);

        address2Field = new JTextField();
        address2Field.setBounds(180, 90, 150, 25);
        address2Field.setFont(myFont);
        clientEdit.add(address2Field);

        email2 = new JLabel("Email: ");
        email2.setBounds(50,120,150,25);
        email2.setFont(myFont);
        clientEdit.add(email2);

        email2Field = new JTextField();
        email2Field.setBounds(180,120,150,25);
        email2Field.setFont(myFont);
        clientEdit.add(email2Field);

        age2 = new JLabel("Age: ");
        age2.setBounds(50,150,150,25);
        age2.setFont(myFont);
        clientEdit.add(age2);

        age2Field = new JTextField();
        age2Field.setBounds(180,150,150,25);
        age2Field.setFont(myFont);
        clientEdit.add(age2Field);

        edit2 = new JButton("Edit");
        edit2.setFont(myFont);
        edit2.setFocusable(false);
        edit2.setBackground(new java.awt.Color(255,153,255));
        edit2.setBounds(130, 190,150, 50);
        clientEdit.add(edit2);

        clientEdit.setVisible(true);

    }

    public void deleteClient()
    {
        clientDelete = new JFrame("Delete Client");
        clientDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientDelete.setSize(400,300);
        clientDelete.setLayout(null);
        clientDelete.setLocationRelativeTo(null);
        clientDelete.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        id3 = new JLabel("ID: ");
        id3.setBounds(50,30,150,25);
        id3.setFont(myFont);
        clientDelete.add(id3);

        idSelect3 = new JComboBox<>(ids);
        idSelect3.setBounds(180, 30,150, 25);
        idSelect3.setFont(myFont);
        clientDelete.add(idSelect3);

        name3 = new JLabel("Name: ");
        name3.setBounds(50, 60,150,25);
        name3.setFont(myFont);
        clientDelete.add(name3);

        name3Field = new JLabel("");
        name3Field.setBounds(180, 60, 150, 25);
        name3Field.setFont(myFont);
        clientDelete.add(name3Field);

        address3 = new JLabel("Address: ");
        address3.setBounds(50, 90,150,25);
        address3.setFont(myFont);
        clientDelete.add(address3);

        address3Field = new JLabel("");
        address3Field.setBounds(180, 90, 150, 25);
        address3Field.setFont(myFont);
        clientDelete.add(address3Field);

        email3 = new JLabel("Email: ");
        email3.setBounds(50,120,150,25);
        email3.setFont(myFont);
        clientDelete.add(email3);

        email3Field = new JLabel("");
        email3Field.setBounds(180,120,150,25);
        email3Field.setFont(myFont);
        clientDelete.add(email3Field);

        age3 = new JLabel("Age: ");
        age3.setBounds(50,150,150,25);
        age3.setFont(myFont);
        clientDelete.add(age3);

        age3Field = new JLabel("");
        age3Field.setBounds(180,150,150,25);
        age3Field.setFont(myFont);
        clientDelete.add(age3Field);

        delete3 = new JButton("Delete");
        delete3.setFont(myFont);
        delete3.setFocusable(false);
        delete3.setBackground(new java.awt.Color(255,153,255));
        delete3.setBounds(130, 190,150, 50);
        clientDelete.add(delete3);

        clientDelete.setVisible(true);

    }
    public void viewClients()
    {
        clientView = new JFrame("View clients");
        clientView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientView.setSize(500,500);
        clientView.setLocationRelativeTo(null);
        clientView.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        String[] columnNames = {"Name", "Address", "Email", "Age"};
        clientsTable = new JTable(tableData, columnNames);
        clientsTable.setBackground(new java.awt.Color(255, 204, 255));
        clientsTable.setBounds(30,40,200,300);
        JScrollPane scrollPane = new JScrollPane(clientsTable);
        clientView.add(scrollPane);

        clientView.setVisible(true);
    }

}
