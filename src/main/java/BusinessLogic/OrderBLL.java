package BusinessLogic;

import DataAccess.BillDAO;
import DataAccess.ClientDAO;
import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import Model.Bill;
import Model.Client;
import Model.Order;
import Model.Product;
/**
 * The OrderBLL class provides the business logic for order-related operations.
 * It interacts with the OrderDAO class to perform CRUD operations on the order data.
 */
public class OrderBLL {
    private OrderDAO orderDAO;
    private BillDAO billDAO;
    private ProductDAO productDAO;
    private ClientDAO clientDAO;
    /**
     * Constructs a new OrderBLL and initializes the OrderDAO.
     */
    public OrderBLL() {

        this.orderDAO = new OrderDAO();
        this.billDAO = new BillDAO();
        this.productDAO = new ProductDAO();
        this.clientDAO = new ClientDAO();
    }

    public void insert(Order order)
    {
        orderDAO.insert(order);
        Product product = productDAO.findById(order.getIdProduct());
        Client client = clientDAO.findById(order.getIdClient());
        if (product != null) {
            double price = product.getPrice() * order.getQuantity();
            Bill bill = new Bill(client.getName(), product.getName(), order.getQuantity(), price);
            billDAO.insert(bill);
        }
        System.out.println("Order added");
    }
}
