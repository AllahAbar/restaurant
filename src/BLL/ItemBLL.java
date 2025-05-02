package BLL;

import DAL.ItemDAO;
import DTO.ItemDTO;
import java.util.ArrayList;

public class ItemBLL {

    private final ItemDAO itemDAO;

    public ItemBLL() {
        itemDAO = new ItemDAO();
    }

    // Lấy tất cả item
    public ArrayList<ItemDTO> getAllItems() {
        return itemDAO.getAllItems();
    }

    // Thêm item mới
    public boolean addItem(ItemDTO item) {
        return itemDAO.addItem(item);
    }

    // Cập nhật item
    public boolean updateItem(ItemDTO item) {
        return itemDAO.updateItem(item);
    }

    // Xóa item theo ID
    public boolean deleteItem(int itemID) {
        return itemDAO.deleteItem(itemID);
    }
    
    public ItemDTO getItemByID(int itemID) {
        return itemDAO.getItemByID(itemID);
    }
}
