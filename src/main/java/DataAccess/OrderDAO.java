package DataAccess;

import Model.Client;
import Connection.ConnectionFactory;
import Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The OrderDAO class provides methods for interacting with the 'order' table in the database.
 * It supports inserting orders into the table.
 */

public class OrderDAO extends GenericDAO<Order>{
    protected Order extractObject(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        int idClient = rs.getInt("idClient");
        int idProduct = rs.getInt("idProduct");
        int quantity = rs.getInt("quantity");
        return new Order(id,idClient,idProduct,quantity);
    }


}
