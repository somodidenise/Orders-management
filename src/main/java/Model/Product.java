package Model;
/**
 * The Product class represents a product with attributes such as id, name, quantity, and price.
 */

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    /**
     * Constructs a new Product with the specified id, name, quantity, and price.
     *
     * @param id       the id of the product
     * @param name     the name of the product
     * @param quantity the quantity of the product
     * @param price    the price of the product
     */
    public Product(int id, String name, int quantity, double price)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(String name, int quantity, double price)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String toString(){
        return "Product [id" + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
