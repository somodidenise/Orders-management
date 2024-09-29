package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Client;
import Model.Order;
import Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The Controller class acts as the intermediary between the view and the business logic.
 * It listens for user interactions and updates the model and view accordingly.
 * This class handles actions for managing clients, products, and orders.
 *
 * Responsibilities:
 * - Initializes the main view and sub-views for clients, products, and orders.
 * - Sets up action listeners for various GUI components.
 * - Manages the order creation process and stock validation.
 */

public class Controller implements ActionListener {
    View view;
    ClientsGUI clientsGUI;
    ProductsGUI productsGUI;
    OrderGUI orderGUI;
    ClientBLL clientBLL;
    ProductBLL productBLL;
    OrderBLL orderBLL;
   // boolean validation = false;
    public Controller(){

        this.view = new View();
        clientBLL = new ClientBLL();
        productBLL = new ProductBLL();
        orderBLL = new OrderBLL();
        addActionListeners();
        addMouseListeners();
    }
    public void addActionListeners(){
        this.view.clients.addActionListener(this);
        this.view.products.addActionListener(this);
        this.view.orders.addActionListener(this);
    }

    public void addMouseListeners(){

        //this.simulationSetup.nrClients.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ev) {

        if(ev.getSource() == view.clients) {
            clientsGUI = new ClientsGUI();
            this.clientsGUI.edit.addActionListener(this);
            this.clientsGUI.add.addActionListener(this);
            this.clientsGUI.delete.addActionListener(this);
            this.clientsGUI.viewAll.addActionListener(this);
        }
        else if(ev.getSource() == view.products){
            productsGUI = new ProductsGUI();
            this.productsGUI.edit.addActionListener(this);
            this.productsGUI.add.addActionListener(this);
            this.productsGUI.delete.addActionListener(this);
            this.productsGUI.viewAll.addActionListener(this);
        }
        else if(ev.getSource() == view.orders){
            orderGUI = new OrderGUI();
            String[] idsClient = clientBLL.allIds();
            orderGUI.idsClient = idsClient;
            String[] idsProduct = productBLL.allIds();
            orderGUI.idsProduct = idsProduct;
            orderGUI.addComboBoxes();
            //orderGUI.myFrame.setVisible(true);
            //orderGUI = new OrderGUI();
            this.orderGUI.confirm.addActionListener(this);
        }

        if(clientsGUI != null) {
            if (ev.getSource() == clientsGUI.edit) {
                String[] ids = clientBLL.allIds();
                clientsGUI.ids = ids;
                clientsGUI.editClient();
                this.clientsGUI.idSelect.addActionListener(this);
                this.clientsGUI.edit2.addActionListener(this);
            } else if (ev.getSource() == clientsGUI.add) {
                clientsGUI.addClient();
                this.clientsGUI.add1.addActionListener(this);
            } else if (ev.getSource() == clientsGUI.delete) {
                String[] ids = clientBLL.allIds();
                clientsGUI.ids = ids;
                clientsGUI.deleteClient();
                this.clientsGUI.idSelect3.addActionListener(this);
                this.clientsGUI.delete3.addActionListener(this);
            } else if (ev.getSource() == clientsGUI.viewAll) {
                clientsGUI.tableData = clientBLL.findAll();
                clientsGUI.viewClients();
            }
            if(ev.getSource() == clientsGUI.add1)
            {
                String name = clientsGUI.name1Field.getText();
                String address = clientsGUI.address1Field.getText();
                String email = clientsGUI.email1Field.getText();
                int age = Integer.parseInt(clientsGUI.age1Field.getText());
                Client client = new Client(name, address, email, age);
                clientBLL.insert(client);

            }
            if(ev.getSource() == clientsGUI.idSelect)
            {
                String id = (String)clientsGUI.idSelect.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                Client client = clientBLL.findById(idSelected);
                clientsGUI.name2Field.setText(client.getName());
                clientsGUI.address2Field.setText(client.getAddress());
                clientsGUI.email2Field.setText(client.getEmail());
                clientsGUI.age2Field.setText(String.valueOf(client.getAge()));

            }
            if(ev.getSource() == clientsGUI.edit2)
            {
                String id = (String)clientsGUI.idSelect.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                String name = clientsGUI.name2Field.getText();
                String address = clientsGUI.address2Field.getText();
                String email = clientsGUI.email2Field.getText();
                int age = Integer.parseInt(clientsGUI.age2Field.getText());
                Client client = new Client(name, address, email, age);
                clientBLL.update(client, idSelected);

            }
            if(ev.getSource() == clientsGUI.idSelect3)
            {
                String id = (String)clientsGUI.idSelect3.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                Client client = clientBLL.findById(idSelected);
                clientsGUI.name3Field.setText(client.getName());
                clientsGUI.address3Field.setText(client.getAddress());
                clientsGUI.email3Field.setText(client.getEmail());
                clientsGUI.age3Field.setText(String.valueOf(client.getAge()));

            }
            if(ev.getSource() == clientsGUI.delete3)
            {
                String id = (String)clientsGUI.idSelect3.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                clientBLL.delete(idSelected);
                clientsGUI.name3Field.setText("");
                clientsGUI.address3Field.setText("");
                clientsGUI.email3Field.setText("");
                clientsGUI.age3Field.setText("");
            }

        }

        if(productsGUI != null) {
            if (ev.getSource() == productsGUI.edit) {
                String[] ids = productBLL.allIds();
                productsGUI.ids = ids;
                productsGUI.editProduct();
                this.productsGUI.idSelect.addActionListener(this);
                this.productsGUI.edit2.addActionListener(this);
            } else if (ev.getSource() == productsGUI.add) {
                productsGUI.addProduct();
                this.productsGUI.add1.addActionListener(this);
            } else if (ev.getSource() == productsGUI.delete) {
                String[] ids = productBLL.allIds();
                productsGUI.ids = ids;
                productsGUI.deleteProduct();
                this.productsGUI.idSelect3.addActionListener(this);
                this.productsGUI.delete3.addActionListener(this);
            } else if (ev.getSource() == productsGUI.viewAll) {
                productsGUI.tableData = productBLL.findAll();
                productsGUI.viewProducts();
            }
            if(ev.getSource() == productsGUI.add1)
            {
                String name = productsGUI.name1Field.getText();
                int quantity = Integer.parseInt(productsGUI.quantity1Field.getText());
                double price = Double.parseDouble(productsGUI.price1Field.getText());
                Product product = new Product(name, quantity, price);
                productBLL.insert(product);
            }
            if(ev.getSource() == productsGUI.idSelect)
            {
                String id = (String)productsGUI.idSelect.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                Product product = productBLL.findById(idSelected);
                productsGUI.name2Field.setText(product.getName());
                productsGUI.quantity2Field.setText(String.valueOf(product.getQuantity()));
                productsGUI.price2Field.setText(String.valueOf(product.getPrice()));
            }
            if(ev.getSource() == productsGUI.edit2)
            {
                String id = (String)productsGUI.idSelect.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                String name = productsGUI.name2Field.getText();
                int quantity = Integer.parseInt(productsGUI.quantity2Field.getText());
                double price = Double.parseDouble(productsGUI.price2Field.getText());
                Product product = new Product(name, quantity, price);
                productBLL.update(product, idSelected);
            }
            if(ev.getSource() == productsGUI.idSelect3)
            {
                String id = (String)productsGUI.idSelect3.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                Product product = productBLL.findById(idSelected);
                productsGUI.name3Field.setText(product.getName());
                productsGUI.quantity3Field.setText(String.valueOf(product.getQuantity()));
                productsGUI.price3Field.setText(String.valueOf(product.getPrice()));
            }
            if(ev.getSource() == productsGUI.delete3)
            {
                String id = (String)productsGUI.idSelect3.getSelectedItem();
                int idSelected = Integer.parseInt(id);
                productBLL.delete(idSelected);
                productsGUI.name3Field.setText("");
                productsGUI.quantity3Field.setText("");
                productsGUI.price3Field.setText("");
            }
        }

        if(orderGUI != null)
        {
           if(ev.getSource() == orderGUI.confirm)
           {
               orderGUI.insufficientStockFalse();
               String idClient = (String)orderGUI.clients.getSelectedItem();
               int idSelectedClient = Integer.parseInt(idClient);
               String idProduct = (String)orderGUI.products.getSelectedItem();
               int idSelectedProduct = Integer.parseInt(idProduct);
               int quantity = Integer.parseInt(orderGUI.quantity.getText());
               boolean ok = productBLL.checkStock(quantity, idSelectedProduct);
               if(ok == false)
               {
                   orderGUI.insufficientStock();
               }
               else{
                   Order order = new Order(idSelectedClient, idSelectedProduct, quantity);
                   orderBLL.insert(order);
                   productBLL.decreaseStock(idSelectedProduct,quantity);
               }
           }
        }
    }

}

