package DAL;

import DTO.TransactionDTO;
import java.sql.*;
import java.util.ArrayList;

public class TransactionDAO {
    private Connection conn;

    public TransactionDAO() {
        this.conn = DBConnect.getConnection(); // ✅ Sử dụng DBConnect đúng tên
    }

    // Lấy tất cả giao dịch
    public ArrayList<TransactionDTO> getAllTransactions() {
        ArrayList<TransactionDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM transaction";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TransactionDTO dto = new TransactionDTO(
                    rs.getInt("TransactionID"),
                    rs.getInt("Customer_ID"),
                    rs.getString("Type"),
                    rs.getString("Status"),
                    rs.getTimestamp("Create_At"),
                    rs.getInt("OrderID"),
                    rs.getString("Content")
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi lấy giao dịch: " + e.getMessage());
        }
        return list;
    }

    // Thêm giao dịch mới
    public boolean insertTransaction(TransactionDTO transaction) {
        String sql = "INSERT INTO transaction (Customer_ID, Type, Status, Create_At, OrderID, Content) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, transaction.getCustomerID());
            ps.setString(2, transaction.getType());
            ps.setString(3, transaction.getStatus());
            ps.setTimestamp(4, new Timestamp(transaction.getCreateAt().getTime()));
            ps.setInt(5, transaction.getOrderID());
            ps.setString(6, transaction.getContent());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Lỗi thêm giao dịch: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật giao dịch
    public boolean updateTransaction(TransactionDTO transaction) {
        String sql = "UPDATE transaction SET Customer_ID=?, Type=?, Status=?, Create_At=?, OrderID=?, Content=? WHERE TransactionID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, transaction.getCustomerID());
            ps.setString(2, transaction.getType());
            ps.setString(3, transaction.getStatus());
            ps.setTimestamp(4, new Timestamp(transaction.getCreateAt().getTime()));
            ps.setInt(5, transaction.getOrderID());
            ps.setString(6, transaction.getContent());
            ps.setInt(7, transaction.getTransactionID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Lỗi cập nhật giao dịch: " + e.getMessage());
            return false;
        }
    }

    // Xóa giao dịch
    public boolean deleteTransaction(int transactionID) {
        String sql = "DELETE FROM transaction WHERE TransactionID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, transactionID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Lỗi xóa giao dịch: " + e.getMessage());
            return false;
        }
    }

    // Tìm giao dịch theo ID
    public TransactionDTO getTransactionByID(int id) {
        String sql = "SELECT * FROM transaction WHERE TransactionID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TransactionDTO(
                    rs.getInt("TransactionID"),
                    rs.getInt("Customer_ID"),
                    rs.getString("Type"),
                    rs.getString("Status"),
                    rs.getTimestamp("Create_At"),
                    rs.getInt("OrderID"),
                    rs.getString("Content")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi tìm giao dịch theo ID: " + e.getMessage());
        }
        return null;
    }
}
