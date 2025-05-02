package BLL;

import DAL.TableTopDAO;
import DTO.TabletopDTO;
import java.util.ArrayList;

public class TableTopBLL {

    private final TableTopDAO tableTopDAO;

    public TableTopBLL() {
        this.tableTopDAO = new TableTopDAO();
    }

    // CREATE - Thêm bàn mới
    public boolean addTable(TabletopDTO table) {
        return tableTopDAO.insertTable(table);
    }

    // READ ALL - Lấy tất cả bàn
    public ArrayList<TabletopDTO> getAllTables() {
        return tableTopDAO.getAllTables();
    }

    // READ BY ID - Lấy bàn theo tableID
    public TabletopDTO getTableByID(int tableID) {
        return tableTopDAO.getTableByID(tableID);
    }

    // UPDATE - Cập nhật bàn
    public boolean updateTable(TabletopDTO table) {
        return tableTopDAO.updateTable(table);
    }

    // DELETE - Xóa bàn theo tableID
    public boolean deleteTable(int tableID) {
        return tableTopDAO.deleteTable(tableID);
    }
}
