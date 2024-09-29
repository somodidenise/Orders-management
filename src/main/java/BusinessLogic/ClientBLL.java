package BusinessLogic;

import DataAccess.ClientDAO;
import Model.Client;

import java.sql.SQLOutput;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * The ClientBLL class provides the business logic for client-related operations.
 * It interacts with the ClientDAO class to perform CRUD operations on the client data.
 */

public class ClientBLL {
    private ClientDAO clientDAO;
    /**
     * Constructs a new ClientBLL and initializes the ClientDAO.
     */
    public ClientBLL() {
        this.clientDAO = new ClientDAO();
    }
    public Client findById(int id){
        Client client = clientDAO.findById(id);
        if(client == null)
        {
            System.out.println("The client was not found");
            return null;
        }
        return client;
    }
    public void insert(Client client)
    {
       clientDAO.insert(client);
       System.out.println("Client added");
    }
    public void delete(int id)
    {
        clientDAO.deleteById(id);
    }
    public void update(Client client, int id)
    {
        clientDAO.update(client, id);
    }
    public String[][] findAll()
    {
        return clientDAO.findAll();
    }
    public String[] allIds()
    {
        return clientDAO.allIds();
    }
}
