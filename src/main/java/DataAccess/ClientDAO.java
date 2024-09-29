package DataAccess;

import Model.Client;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The ClientDAO class provides methods for interacting with the 'client' table in the database.
 */

public class ClientDAO extends GenericDAO<Client>{
    protected Client extractObject(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String email = rs.getString("email");
        int age = rs.getInt("age");
        return new Client(id, name, address, email, age);
    }

}

