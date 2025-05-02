package DAL;

import DTO.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {

    // Lấy danh sách tất cả các category
    public ArrayList<CategoryDTO> getAllCategories() {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM category";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setImageCategory(rs.getString("image_category"));
                category.setCategoryName(rs.getString("categoryName"));
                list.add(category);
            }
        } catch (SQLException e) {
            System.out.println("CategoryDAO - getAllCategories lỗi: " + e.getMessage());
        } finally {
            // Close tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("CategoryDAO - Close lỗi: " + ex.getMessage());
            }
        }

        return list;
    }

    // Thêm mới một category
    public boolean addCategory(CategoryDTO category) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO category (image_category, categoryName) VALUES (?, ?)";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getImageCategory());
            ps.setString(2, category.getCategoryName());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("CategoryDAO - addCategory lỗi: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("CategoryDAO - Close lỗi: " + ex.getMessage());
            }
        }
    }

    // Cập nhật một category
    public boolean updateCategory(CategoryDTO category) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE category SET image_category = ?, categoryName = ? WHERE categoryID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getImageCategory());
            ps.setString(2, category.getCategoryName());
            ps.setInt(3, category.getCategoryID());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("CategoryDAO - updateCategory lỗi: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("CategoryDAO - Close lỗi: " + ex.getMessage());
            }
        }
    }

    // Xóa một category theo ID
    public boolean deleteCategory(int categoryID) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM category WHERE categoryID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("CategoryDAO - deleteCategory lỗi: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("CategoryDAO - Close lỗi: " + ex.getMessage());
            }
        }
    }
    
    // Tìm kiếm category theo ID
    public CategoryDTO getCategoryByID(int categoryID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM category WHERE categoryID = ?";
        CategoryDTO category = null;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new CategoryDTO();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setImageCategory(rs.getString("image_category"));
                category.setCategoryName(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            System.out.println("CategoryDAO - getCategoryByID lỗi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("CategoryDAO - Close lỗi: " + ex.getMessage());
            }
        }

        return category;
    }
    
    // Tìm kiếm category theo tên (categoryName)
    public CategoryDTO getCategoryByName(String categoryName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM category WHERE categoryName = ?";
        CategoryDTO category = null;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new CategoryDTO();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setImageCategory(rs.getString("image_category"));
                category.setCategoryName(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            System.out.println("CategoryDAO - getCategoryByName lỗi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("CategoryDAO - Close lỗi: " + ex.getMessage());
            }
        }

        return category;
    }
}
