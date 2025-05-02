package DAL;

import DTO.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {

    // Lấy danh sách tất cả item
    public ArrayList<ItemDTO> getAllItems() {
        ArrayList<ItemDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM item";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemID(rs.getInt("ItemID"));
                item.setItemName(rs.getString("ItemName"));
                item.setItemDetail(rs.getString("ItemDetail"));
                item.setProductMin(rs.getInt("productMin"));
                item.setItemPrice(rs.getDouble("ItemPrice"));
                item.setImageItem(rs.getString("image_item"));
                item.setCategoryID(rs.getInt("categoryID"));
                list.add(item);
            }
        } catch (SQLException e) {
            System.out.println("ItemDAO - getAllItems lỗi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("ItemDAO - Close lỗi: " + ex.getMessage());
            }
        }

        return list;
    }

    // Thêm mới một item
    public boolean addItem(ItemDTO item) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO item (ItemName, ItemDetail, productMin, ItemPrice, image_item, categoryID) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setString(2, item.getItemDetail());
            ps.setInt(3, item.getProductMin());
            ps.setDouble(4, item.getItemPrice());
            ps.setString(5, item.getImageItem());
            ps.setInt(6, item.getCategoryID());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("ItemDAO - addItem lỗi: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("ItemDAO - Close lỗi: " + ex.getMessage());
            }
        }
    }

    // Cập nhật một item
    public boolean updateItem(ItemDTO item) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE item SET ItemName = ?, ItemDetail = ?, productMin = ?, ItemPrice = ?, image_item = ?, categoryID = ? WHERE ItemID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setString(2, item.getItemDetail());
            ps.setInt(3, item.getProductMin());
            ps.setDouble(4, item.getItemPrice());
            ps.setString(5, item.getImageItem());
            ps.setInt(6, item.getCategoryID());
            ps.setInt(7, item.getItemID());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("ItemDAO - updateItem lỗi: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("ItemDAO - Close lỗi: " + ex.getMessage());
            }
        }
    }

    // Xóa một item theo ID
    public boolean deleteItem(int itemID) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM item WHERE ItemID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemID);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("ItemDAO - deleteItem lỗi: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("ItemDAO - Close lỗi: " + ex.getMessage());
            }
        }
    }
    
    // Thêm vào lớp ItemDAO
    public ItemDTO getItemByID(int itemID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM item WHERE ItemID = ?";
        ItemDTO item = null;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemID);
            rs = ps.executeQuery();

            if (rs.next()) {
                item = new ItemDTO();
                item.setItemID(rs.getInt("ItemID"));
                item.setItemName(rs.getString("ItemName"));
                item.setItemDetail(rs.getString("ItemDetail"));
                item.setProductMin(rs.getInt("productMin"));
                item.setItemPrice(rs.getDouble("ItemPrice"));
                item.setImageItem(rs.getString("image_item"));
                item.setCategoryID(rs.getInt("categoryID"));
            }
        } catch (SQLException e) {
            System.out.println("ItemDAO - getItemByID lỗi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("ItemDAO - Close lỗi: " + ex.getMessage());
            }
        }

        return item; // Trả về null nếu không tìm thấy
    }
}
