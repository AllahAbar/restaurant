package DAL;

import DTO.OrderItemDTO;
import java.util.ArrayList;
import java.sql.*;

public class OrderItemDAO {
    public ArrayList<OrderItemDTO> getAllOrderItems() {
        ArrayList<OrderItemDTO> orderItemList = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        
        if(conn != null) {
            String sql = "SELECT * FROM orderitem";
            try(PreparedStatement stmt = conn.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery()) {
                
                while(rs.next()) {
                    OrderItemDTO orderItem = new OrderItemDTO(
                        rs.getInt("OrderID"),
                        rs.getInt("ItemID"),
                        rs.getInt("Quantity")
                    );
                    orderItemList.add(orderItem);
                }
                conn.close();
            } catch(SQLException e) {
                System.out.println("Lỗi khi lấy dữ liệu order item: " + e.getMessage()); 
            }
        }
        return orderItemList;
    }
    
    // CREATE
    public boolean addOrderItem(OrderItemDTO orderItem) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            String sql = "INSERT INTO orderitem(OrderID, ItemID, Quantity) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, orderItem.getOrderID());
                stmt.setInt(2, orderItem.getItemID());
                stmt.setInt(3, orderItem.getQuantity());
                
                int rows = stmt.executeUpdate();
                conn.close();
                return rows > 0;
            } catch (SQLException e) {
                System.out.println("Lỗi khi thêm order item: " + e.getMessage());
            }
        }
        return false;
    }
    
    // UPDATE
    public boolean updateOrderItem(OrderItemDTO orderItem) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE orderitem SET Quantity=? WHERE OrderID=? AND ItemID=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, orderItem.getQuantity());
                    stmt.setInt(2, orderItem.getOrderID());
                    stmt.setInt(3, orderItem.getItemID());
                    
                    int rows = stmt.executeUpdate();
                    conn.close();
                    return rows > 0;
                }
            } catch (SQLException e) {
                System.out.println("Lỗi khi cập nhật order item: " + e.getMessage());
            }
        }
        return false;
    }
    
    // DELETE
    public boolean deleteOrderItem(int orderID, int itemID) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM orderitem WHERE OrderID=? AND ItemID=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, orderID);
                    stmt.setInt(2, itemID);
                    
                    int rows = stmt.executeUpdate();
                    conn.close();
                    return rows > 0;
                }
            } catch (SQLException e) {
                System.out.println("Lỗi khi xóa order item: " + e.getMessage());
            }
        }
        return false;
    }
    
    // GET BY ORDER ID AND ITEM ID
    public OrderItemDTO getOrderItemByIDs(int orderID, int itemID) {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM orderitem WHERE OrderID = ? AND ItemID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, itemID);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                OrderItemDTO orderItem = new OrderItemDTO(
                    rs.getInt("OrderID"),
                    rs.getInt("ItemID"),
                    rs.getInt("Quantity")
                );
                return orderItem;
            }
        } catch(SQLException e) {
            System.out.println("Lỗi khi lấy order item theo ID: " + e.getMessage());
        }
        return null;
    }
    
    // GET ALL ITEMS BY ORDER ID
    public ArrayList<OrderItemDTO> getOrderItemsByOrderID(int orderID) {
        ArrayList<OrderItemDTO> orderItemList = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM orderitem WHERE OrderID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                OrderItemDTO orderItem = new OrderItemDTO(
                    rs.getInt("OrderID"),
                    rs.getInt("ItemID"),
                    rs.getInt("Quantity")
                );
                orderItemList.add(orderItem);
            }
        } catch(SQLException e) {
            System.out.println("Lỗi khi lấy order items theo OrderID: " + e.getMessage());
        }
        return orderItemList;
    }
}