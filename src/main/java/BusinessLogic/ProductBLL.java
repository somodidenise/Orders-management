package BusinessLogic;

import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Product;
/**
 * The ProductBLL class provides the business logic for product-related operations.
 * It interacts with the ProductDAO class to perform CRUD operations on the product data.
 */
public class ProductBLL {
    private ProductDAO productDAO;
    /**
     * Constructs a new ProductBLL and initializes the ProductDAO.
     */
    public ProductBLL() {
        this.productDAO = new ProductDAO();
    }
    public Product findById(int id){
        Product product = productDAO.findById(id);
        if(product == null)
        {
            System.out.println("The product was not found");
            return null;
        }
        return product;
    }
    public void insert(Product product)
    {
        productDAO.insert(product);
        System.out.println("Product added");
    }
    public void delete(int id)
    {
        productDAO.deleteById(id);
    }
    public void update(Product product, int id)
    {
        productDAO.update(product, id);
    }
    public String[][] findAll()
    {
        return productDAO.findAll();
    }
    public String[] allIds()
    {
        return productDAO.allIds();
    }
    public boolean checkStock(int quantity, int id)
    {
        Product product = productDAO.findById(id);
        int stock = product.getQuantity();
        if(quantity > stock)
        {
            return false;
        }
        return true;
    }
    public void decreaseStock(int id, int quantity)
    {
        productDAO.decreaseStock(id,quantity);
    }
}
