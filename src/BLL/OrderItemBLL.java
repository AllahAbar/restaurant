package BLL;

import DAL.OrderItemDAO;
import DTO.OrderItemDTO;
import java.util.ArrayList;

public class OrderItemBLL {
    private final OrderItemDAO orderItemDAO = new OrderItemDAO();
    
    public ArrayList<OrderItemDTO> getAllOrderItems() {
        return orderItemDAO.getAllOrderItems();
    }
    
    public boolean addOrderItem(OrderItemDTO orderItem) {
        return orderItemDAO.addOrderItem(orderItem);
    }
    
    public boolean updateOrderItem(OrderItemDTO orderItem) {
        return orderItemDAO.updateOrderItem(orderItem);
    }
    
    public boolean deleteOrderItem(int orderID, int itemID) {
        return orderItemDAO.deleteOrderItem(orderID, itemID);
    }
    
    public OrderItemDTO getOrderItemByIDs(int orderID, int itemID) {
        return orderItemDAO.getOrderItemByIDs(orderID, itemID);
    }
    
    public ArrayList<OrderItemDTO> getOrderItemsByOrderID(int orderID) {
        return orderItemDAO.getOrderItemsByOrderID(orderID);
    }
    
    // Additional business logic methods can be added here
    // For example, to calculate total price of items in an order
    
    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
    
    public boolean validateOrderItem(OrderItemDTO orderItem) {
        return validateQuantity(orderItem.getQuantity());
    }
}