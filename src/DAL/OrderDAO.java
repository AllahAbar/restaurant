package DAL;

import DTO.OrderDTO;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {
    
    // Get all orders from database
    public ArrayList<OrderDTO> getAllOrders() {
        ArrayList<OrderDTO> orderList = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        
        if (conn != null) {
            String sql = "SELECT * FROM `order`";
            try (PreparedStatement stmt = conn.prepareStatement(sql); 
                 ResultSet rs = stmt.executeQuery()) {
                
                while (rs.next()) {
                    OrderDTO order = new OrderDTO(
                        rs.getInt("OrderID"),
                        rs.getObject("tableID") != null ? rs.getInt("tableID") : null,
                        rs.getObject("CustomerID") != null ? rs.getInt("CustomerID") : null,
                        rs.getBigDecimal("totalPrice"),
                        rs.getString("Content"),
                        rs.getObject("TransactionID") != null ? rs.getInt("TransactionID") : null
                    );
                    orderList.add(order);
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving orders: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return orderList;
    }
    
    // Add new order to database
    public boolean addOrder(OrderDTO order) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            String sql = "INSERT INTO `order`(tableID, CustomerID, totalPrice, Content, TransactionID) "
                       + "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                
                // Set parameters, handling null values
                if (order.getTableID() == null) {
                    stmt.setNull(1, Types.INTEGER);
                } else {
                    stmt.setInt(1, order.getTableID());
                }
                
                if (order.getCustomerID() == null) {
                    stmt.setNull(2, Types.INTEGER);
                } else {
                    stmt.setInt(2, order.getCustomerID());
                }
                
                stmt.setBigDecimal(3, order.getTotalPrice());
                stmt.setString(4, order.getContent());
                
                if (order.getTransactionID() == null) {
                    stmt.setNull(5, Types.INTEGER);
                } else {
                    stmt.setInt(5, order.getTransactionID());
                }
                
                int affectedRows = stmt.executeUpdate();
                
                // Get generated orderID if needed
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            order.setOrderID(generatedKeys.getInt(1));
                        }
                    }
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Error adding order: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return false;
    }
    
    // Update existing order
    public boolean updateOrder(OrderDTO order) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            String sql = "UPDATE `order` SET tableID=?, CustomerID=?, totalPrice=?, Content=?, TransactionID=? "
                       + "WHERE OrderID=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                // Set parameters, handling null values
                if (order.getTableID() == null) {
                    stmt.setNull(1, Types.INTEGER);
                } else {
                    stmt.setInt(1, order.getTableID());
                }
                
                if (order.getCustomerID() == null) {
                    stmt.setNull(2, Types.INTEGER);
                } else {
                    stmt.setInt(2, order.getCustomerID());
                }
                
                stmt.setBigDecimal(3, order.getTotalPrice());
                stmt.setString(4, order.getContent());
                
                if (order.getTransactionID() == null) {
                    stmt.setNull(5, Types.INTEGER);
                } else {
                    stmt.setInt(5, order.getTransactionID());
                }
                
                stmt.setInt(6, order.getOrderID());
                
                int affectedRows = stmt.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                System.out.println("Error updating order: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return false;
    }
    
    // Delete order by ID
    public boolean deleteOrder(int orderID) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            String sql = "DELETE FROM `order` WHERE OrderID=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, orderID);
                int affectedRows = stmt.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                System.out.println("Error deleting order: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return false;
    }
    
    // Get order by ID
    public OrderDTO getOrderByID(int orderID) {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM `order` WHERE OrderID=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new OrderDTO(
                        rs.getInt("OrderID"),
                        rs.getObject("tableID") != null ? rs.getInt("tableID") : null,
                        rs.getObject("CustomerID") != null ? rs.getInt("CustomerID") : null,
                        rs.getBigDecimal("totalPrice"),
                        rs.getString("Content"),
                        rs.getObject("TransactionID") != null ? rs.getInt("TransactionID") : null
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting order by ID: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
        return null;
    }
    
    // Get orders by customer ID
    public ArrayList<OrderDTO> getOrdersByCustomerID(int customerID) {
        ArrayList<OrderDTO> orderList = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        
        if (conn != null) {
            String sql = "SELECT * FROM `order` WHERE CustomerID=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, customerID);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        OrderDTO order = new OrderDTO(
                            rs.getInt("OrderID"),
                            rs.getObject("tableID") != null ? rs.getInt("tableID") : null,
                            rs.getInt("CustomerID"),
                            rs.getBigDecimal("totalPrice"),
                            rs.getString("Content"),
                            rs.getObject("TransactionID") != null ? rs.getInt("TransactionID") : null
                        );
                        orderList.add(order);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error getting orders by customer ID: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return orderList;
    }
    
    // Get orders by transaction ID
    public ArrayList<OrderDTO> getOrdersByTransactionID(int transactionID) {
        ArrayList<OrderDTO> orderList = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        
        if (conn != null) {
            String sql = "SELECT * FROM `order` WHERE TransactionID=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, transactionID);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        OrderDTO order = new OrderDTO(
                            rs.getInt("OrderID"),
                            rs.getObject("tableID") != null ? rs.getInt("tableID") : null,
                            rs.getObject("CustomerID") != null ? rs.getInt("CustomerID") : null,
                            rs.getBigDecimal("totalPrice"),
                            rs.getString("Content"),
                            rs.getInt("TransactionID")
                        );
                        orderList.add(order);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error getting orders by transaction ID: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return orderList;
    }
}