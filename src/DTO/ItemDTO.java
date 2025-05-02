package DTO;

public class ItemDTO {

    private int itemID;
    private String itemName;
    private String itemDetail;
    private int productMin;
    private double itemPrice;
    private String imageItem;    // Hình ảnh món ăn
    private int categoryID;      // ID phân loại

    // Constructors
    public ItemDTO() {
    }

    public ItemDTO(int itemID, String itemName, String itemDetail, int productMin, double itemPrice, String imageItem, int categoryID) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.productMin = productMin;
        this.itemPrice = itemPrice;
        this.imageItem = imageItem;
        this.categoryID = categoryID;
    }

    // Getters and Setters
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public int getProductMin() {
        return productMin;
    }

    public void setProductMin(int productMin) {
        this.productMin = productMin;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getImageItem() {
        return imageItem;
    }

    public void setImageItem(String imageItem) {
        this.imageItem = imageItem;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    // toString
    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", itemDetail='" + itemDetail + '\'' +
                ", productMin=" + productMin +
                ", itemPrice=" + itemPrice +
                ", imageItem='" + imageItem + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }
}
