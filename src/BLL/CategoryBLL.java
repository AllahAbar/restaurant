package BLL;

import DAL.CategoryDAO;
import DTO.CategoryDTO;
import java.util.ArrayList;

public class CategoryBLL {

    private final CategoryDAO categoryDAO;

    public CategoryBLL() {
        categoryDAO = new CategoryDAO();
    }

    // Lấy tất cả các category
    public ArrayList<CategoryDTO> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    // Thêm category mới
    public boolean addCategory(CategoryDTO category) {
        return categoryDAO.addCategory(category);
    }

    // Cập nhật category
    public boolean updateCategory(CategoryDTO category) {
        return categoryDAO.updateCategory(category);
    }

    // Xóa category theo ID
    public boolean deleteCategory(int categoryID) {
        return categoryDAO.deleteCategory(categoryID);
    }
    
    public CategoryDTO getCategoryByID(int categoryID) {
        return categoryDAO.getCategoryByID(categoryID);
    }
    
    // Trong class CategoryBLL
    public CategoryDTO getCategoryByName(String categoryName) {
        return categoryDAO.getCategoryByName(categoryName);
    }
}
