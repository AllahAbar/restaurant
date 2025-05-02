
package DAL;

import DTO.AccountDTO;
import java.util.ArrayList;
import java.sql.*;


public class AccountDAO {
    public ArrayList<AccountDTO> getAllAccount(){
        ArrayList<AccountDTO> accountList = new ArrayList<>();
            Connection conn = DBConnect.getConnection();
        
        if(conn != null){
            String sql = "SELECT * FROM account";
            try(PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    AccountDTO account = new AccountDTO(
                            rs.getInt("accountID"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getInt("staffID")
                    );
                    accountList.add(account);
                }
                conn.close();
            } catch(SQLException e){
                System.out.println("Loi khi lay du lieu" + e.getMessage()); 
            }
        }
        return accountList;
    }
    
    //CREATE
    public boolean addAccount(AccountDTO account) {
    Connection conn = DBConnect.getConnection();
    if (conn != null) {
        // Loại bỏ accountID nếu nó là auto-increment
        String sql = "INSERT INTO account(username, password, role, staffID) VALUES (?, ?, ?, ?)";
        int rows;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Thêm các trường còn lại vào câu lệnh
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getRole());
            
            if (account.getStaffID() == null) {
                stmt.setNull(4, java.sql.Types.INTEGER);  // Nếu staffID null thì chèn giá trị null
            } else {
                stmt.setInt(4, account.getStaffID());  // Thêm staffID vào câu lệnh
            }
            
            rows = stmt.executeUpdate();
            conn.close();
            return rows > 0;  // Nếu ít nhất một bản ghi được thêm vào thì trả về true
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
    }
    return false;  // Nếu không thêm được bản ghi nào, trả về false
}

    
   //UPDATE
    // Phương thức cập nhật tài khoản
    public boolean updateAccount(AccountDTO account) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE account SET username=?, password=?, role=?, staffID=? WHERE accountID=?";
                int rows;
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    // Cập nhật các trường thông tin
                    stmt.setString(1, account.getUsername());
                    stmt.setString(2, account.getPassword());
                    stmt.setString(3, account.getRole());

                    // Kiểm tra staffID: nếu null thì dùng setNull, nếu có giá trị thì dùng setInt
                    if (account.getStaffID() == 0) {
                        stmt.setNull(4, java.sql.Types.INTEGER); // Set staffID = NULL
                    } else {
                        stmt.setInt(4, account.getStaffID()); // Set staffID nếu có giá trị
                    }

                    stmt.setInt(5, account.getAccountID()); // Cập nhật accountID

                    // Thực hiện update
                    rows = stmt.executeUpdate();
                }

                conn.close();
                return rows > 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage()); // In ra thông báo lỗi nếu có
            }
        }
        return false;
    }


    
    //  DELETE 
    public boolean deleteAccount(int accountID) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM account WHERE accountID=?";
                int rows;
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, accountID);
                    rows = stmt.executeUpdate();
                }
                conn.close();

                return rows > 0;
            } catch (SQLException e) {
                System.out.println("❌ StaffDAO - Lỗi khi xóa: " + e.getMessage());
            }
        }
        return false;
    }
    
    //  DELETE by staffID
    public boolean deleteAccountByStaffID(int staffID) {
        Connection conn = DBConnect.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM account WHERE staffID=?";
                int rows;
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, staffID);
                    rows = stmt.executeUpdate();
                }
                conn.close();

                return rows > 0;
            } catch (SQLException e) {
                System.out.println("❌ StaffDAO - Lỗi khi xóa: " + e.getMessage());
            }
        }
        return false;
    }
    
    public AccountDTO getAccountByID(int AccountID){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM account WHERE accountID = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, AccountID);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                AccountDTO account = new AccountDTO(
                        rs.getInt("accountID"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("staffID")
                );
                return account;
            }
        } catch(SQLException e){
            System.out.println(" Lỗi khi lấy nhân viên theo ID: " + e.getMessage());
        }
        
        return null;
    }
    
    public AccountDTO getAccountByUsername(String username) {   
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM account WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                AccountDTO account = new AccountDTO(
                    rs.getInt("accountID"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getInt("staffID")
                );
                return account;
            }
            
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm tài khoản theo username: " + e.getMessage());
        }
        return null;
    }

}
