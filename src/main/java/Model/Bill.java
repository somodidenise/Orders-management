package Model;

/**
 * The Bill class represents a bill generated for an order.
 * This class is immutable and uses Java records.
 */
public record Bill(String clientName, String productName, int quantity, double price) {}

