package DataAccess;

import Model.Client;
import Model.Product;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The ProductDAO class provides methods for interacting with the 'product' table in the database.
 * It supports CRUD operations on product data.
 */

public class ProductDAO extends GenericDAO<Product>{
    protected Product extractObject(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int quantity = rs.getInt("quantity");
        double price = rs.getDouble("price");
        return new Product(id,name,quantity,price);
    }
    public void decreaseStock(int id, int quantity)
    {
        Product product = findById(id);
        int newQuantity = product.getQuantity() - quantity;
        Product newProduct = new Product(product.getId(),product.getName(),newQuantity,product.getPrice());
        update(newProduct, id);
    }

}



