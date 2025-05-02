
package DAL;

import DTO.TabletopDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class TableTopDAO {
    // CREATE
    public boolean insertTable(TabletopDTO table) {
        Connection conn = DBConnect.getConnection();
        if (conn != null){
            String sql = "INSERT INTO tabletop (tableID, Customer_ID, Table_Code, Status, Capacity, Current) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, table.getTableID());
                ps.setObject(2, table.getCustomerID(), Types.INTEGER);
                ps.setString(3, table.getTableCode());
                ps.setString(4, table.getStatus());
                ps.setObject(5, table.getCapacity(), Types.INTEGER);
                ps.setObject(6, table.getCurrent(), Types.INTEGER);
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("❌ tableTop - Lỗi khi thêm: " + e.getMessage());
            }
        }
        return false;
    }

    // READ ALL
    public ArrayList<TabletopDTO> getAllTables() {
        ArrayList<TabletopDTO> list = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        if (conn != null){
            String sql = "SELECT * FROM tabletop";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    TabletopDTO table = new TabletopDTO(
                        rs.getInt("tableID"),
                        rs.getObject("Customer_ID") != null ? rs.getInt("Customer_ID") : null,
                        rs.getString("Table_Code"),
                        rs.getString("Status"),
                        rs.getObject("Capacity") != null ? rs.getInt("Capacity") : null,
                        rs.getObject("Current") != null ? rs.getInt("Current") : null
                    );
                    list.add(table);
                }
            } catch (SQLException e) {
                System.out.println("❌ TableTop - Lỗi khi lấy dữ liệu: " + e.getMessage());
            }
        }
        return list;
    }

    // READ BY ID
    public TabletopDTO getTableByID(int tableID) {
        Connection conn = DBConnect.getConnection();
        if (conn != null){
            String sql = "SELECT * FROM tabletop WHERE tableID = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, tableID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new TabletopDTO(
                        rs.getInt("tableID"),
                        rs.getObject("Customer_ID") != null ? rs.getInt("Customer_ID") : null,
                        rs.getString("Table_Code"),
                        rs.getString("Status"),
                        rs.getObject("Capacity") != null ? rs.getInt("Capacity") : null,
                        rs.getObject("Current") != null ? rs.getInt("Current") : null
                    );
                }
            } catch (SQLException e) {
                System.out.println("❌ TableTop - Lỗi khi lấy dữ liệu: " + e.getMessage());
            }
        }
        return null;
    }

    // UPDATE
    public boolean updateTable(TabletopDTO table) {
        Connection conn = DBConnect.getConnection();
        if (conn != null){
            String sql = "UPDATE tabletop SET Customer_ID = ?, Table_Code = ?, Status = ?, Capacity = ?, Current = ? WHERE tableID = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                
                if (table.getCustomerID() == 0) {
                        ps.setNull(1, java.sql.Types.INTEGER); // Set staffID = NULL
                    } else {
                        ps.setInt(1, table.getCustomerID()); // Set staffID nếu có giá trị
                    }
                ps.setString(2, table.getTableCode());
                ps.setString(3, table.getStatus());
                ps.setObject(4, table.getCapacity(), Types.INTEGER);
                ps.setObject(5, table.getCurrent(), Types.INTEGER);
                ps.setInt(6, table.getTableID());
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("❌ TableTop - Lỗi khi lấy dữ liệu: " + e.getMessage());
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteTable(int tableID) {
        try (Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tabletop WHERE tableID = ?")) {

            ps.setInt(1, tableID);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ TableTop - Lỗi khi xóa dữ liệu: " + e.getMessage());
            return false;
        }
    }
    
    
}
