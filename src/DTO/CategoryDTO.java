package DTO;

public class CategoryDTO {

    private int categoryID;
    private String categoryName;
    private String imageCategory;

    // Constructors
    public CategoryDTO() {
    }

    public CategoryDTO(int categoryID, String categoryName, String imageCategory) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.imageCategory = imageCategory;
    }

    // Getters and Setters
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(String imageCategory) {
        this.imageCategory = imageCategory;
    }

    // toString
    @Override
    public String toString() {
        return categoryName;
    }
}
