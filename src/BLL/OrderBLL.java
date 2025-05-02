package BLL;

import DAL.OrderDAO;
import DTO.OrderDTO;
import java.math.BigDecimal;
import java.util.ArrayList;


public class OrderBLL {
    private final OrderDAO orderDAO;

    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    // Get all orders
    public ArrayList<OrderDTO> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    // Add new order
    public boolean addOrder(OrderDTO order) {
        // Validate order data before adding
        if (validateOrder(order)) {
            return orderDAO.addOrder(order);
        }
        return false;
    }

    // Update existing order
    public boolean updateOrder(OrderDTO order) {
        // Validate order data before updating
        if (validateOrder(order)) {
            return orderDAO.updateOrder(order);
        }
        return false;
    }

    // Delete order by ID
    public boolean deleteOrder(int orderID) {
        return orderDAO.deleteOrder(orderID);
    }

    // Get order by ID
    public OrderDTO getOrderByID(int orderID) {
        return orderDAO.getOrderByID(orderID);
    }

    // Get orders by customer ID
    public ArrayList<OrderDTO> getOrdersByCustomerID(int customerID) {
        return orderDAO.getOrdersByCustomerID(customerID);
    }

    // Get orders by transaction ID
    public ArrayList<OrderDTO> getOrdersByTransactionID(int transactionID) {
        return orderDAO.getOrdersByTransactionID(transactionID);
    }

    // Validate order data
    private boolean validateOrder(OrderDTO order) {
        // Validate total price (must be positive)
        if (order.getTotalPrice() == null || order.getTotalPrice().compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid total price");
            return false;
        }

        // Validate content (if required)
        if (order.getContent() == null || order.getContent().trim().isEmpty()) {
            System.out.println("Order content cannot be empty");
            return false;
        }

        // Additional validation rules can be added here
        return true;
    }

    // Business logic methods
    public BigDecimal calculateOrderTotal(ArrayList<OrderDTO> orders) {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderDTO order : orders) {
            total = total.add(order.getTotalPrice());
        }
        return total;
    }

    // Get orders with total price greater than specified amount
    public ArrayList<OrderDTO> getOrdersWithTotalGreaterThan(BigDecimal amount) {
        ArrayList<OrderDTO> allOrders = getAllOrders();
        ArrayList<OrderDTO> filteredOrders = new ArrayList<>();
        
        for (OrderDTO order : allOrders) {
            if (order.getTotalPrice().compareTo(amount) > 0) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }

    // Link order to transaction
    public boolean linkOrderToTransaction(int orderID, int transactionID) {
        OrderDTO order = getOrderByID(orderID);
        if (order != null) {
            order.setTransactionID(transactionID);
            return updateOrder(order);
        }
        return false;
    }

    // Get unlinked orders (orders not associated with any transaction)
    public ArrayList<OrderDTO> getUnlinkedOrders() {
        ArrayList<OrderDTO> allOrders = getAllOrders();
        ArrayList<OrderDTO> unlinkedOrders = new ArrayList<>();
        
        for (OrderDTO order : allOrders) {
            if (order.getTransactionID() == null) {
                unlinkedOrders.add(order);
            }
        }
        return unlinkedOrders;
    }
}