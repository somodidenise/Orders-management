package Model;
/**
 * The Order class represents an order with attributes such as id, idClient, idProduct, and quantity.
 */
public class Order {
    private int id;
    private int idClient;
    private int idProduct;
    private int quantity;
    /**
     * Constructs a new Order with the specified id, idClient, idProduct, and quantity.
     *
     * @param id        the id of the order
     * @param idClient  the id of the client placing the order
     * @param idProduct the id of the product being ordered
     * @param quantity  the quantity of the product being ordered
     */

    public Order(int id, int idClient, int idProduct, int quantity) {
        this.id = id;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Order(int idClient, int idProduct, int quantity) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String toString(){
        return "Order [id=" + ", idClient=" + idClient + ", idProduct=" + idProduct + ", quantity=" + quantity + "]";
    }
}
