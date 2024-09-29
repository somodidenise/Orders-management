package DataAccess;

import Model.Bill;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The BillDAO class provides methods for interacting with the Log table in the database.
 * It supports inserting and retrieving Bill records.
 */
public class BillDAO {
    protected static final Logger LOGGER = Logger.getLogger(BillDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO log (clientName, productName, quantity, price)"
            + "VALUES (?, ?, ?, ?)";
    private static final String findAllStatementString = "SELECT * FROM log";

    /**
     * Inserts a new bill into the Log table.
     *
     * @param bill the Bill object to insert
     */
    public static void insert(Bill bill) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString);
            insertStatement.setString(1, bill.clientName());
            insertStatement.setString(2, bill.productName());
            insertStatement.setInt(3, bill.quantity());
            insertStatement.setDouble(4, bill.price());
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "BillDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Retrieves all bills from the Log table.
     *
     * @return a list of Bill objects
     */
    public static List<Bill> findAll() {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;
        List<Bill> bills = new ArrayList<>();
        try {
            findAllStatement = dbConnection.prepareStatement(findAllStatementString);
            rs = findAllStatement.executeQuery();
            while (rs.next()) {
                String clientName = rs.getString("clientName");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                bills.add(new Bill(clientName, productName, quantity, price));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "BillDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return bills;
    }
}

