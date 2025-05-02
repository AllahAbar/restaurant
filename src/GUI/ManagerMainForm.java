/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BLL.AccountBLL;
import BLL.CategoryBLL;
import BLL.CustomerBLL;
import BLL.ItemBLL;
import BLL.StaffBLL;
import BLL.TableTopBLL;
import BLL.TransactionBLL;
import BLL.OrderBLL;
import BLL.OrderItemBLL;


import DTO.AccountDTO;
import DTO.CategoryDTO;
import DTO.CustomerDTO;
import DTO.ItemDTO;
import DTO.StaffDTO;
import DTO.TabletopDTO;
import DTO.TransactionDTO;
import DTO.OrderDTO;
import DTO.OrderItemDTO;

import editTable.TableStyleUtil;
import editTable.editPaneTab;
import editTable.editButton;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import java.sql.Timestamp;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;




/**
 *
 * @author PC
 */
public class ManagerMainForm extends javax.swing.JFrame {
    DefaultTableModel staffTableModel;
    DefaultTableModel accountTableModel;
    DefaultTableModel customerTableModel;
    DefaultTableModel tableTop_TableModel;
    DefaultTableModel categoryTableModel;
    DefaultTableModel itemTableModel;
    DefaultTableModel transactionTableModel;
    DefaultTableModel orderTableModel;
    DefaultTableModel itemTableModel1;
         
    
    StaffBLL staffBLL = new StaffBLL();
    AccountBLL accountBLL = new AccountBLL();
    CustomerBLL customerBLL = new CustomerBLL();
    TableTopBLL tableBLL = new TableTopBLL();
    CategoryBLL categoryBLL = new CategoryBLL();
    ItemBLL itemBLL = new ItemBLL();
    TransactionBLL transactionBLL = new TransactionBLL();
    OrderBLL orderBLL = new OrderBLL();

    ItemBLL itemBLL1 = new ItemBLL();
    
    AccountDTO account = new AccountDTO();
    StaffDTO staff = new StaffDTO();
    CustomerDTO customer = new CustomerDTO();
    TabletopDTO table = new TabletopDTO();
    CategoryDTO category = new CategoryDTO();
    ItemDTO item = new ItemDTO();
    TransactionDTO transaction = new TransactionDTO();
    OrderDTO order = new OrderDTO();

    
    private File selectedImageFile;

    
    

    /**
     * Creates new form ManagerMainForm
     */
    public ManagerMainForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //////TabbedPane Edit
////////////////////////////////////////
        editPaneTab.applyCustomStyle(managerTablePane);
        editPaneTab.customizeTabbedPane(managerTablePane);

               
        //////Table Edit
////////////////////////////////////////
        TableStyleUtil.applyTableStyle(customerTable);
        TableStyleUtil.applyTableStyle(accountTable);
        TableStyleUtil.applyTableStyle(staffTable);
        TableStyleUtil.applyTableStyle(tableTop_Table);
        
        TableStyleUtil.applyTableStyle(transactionTable);
        TableStyleUtil.applyTableStyle(orderTable);
        
        
        //////DELETE Button Edit
        ////////////////////////////////////////
        editButton.styleAsDelete(deleteCustomerButton);
        editButton.styleAsDelete(deleteAccountButton);
        editButton.styleAsDelete(deleteButton);
        editButton.styleAsDelete(deleteTableButton);
        editButton.styleAsDelete(deleteCategoryButton);
        editButton.styleAsDelete(deleteItemButton);
        editButton.styleAsDelete(deleteTransactionButton);
        editButton.styleAsDelete(deleteOrderButton);
        
        
        //////ADD Button Edit
        ////////////////////////////////////////
        editButton.styleAsPrimary(addCustomerButton);
        editButton.styleAsPrimary(addAccountButton);
        editButton.styleAsPrimary(addStaffButton);
        editButton.styleAsPrimary(addTableButton);
        editButton.styleAsPrimary(addCategoryButton);
        editButton.styleAsPrimary(addItemButton);
        editButton.styleAsPrimary(addTransactionButton);
        editButton.styleAsPrimary(addOrderButton);
        
        //////UPDATE Button Edit
        ////////////////////////////////////////
        editButton.styleAsSecondary(updateCustomerButton);
        editButton.styleAsSecondary(updateAccountButton);
        editButton.styleAsSecondary(updateButton);
        editButton.styleAsSecondary(updateTableButton);
        editButton.styleAsSecondary(updateCategoryButton);
        editButton.styleAsSecondary(updateItemButton);
        editButton.styleAsSecondary(submitPaymentOrderButton);
        
        //////UPDATE Button Edit
        ////////////////////////////////////////
        editButton.styleAsRefresh(refreshCustomerButton);
        editButton.styleAsRefresh(refreshAccountButton);
        editButton.styleAsRefresh(refreshButton);
        editButton.styleAsRefresh(refreshTableButton);
        editButton.styleAsRefresh(categoryRefreshButton);
        editButton.styleAsRefresh(refreshButton11);
        editButton.styleAsRefresh(refreshTransactionButton);
        editButton.styleAsRefresh(refreshOrderButton);
        
        
        //Table Staff
        staffBLL = new StaffBLL();
        staffTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        staffTable.setModel(staffTableModel);
        staffTableModel.addColumn("Staff ID");
        staffTableModel.addColumn("Name");
        staffTableModel.addColumn("Salary");
        staffTableModel.addColumn("Work years");
        staffTableModel.addColumn("Job");
        setTableDataStaff(staffBLL.getAllStaff());
        
        //Table Account
        accountBLL = new AccountBLL();
        accountTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        accountTable.setModel(accountTableModel);
        accountTableModel.addColumn("Account ID");
        accountTableModel.addColumn("username");
        accountTableModel.addColumn("password");
        accountTableModel.addColumn("role");
        accountTableModel.addColumn("staff ID");
        setTableDataAccount(accountBLL.getAllAccount());
        
        //Table Customer
        customerBLL = new CustomerBLL();
        customerTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        customerTable.setModel(customerTableModel);
        customerTableModel.addColumn("Customer ID");
        customerTableModel.addColumn("First Name");
        customerTableModel.addColumn("Last Name");
        customerTableModel.addColumn("Phone");
        
        setTableDataCustomer(customerBLL.getAllCustomer());
        
        
        //Table Table_top
        tableBLL = new TableTopBLL();
        tableTop_TableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tableTop_Table.setModel(tableTop_TableModel);
        tableTop_TableModel.addColumn("tableID");
        tableTop_TableModel.addColumn("Customer_ID");
        tableTop_TableModel.addColumn("Table_Code");
        tableTop_TableModel.addColumn("Status");
        tableTop_TableModel.addColumn("Capacity");
        tableTop_TableModel.addColumn("Current");
        setTableDataTableTop(tableBLL.getAllTables());
        
        /////Table Category
        categoryBLL = new CategoryBLL();
        categoryTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Tell the table that the image column contains ImageIcon objects
                if (columnIndex == 1) { // The column index of the image column
                    return ImageIcon.class;
                }
                return Object.class;
            }
        };

        categoryTable.setModel(categoryTableModel);
        categoryTableModel.addColumn("Category ID");
        categoryTableModel.addColumn("image");
        categoryTableModel.addColumn("categoryName");

        // Set a custom renderer for image column if needed
        categoryTable.setRowHeight(60); // Adjust row height to better display images
        setTableDataCategory(categoryBLL.getAllCategories());
        

        ///Table Item
        itemBLL = new ItemBLL();
        itemTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Tell the table that the image column contains ImageIcon objects
                if (columnIndex == 5) { // The column index of the image column
                    return ImageIcon.class;
                }
                return Object.class;
            }
        };

        itemTable.setModel(itemTableModel);
        itemTableModel.addColumn("Item ID");
        itemTableModel.addColumn("Item Name");
        itemTableModel.addColumn("Item Detail");
        itemTableModel.addColumn("Product Min");
        itemTableModel.addColumn("Item Price");
        itemTableModel.addColumn("Image");
        itemTableModel.addColumn("category ID");

        // Set a custom renderer for image column if needed
        itemTable.setRowHeight(60); // Adjust row height to better display images
        setTableDataItem(itemBLL.getAllItems());
        
        /////Table Transaction
        transactionBLL = new TransactionBLL();
        transactionTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        transactionTable.setModel(transactionTableModel);
        transactionTableModel.addColumn("Transaction ID");
        transactionTableModel.addColumn("Customer ID");
        transactionTableModel.addColumn("Type");
        transactionTableModel.addColumn("Status");
        transactionTableModel.addColumn("Create At");
        transactionTableModel.addColumn("Order ID");
        transactionTableModel.addColumn("Content ID");
        setTableDataTransaction(transactionBLL.getAllTransactions());
        
        
        //Table Order
        orderBLL = new OrderBLL();
        orderTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }   
        };
        
        orderTable.setModel(orderTableModel);
        orderTableModel.addColumn("Order ID");
        orderTableModel.addColumn("Table ID");
        orderTableModel.addColumn("Customer ID");
        orderTableModel.addColumn("Price");
        orderTableModel.addColumn("Content");
        orderTableModel.addColumn("TransactionID");
        setTableDataOrder(orderBLL.getAllOrders());
        
        
        //////////////////////Table OrderItem//////////////////
        ///////////////////////////
        ///
        itemBLL1 = new ItemBLL();
        itemTableModel1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Tell the table that the image column contains ImageIcon objects
                if (columnIndex == 5) { // The column index of the image column
                    return ImageIcon.class;
                }
                return Object.class;
            }
            
        };

        addProductForOrderTable.setModel(itemTableModel1);
        itemTableModel1.addColumn("Item ID");
        itemTableModel1.addColumn("Item Name");
        itemTableModel1.addColumn("Item Detail");
        itemTableModel1.addColumn("Product Min");
        itemTableModel1.addColumn("Item Price");
        itemTableModel1.addColumn("Image");
        itemTableModel1.addColumn("category ID");
        itemTableModel1.addColumn("quantity");

        // Set a custom renderer for image column if needed
        addProductForOrderTable.setRowHeight(60); // Adjust row height to better display images
        setTableDataItemForOrder(itemBLL1.getAllItems());
    }
    
    
    
    
    private void setTableDataStaff( ArrayList<StaffDTO> staffList){
        for (StaffDTO staff : staffList){
            staffTableModel.addRow(new Object[]{
                staff.getStaffID(),
                staff.getStaffName(),
                staff.getSalary(),
                staff.getWorkYears(),
                staff.getJob()
            });
        }
    }
    
    private void setTableDataAccount( ArrayList<AccountDTO> accountList){
        for (AccountDTO acc : accountList){
            accountTableModel.addRow(new Object[]{
                acc.getAccountID(),
                acc.getUsername(),
                acc.getPassword(),
                acc.getRole(),
                acc.getStaffID()
            });
        }
    }
    
    private void setTableDataCustomer( ArrayList<CustomerDTO> customerList){
        for (CustomerDTO customer : customerList){
            customerTableModel.addRow(new Object[]{
                customer.getCustomerID(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhone()
            });
        }
    }
    
    
    private void setTableDataTableTop( ArrayList<TabletopDTO> tableList){
        for (TabletopDTO table : tableList){
            tableTop_TableModel.addRow(new Object[]{
                table.getTableID(),
                table.getCustomerID(),
                table.getTableCode(),
                table.getStatus(),
                table.getCapacity(),
                table.getCurrent()
            });
        }
    }
    
    private void setTableDataCategory(ArrayList<CategoryDTO> categoryList) {
        categoryTableModel.setRowCount(0); // Xóa dữ liệu cũ

        for (CategoryDTO category : categoryList) {
            ImageIcon imageIcon = null;
            try {
                String fileName = category.getImageCategory(); // Ví dụ: "images/123456789.jpg"
                if (fileName != null && !fileName.isEmpty()) {
                    // Đường dẫn tương đối đến ảnh từ thư mục gốc dự án
                    File imageFile = new File(fileName); // Tức là: src/images/...

                    if (imageFile.exists()) {
                        ImageIcon originalIcon = new ImageIcon(imageFile.getAbsolutePath());
                        Image img = originalIcon.getImage();
                        Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(resizedImg);
                    } else {
                        System.out.println("Không tìm thấy ảnh: " + imageFile.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi load ảnh: " + e.getMessage());
            }

            categoryTableModel.addRow(new Object[]{
                category.getCategoryID(),
                imageIcon,
                category.getCategoryName()
            });
        }
    }
    
    private void setTableDataItem(ArrayList<ItemDTO> itemList) {
        itemTableModel.setRowCount(0); // Xóa dữ liệu cũ

        for (ItemDTO item : itemList) {
            ImageIcon imageItemName = null;
            try {
                String fileName = item.getImageItem(); // Ví dụ: "images/123456789.jpg"
                if (fileName != null && !fileName.isEmpty()) {
                    // Đường dẫn tương đối đến ảnh từ thư mục gốc dự án
                    File imageFile = new File(fileName); // Tức là: src/images/...

                    if (imageFile.exists()) {
                        ImageIcon originalIcon = new ImageIcon(imageFile.getAbsolutePath());
                        Image img = originalIcon.getImage();
                        Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        imageItemName = new ImageIcon(resizedImg);
                    } else {
                        System.out.println("Không tìm thấy ảnh: " + imageFile.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi load ảnh: " + e.getMessage());
            }

            itemTableModel.addRow(new Object[]{
                item.getItemID(),
                item.getItemName(),
                item.getItemDetail(),
                item.getProductMin(),
                item.getItemPrice(),
                imageItemName,
                item.getCategoryID()
            });
        }
    }
    
    private void setTableDataTransaction( ArrayList<TransactionDTO> transactionList){
        for (TransactionDTO tran : transactionList){
            transactionTableModel.addRow(new Object[]{
                tran.getTransactionID(),
                tran.getCustomerID(),
                tran.getType(),
                tran.getStatus(),
                tran.getCreateAt(),
                tran.getOrderID(),
                tran.getContent()
            });
        }
    }

    private void setTableDataOrder( ArrayList<OrderDTO> orderList){
        for (OrderDTO order : orderList){
            orderTableModel.addRow(new Object[]{
                order.getOrderID(),
                order.getTableID(),
                order.getCustomerID(),
                order.getTotalPrice(),
                order.getContent(),
                order.getTransactionID()
            });
        }
    }
    
    
    ////////////
///////
        private void setTableDataItemForOrder(ArrayList<ItemDTO> itemList) {
        itemTableModel1.setRowCount(0); // Xóa dữ liệu cũ

        for (ItemDTO item1 : itemList) {
            ImageIcon imageItemName1 = null;
            try {
                String fileName = item1.getImageItem(); // Ví dụ: "images/123456789.jpg"
                if (fileName != null && !fileName.isEmpty()) {
                    // Đường dẫn tương đối đến ảnh từ thư mục gốc dự án
                    File imageFile = new File(fileName); // Tức là: src/images/...

                    if (imageFile.exists()) {
                        ImageIcon originalIcon = new ImageIcon(imageFile.getAbsolutePath());
                        Image img = originalIcon.getImage();
                        Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        imageItemName1 = new ImageIcon(resizedImg);
                    } else {
                        System.out.println("Không tìm thấy ảnh: " + imageFile.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi load ảnh: " + e.getMessage());
            }

            itemTableModel1.addRow(new Object[]{
                item1.getItemID(),
                item1.getItemName(),
                item1.getItemDetail(),
                item1.getProductMin(),
                item1.getItemPrice(),
                imageItemName1,
                item1.getCategoryID(),
                0
            });
        }
    }
        
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addAccountDialog = new javax.swing.JDialog();
        passwordAccountTextField = new javax.swing.JTextField();
        workyearsLabel = new javax.swing.JLabel();
        ManagerRadioButton = new javax.swing.JRadioButton();
        StaffRadioButton = new javax.swing.JRadioButton();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        tilteLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameAccountTextfield = new javax.swing.JTextField();
        salaryLabel = new javax.swing.JLabel();
        addStaffDialog = new javax.swing.JDialog();
        workyearsTextField = new javax.swing.JTextField();
        jobLabel = new javax.swing.JLabel();
        jobTextField = new javax.swing.JTextField();
        submitButton1 = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        tilteLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        nameStaffTextfield = new javax.swing.JTextField();
        salaryLabel1 = new javax.swing.JLabel();
        salaryTextField = new javax.swing.JTextField();
        workyearsLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        updateAccountDialog = new javax.swing.JDialog();
        updateUserNameAccountTextfield = new javax.swing.JTextField();
        salaryLabel2 = new javax.swing.JLabel();
        updatePasswordAccountTextField = new javax.swing.JTextField();
        updateButton1 = new javax.swing.JButton();
        backButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tilteLabel2 = new javax.swing.JLabel();
        updateIdAccountTextflied = new javax.swing.JTextField();
        nameLabel2 = new javax.swing.JLabel();
        addCustomerDialog = new javax.swing.JDialog();
        salaryLabel3 = new javax.swing.JLabel();
        LastNameTextField = new javax.swing.JTextField();
        workyearsLabel2 = new javax.swing.JLabel();
        PhoneTextField = new javax.swing.JTextField();
        backButton3 = new javax.swing.JButton();
        tilteLabel3 = new javax.swing.JLabel();
        nameLabel3 = new javax.swing.JLabel();
        firstNameTextfield = new javax.swing.JTextField();
        submitButton2 = new javax.swing.JButton();
        updateCustomerDialog = new javax.swing.JDialog();
        updateButton2 = new javax.swing.JButton();
        backButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tilteLabel4 = new javax.swing.JLabel();
        updateIdCustomerTextflied = new javax.swing.JTextField();
        nameLabel4 = new javax.swing.JLabel();
        updateFirstnameCustomerTextfield = new javax.swing.JTextField();
        salaryLabel4 = new javax.swing.JLabel();
        updateLastNameCustomerTextField = new javax.swing.JTextField();
        workyearsLabel3 = new javax.swing.JLabel();
        updateCustomerPhoneTextField = new javax.swing.JTextField();
        updateStaffDialog = new javax.swing.JDialog();
        workyearsTextField1 = new javax.swing.JTextField();
        updateButton3 = new javax.swing.JButton();
        jobLabel1 = new javax.swing.JLabel();
        backButton5 = new javax.swing.JButton();
        jobTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tilteLabel5 = new javax.swing.JLabel();
        idStaffTextflied = new javax.swing.JTextField();
        nameLabel5 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        salaryLabel5 = new javax.swing.JLabel();
        salaryTextField1 = new javax.swing.JTextField();
        workyearsLabel4 = new javax.swing.JLabel();
        addTableDialog = new javax.swing.JDialog();
        workyearsLabel5 = new javax.swing.JLabel();
        addTableStatusTextfield = new javax.swing.JTextField();
        jobLabel2 = new javax.swing.JLabel();
        addTableCapicityTextField = new javax.swing.JTextField();
        addTablesubmitButton = new javax.swing.JButton();
        backButton6 = new javax.swing.JButton();
        tilteLabel6 = new javax.swing.JLabel();
        nameLabel6 = new javax.swing.JLabel();
        salaryLabel6 = new javax.swing.JLabel();
        addTableIDTextField = new javax.swing.JTextField();
        addTableCustomerIDTextField = new javax.swing.JTextField();
        updateTableDialog = new javax.swing.JDialog();
        customerIDTableTextField = new javax.swing.JTextField();
        salaryLabel7 = new javax.swing.JLabel();
        tableCodeTextfield = new javax.swing.JTextField();
        workyearsLabel6 = new javax.swing.JLabel();
        updateButton4 = new javax.swing.JButton();
        jobLabel3 = new javax.swing.JLabel();
        backButton7 = new javax.swing.JButton();
        CapicityTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tilteLabel7 = new javax.swing.JLabel();
        tableIDtextField = new javax.swing.JTextField();
        nameLabel7 = new javax.swing.JLabel();
        statusAvailableTableRadioButton = new javax.swing.JRadioButton();
        statusOccupiedTableRadioButton = new javax.swing.JRadioButton();
        addCategoryDialog = new javax.swing.JDialog();
        addNameCategoryTextField = new javax.swing.JTextField();
        addCategorysubmitButton = new javax.swing.JButton();
        backButton8 = new javax.swing.JButton();
        tilteLabel8 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        workyearsLabel7 = new javax.swing.JLabel();
        fileChoosenButton = new javax.swing.JButton();
        updateCategoryDialog = new javax.swing.JDialog();
        backButton10 = new javax.swing.JButton();
        updateConfirmCategoryButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tilteLabel9 = new javax.swing.JLabel();
        categoryIDtextField = new javax.swing.JTextField();
        salaryLabel8 = new javax.swing.JLabel();
        imageCategoryLabel = new javax.swing.JLabel();
        categoryNameTextfield1 = new javax.swing.JTextField();
        updateChooenImageButton = new javax.swing.JButton();
        addItemDialog = new javax.swing.JDialog();
        addNameItemTextField = new javax.swing.JTextField();
        addCategorysubmitButton1 = new javax.swing.JButton();
        backButton9 = new javax.swing.JButton();
        tilteLabel10 = new javax.swing.JLabel();
        imageLabel1 = new javax.swing.JLabel();
        workyearsLabel8 = new javax.swing.JLabel();
        fileChoosenButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        itemDetailTextField = new javax.swing.JTextField();
        itemProductMinTextField = new javax.swing.JTextField();
        itemPriceTextField = new javax.swing.JTextField();
        itemComboBox = new javax.swing.JComboBox<>();
        updateItemDialog = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        addNameItemTextField1 = new javax.swing.JTextField();
        itemDetailTextField1 = new javax.swing.JTextField();
        updateCategorysubmitButton2 = new javax.swing.JButton();
        itemProductMinTextField1 = new javax.swing.JTextField();
        backButton11 = new javax.swing.JButton();
        itemPriceTextField1 = new javax.swing.JTextField();
        tilteLabel11 = new javax.swing.JLabel();
        itemComboBox1 = new javax.swing.JComboBox<>();
        imageLabel2 = new javax.swing.JLabel();
        workyearsLabel9 = new javax.swing.JLabel();
        fileChoosenButton2 = new javax.swing.JButton();
        itemIDTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        addTransactionDialog = new javax.swing.JDialog();
        submitButton3 = new javax.swing.JButton();
        backButton12 = new javax.swing.JButton();
        tilteLabel12 = new javax.swing.JLabel();
        nameLabel8 = new javax.swing.JLabel();
        CustomerIDTextfield = new javax.swing.JTextField();
        salaryLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nameLabel9 = new javax.swing.JLabel();
        tracsactionByOrderIDTextField = new javax.swing.JTextField();
        contentTransactionTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        PaidRadioButton = new javax.swing.JRadioButton();
        PendingRadioButton = new javax.swing.JRadioButton();
        transactionSpinner = new javax.swing.JSpinner();
        CardRadioButton = new javax.swing.JRadioButton();
        CashRadioButton = new javax.swing.JRadioButton();
        TransactionbuttonGroup = new javax.swing.ButtonGroup();
        addOrderDialog = new javax.swing.JDialog();
        tilteLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TableIDComboBox = new javax.swing.JComboBox<>();
        CustomerIDComboBox = new javax.swing.JComboBox<>();
        choosenProductButton = new javax.swing.JButton();
        orderPriceTextField = new javax.swing.JTextField();
        contentOrderTextField = new javax.swing.JTextField();
        orderSubmitButton = new javax.swing.JButton();
        backButton13 = new javax.swing.JButton();
        addProductForOrderDialog = new javax.swing.JDialog();
        backButton14 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        addProductForOrderTable = new javax.swing.JTable();
        submitOrderItemButton = new javax.swing.JButton();
        tablebuttonGroup = new javax.swing.ButtonGroup();
        CardorCashbuttonGroup = new javax.swing.ButtonGroup();
        managerTablePane = new javax.swing.JTabbedPane();
        customerPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        refreshCustomerButton = new javax.swing.JButton();
        addCustomerButton = new javax.swing.JButton();
        deleteCustomerButton = new javax.swing.JButton();
        updateCustomerButton = new javax.swing.JButton();
        accountPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        addAccountButton = new javax.swing.JButton();
        refreshAccountButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        updateAccountButton = new javax.swing.JButton();
        staffPanel = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addStaffButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        tablePanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTop_Table = new javax.swing.JTable();
        addTableButton = new javax.swing.JButton();
        updateTableButton = new javax.swing.JButton();
        deleteTableButton = new javax.swing.JButton();
        refreshTableButton = new javax.swing.JButton();
        CategoryPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        categoryRefreshButton = new javax.swing.JButton();
        deleteCategoryButton = new javax.swing.JButton();
        addCategoryButton = new javax.swing.JButton();
        updateCategoryButton = new javax.swing.JButton();
        itemPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        refreshButton11 = new javax.swing.JButton();
        addItemButton = new javax.swing.JButton();
        deleteItemButton = new javax.swing.JButton();
        updateItemButton = new javax.swing.JButton();
        TransactionPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        refreshTransactionButton = new javax.swing.JButton();
        addTransactionButton = new javax.swing.JButton();
        deleteTransactionButton = new javax.swing.JButton();
        orderPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        refreshOrderButton = new javax.swing.JButton();
        addOrderButton = new javax.swing.JButton();
        deleteOrderButton = new javax.swing.JButton();
        submitPaymentOrderButton = new javax.swing.JButton();
        statisticalPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();

        addAccountDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addAccountDialog.setModal(true);

        passwordAccountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordAccountTextFieldActionPerformed(evt);
            }
        });

        workyearsLabel.setText("Role");

        buttonGroup1.add(ManagerRadioButton);
        ManagerRadioButton.setText("Manager");
        ManagerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagerRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(StaffRadioButton);
        StaffRadioButton.setText("Staff");

        submitButton.setText("Xác nhận");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setText("Trở lại");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        tilteLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel.setText("Tạo tài khoản");

        nameLabel.setText("Tài khoản");

        nameAccountTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAccountTextfieldActionPerformed(evt);
            }
        });

        salaryLabel.setText("Mật khẩu");

        javax.swing.GroupLayout addAccountDialogLayout = new javax.swing.GroupLayout(addAccountDialog.getContentPane());
        addAccountDialog.getContentPane().setLayout(addAccountDialogLayout);
        addAccountDialogLayout.setHorizontalGroup(
            addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAccountDialogLayout.createSequentialGroup()
                .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addAccountDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel)
                            .addComponent(workyearsLabel)
                            .addComponent(salaryLabel))
                        .addGap(33, 33, 33)
                        .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordAccountTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameAccountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(submitButton)
                                .addGroup(addAccountDialogLayout.createSequentialGroup()
                                    .addComponent(ManagerRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(StaffRadioButton))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addAccountDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tilteLabel)
                        .addGap(134, 134, 134)))
                .addComponent(backButton)
                .addGap(23, 23, 23))
        );
        addAccountDialogLayout.setVerticalGroup(
            addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAccountDialogLayout.createSequentialGroup()
                .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addAccountDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(addAccountDialogLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(tilteLabel)))
                .addGap(36, 36, 36)
                .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameAccountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordAccountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel))
                .addGap(18, 18, 18)
                .addGroup(addAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workyearsLabel)
                    .addComponent(ManagerRadioButton)
                    .addComponent(StaffRadioButton))
                .addGap(44, 44, 44)
                .addComponent(submitButton)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        addStaffDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addStaffDialog.setModal(true);

        jobLabel.setText("Công việc");

        jobTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTextFieldActionPerformed(evt);
            }
        });

        submitButton1.setText("Xác nhận");
        submitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton1ActionPerformed(evt);
            }
        });

        backButton1.setText("Trở lại");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        tilteLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel1.setText("Thêm mới nhân viên");

        nameLabel1.setText("Tên");

        nameStaffTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameStaffTextfieldActionPerformed(evt);
            }
        });

        salaryLabel1.setText("Lương");

        salaryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTextFieldActionPerformed(evt);
            }
        });

        workyearsLabel1.setText("Kinh nghiệm");

        javax.swing.GroupLayout addStaffDialogLayout = new javax.swing.GroupLayout(addStaffDialog.getContentPane());
        addStaffDialog.getContentPane().setLayout(addStaffDialogLayout);
        addStaffDialogLayout.setHorizontalGroup(
            addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStaffDialogLayout.createSequentialGroup()
                .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStaffDialogLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(tilteLabel1))
                    .addGroup(addStaffDialogLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(nameLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(nameStaffTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addStaffDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(workyearsLabel1)
                            .addComponent(salaryLabel1)
                            .addComponent(jobLabel))
                        .addGap(35, 35, 35)
                        .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salaryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(workyearsTextField)
                            .addComponent(jobTextField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton1)
                .addGap(23, 23, 23))
            .addGroup(addStaffDialogLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(submitButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addStaffDialogLayout.setVerticalGroup(
            addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStaffDialogLayout.createSequentialGroup()
                .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStaffDialogLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(tilteLabel1))
                    .addGroup(addStaffDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton1)))
                .addGap(34, 34, 34)
                .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel1)
                    .addComponent(nameStaffTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel1))
                .addGap(18, 18, 18)
                .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workyearsLabel1)
                    .addComponent(workyearsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel)
                    .addComponent(jobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(submitButton1)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        updateAccountDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        updateAccountDialog.setModal(true);

        updateUserNameAccountTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserNameAccountTextfieldActionPerformed(evt);
            }
        });

        salaryLabel2.setText("Mật khẩu");

        updatePasswordAccountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordAccountTextFieldActionPerformed(evt);
            }
        });

        updateButton1.setText("Xác nhận");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });

        backButton2.setText("Trở lại");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        tilteLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel2.setText("Cập nhật tài khoản");

        updateIdAccountTextflied.setEditable(false);
        updateIdAccountTextflied.setEnabled(false);

        nameLabel2.setText("Tài khoản");

        javax.swing.GroupLayout updateAccountDialogLayout = new javax.swing.GroupLayout(updateAccountDialog.getContentPane());
        updateAccountDialog.getContentPane().setLayout(updateAccountDialogLayout);
        updateAccountDialogLayout.setHorizontalGroup(
            updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateAccountDialogLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(tilteLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(backButton2)
                .addGap(23, 23, 23))
            .addGroup(updateAccountDialogLayout.createSequentialGroup()
                .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateAccountDialogLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salaryLabel2)
                            .addComponent(nameLabel2)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateUserNameAccountTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(updatePasswordAccountTextField)
                            .addComponent(updateIdAccountTextflied)))
                    .addGroup(updateAccountDialogLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(updateButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        updateAccountDialogLayout.setVerticalGroup(
            updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateAccountDialogLayout.createSequentialGroup()
                .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateAccountDialogLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(tilteLabel2))
                    .addGroup(updateAccountDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton2)))
                .addGap(31, 31, 31)
                .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(updateIdAccountTextflied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel2)
                    .addComponent(updateUserNameAccountTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(updateAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatePasswordAccountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel2))
                .addGap(70, 70, 70)
                .addComponent(updateButton1)
                .addGap(99, 99, 99))
        );

        addCustomerDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addCustomerDialog.setModal(true);

        salaryLabel3.setText("Tên");

        LastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameTextFieldActionPerformed(evt);
            }
        });

        workyearsLabel2.setText("SĐT");

        backButton3.setText("Trở lại");
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });

        tilteLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel3.setText("Thêm mới khách hàng");

        nameLabel3.setText("Họ");

        firstNameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextfieldActionPerformed(evt);
            }
        });

        submitButton2.setText("Xác nhận");
        submitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addCustomerDialogLayout = new javax.swing.GroupLayout(addCustomerDialog.getContentPane());
        addCustomerDialog.getContentPane().setLayout(addCustomerDialogLayout);
        addCustomerDialogLayout.setHorizontalGroup(
            addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerDialogLayout.createSequentialGroup()
                .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCustomerDialogLayout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel3)
                            .addComponent(workyearsLabel2)
                            .addComponent(salaryLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(PhoneTextField))
                            .addComponent(firstNameTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCustomerDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tilteLabel3)
                        .addGap(76, 76, 76)))
                .addComponent(backButton3)
                .addGap(23, 23, 23))
            .addGroup(addCustomerDialogLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(submitButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addCustomerDialogLayout.setVerticalGroup(
            addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerDialogLayout.createSequentialGroup()
                .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCustomerDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton3))
                    .addGroup(addCustomerDialogLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(tilteLabel3)))
                .addGap(33, 33, 33)
                .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel3)
                    .addComponent(firstNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel3))
                .addGap(18, 18, 18)
                .addGroup(addCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workyearsLabel2))
                .addGap(40, 40, 40)
                .addComponent(submitButton2)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        updateCustomerDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        updateCustomerDialog.setModal(true);

        updateButton2.setText("Xác nhận");
        updateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton2ActionPerformed(evt);
            }
        });

        backButton4.setText("Trở lại");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID nhân viên");

        tilteLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel4.setText("Cập nhật khách hàng");

        updateIdCustomerTextflied.setEditable(false);
        updateIdCustomerTextflied.setEnabled(false);
        updateIdCustomerTextflied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateIdCustomerTextfliedActionPerformed(evt);
            }
        });

        nameLabel4.setText("Họ");

        updateFirstnameCustomerTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFirstnameCustomerTextfieldActionPerformed(evt);
            }
        });

        salaryLabel4.setText("Tên");

        updateLastNameCustomerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLastNameCustomerTextFieldActionPerformed(evt);
            }
        });

        workyearsLabel3.setText("Số điện thoại");

        javax.swing.GroupLayout updateCustomerDialogLayout = new javax.swing.GroupLayout(updateCustomerDialog.getContentPane());
        updateCustomerDialog.getContentPane().setLayout(updateCustomerDialogLayout);
        updateCustomerDialogLayout.setHorizontalGroup(
            updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                        .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(workyearsLabel3)
                                    .addComponent(salaryLabel4)
                                    .addComponent(nameLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateFirstnameCustomerTextfield)
                                    .addComponent(updateLastNameCustomerTextField)
                                    .addComponent(updateCustomerPhoneTextField)
                                    .addComponent(updateIdCustomerTextflied, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(updateButton2)))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(tilteLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton4)
                        .addGap(18, 18, 18))))
        );
        updateCustomerDialogLayout.setVerticalGroup(
            updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(tilteLabel4))
                    .addGroup(updateCustomerDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton4)))
                .addGap(31, 31, 31)
                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(updateIdCustomerTextflied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel4)
                    .addComponent(updateFirstnameCustomerTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateLastNameCustomerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel4))
                .addGap(18, 18, 18)
                .addGroup(updateCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workyearsLabel3)
                    .addComponent(updateCustomerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(updateButton2)
                .addGap(52, 52, 52))
        );

        updateStaffDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        updateStaffDialog.setModal(true);

        updateButton3.setText("Xác nhận");
        updateButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton3ActionPerformed(evt);
            }
        });

        jobLabel1.setText("Công việc");

        backButton5.setText("Trở lại");
        backButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton5ActionPerformed(evt);
            }
        });

        jobTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("ID nhân viên");

        tilteLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel5.setText("Cập nhật nhân viên");

        idStaffTextflied.setEditable(false);
        idStaffTextflied.setEnabled(false);

        nameLabel5.setText("Tên");

        nameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextfieldActionPerformed(evt);
            }
        });

        salaryLabel5.setText("Lương");

        salaryTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTextField1ActionPerformed(evt);
            }
        });

        workyearsLabel4.setText("Kinh nghiệm");

        javax.swing.GroupLayout updateStaffDialogLayout = new javax.swing.GroupLayout(updateStaffDialog.getContentPane());
        updateStaffDialog.getContentPane().setLayout(updateStaffDialogLayout);
        updateStaffDialogLayout.setHorizontalGroup(
            updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateStaffDialogLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(tilteLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(backButton5)
                .addGap(23, 23, 23))
            .addGroup(updateStaffDialogLayout.createSequentialGroup()
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateStaffDialogLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(workyearsLabel4)
                            .addComponent(salaryLabel5)
                            .addComponent(jobLabel1)
                            .addComponent(nameLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(salaryTextField1)
                            .addComponent(workyearsTextField1)
                            .addComponent(jobTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(idStaffTextflied)))
                    .addGroup(updateStaffDialogLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3))
                    .addGroup(updateStaffDialogLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(updateButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        updateStaffDialogLayout.setVerticalGroup(
            updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateStaffDialogLayout.createSequentialGroup()
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateStaffDialogLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(tilteLabel5))
                    .addGroup(updateStaffDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton5)))
                .addGap(31, 31, 31)
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idStaffTextflied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel5)
                    .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel5))
                .addGap(18, 18, 18)
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workyearsLabel4)
                    .addComponent(workyearsTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateStaffDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel1)
                    .addComponent(jobTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(updateButton3)
                .addGap(52, 52, 52))
        );

        addTableDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addTableDialog.setModal(true);

        workyearsLabel5.setText("Trạng thái");

        addTableStatusTextfield.setEditable(false);

        jobLabel2.setText("Số lượng người tối đa");

        addTableCapicityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTableCapicityTextFieldActionPerformed(evt);
            }
        });

        addTablesubmitButton.setText("Xác nhận");
        addTablesubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTablesubmitButtonActionPerformed(evt);
            }
        });

        backButton6.setText("Trở lại");
        backButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton6ActionPerformed(evt);
            }
        });

        tilteLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel6.setText("Thêm bàn");

        nameLabel6.setText("ID  khách hàng");

        salaryLabel6.setText("Mã bàn");

        addTableCustomerIDTextField.setEditable(false);
        addTableCustomerIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTableCustomerIDTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addTableDialogLayout = new javax.swing.GroupLayout(addTableDialog.getContentPane());
        addTableDialog.getContentPane().setLayout(addTableDialogLayout);
        addTableDialogLayout.setHorizontalGroup(
            addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTableDialogLayout.createSequentialGroup()
                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTableDialogLayout.createSequentialGroup()
                        .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addTableDialogLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workyearsLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(salaryLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jobLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(addTableDialogLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(nameLabel6)))
                        .addGap(44, 44, 44)
                        .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addTableIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(addTableStatusTextfield)
                                .addComponent(addTableCapicityTextField))
                            .addComponent(addTableCustomerIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTableDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tilteLabel6)
                        .addGap(191, 191, 191)))
                .addComponent(backButton6)
                .addGap(23, 23, 23))
            .addGroup(addTableDialogLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(addTablesubmitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addTableDialogLayout.setVerticalGroup(
            addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTableDialogLayout.createSequentialGroup()
                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTableDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton6))
                    .addGroup(addTableDialogLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tilteLabel6)))
                .addGap(47, 47, 47)
                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTableCustomerIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTableIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel6))
                .addGap(18, 18, 18)
                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workyearsLabel5)
                    .addComponent(addTableStatusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel2)
                    .addComponent(addTableCapicityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(addTablesubmitButton)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        updateTableDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        updateTableDialog.setModal(true);

        customerIDTableTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDTableTextFieldActionPerformed(evt);
            }
        });

        salaryLabel7.setText("Mã bàn");

        tableCodeTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableCodeTextfieldActionPerformed(evt);
            }
        });

        workyearsLabel6.setText("Trạng thái");

        updateButton4.setText("Xác nhận");
        updateButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton4ActionPerformed(evt);
            }
        });

        jobLabel3.setText("Số người tối đa");

        backButton7.setText("Trở lại");
        backButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton7ActionPerformed(evt);
            }
        });

        CapicityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapicityTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Table ID");

        tilteLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel7.setText("Cập nhật bàn");

        tableIDtextField.setEditable(false);
        tableIDtextField.setEnabled(false);

        nameLabel7.setText("CustomerID");

        tablebuttonGroup.add(statusAvailableTableRadioButton);
        statusAvailableTableRadioButton.setText("Available");

        tablebuttonGroup.add(statusOccupiedTableRadioButton);
        statusOccupiedTableRadioButton.setText("Occupied");

        javax.swing.GroupLayout updateTableDialogLayout = new javax.swing.GroupLayout(updateTableDialog.getContentPane());
        updateTableDialog.getContentPane().setLayout(updateTableDialogLayout);
        updateTableDialogLayout.setHorizontalGroup(
            updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateTableDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tilteLabel7)
                .addGap(145, 145, 145)
                .addComponent(backButton7)
                .addGap(23, 23, 23))
            .addGroup(updateTableDialogLayout.createSequentialGroup()
                .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateTableDialogLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(updateButton4))
                    .addGroup(updateTableDialogLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(workyearsLabel6)
                            .addComponent(salaryLabel7)
                            .addComponent(jobLabel3)
                            .addComponent(nameLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(customerIDTableTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(tableCodeTextfield)
                                .addComponent(CapicityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                            .addComponent(tableIDtextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(updateTableDialogLayout.createSequentialGroup()
                                .addComponent(statusAvailableTableRadioButton)
                                .addGap(41, 41, 41)
                                .addComponent(statusOccupiedTableRadioButton)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        updateTableDialogLayout.setVerticalGroup(
            updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateTableDialogLayout.createSequentialGroup()
                .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateTableDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton7))
                    .addGroup(updateTableDialogLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tilteLabel7)))
                .addGap(18, 18, 18)
                .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateTableDialogLayout.createSequentialGroup()
                        .addComponent(tableIDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel7)
                            .addComponent(customerIDTableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tableCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salaryLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(workyearsLabel6)
                            .addComponent(statusAvailableTableRadioButton)
                            .addComponent(statusOccupiedTableRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(updateTableDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobLabel3)
                            .addComponent(CapicityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(updateButton4)
                        .addGap(52, 52, 52))
                    .addGroup(updateTableDialogLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        addCategoryDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addCategoryDialog.setModal(true);

        addCategorysubmitButton.setText("Xác nhận");
        addCategorysubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategorysubmitButtonActionPerformed(evt);
            }
        });

        backButton8.setText("Trở lại");
        backButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton8ActionPerformed(evt);
            }
        });

        tilteLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel8.setText("Thêm thể loại");

        workyearsLabel7.setText("Tên thể loại");

        fileChoosenButton.setText("Chọn thư mục");
        fileChoosenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChoosenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addCategoryDialogLayout = new javax.swing.GroupLayout(addCategoryDialog.getContentPane());
        addCategoryDialog.getContentPane().setLayout(addCategoryDialogLayout);
        addCategoryDialogLayout.setHorizontalGroup(
            addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategoryDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tilteLabel8)
                .addGap(170, 170, 170)
                .addComponent(backButton8)
                .addGap(23, 23, 23))
            .addGroup(addCategoryDialogLayout.createSequentialGroup()
                .addGroup(addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCategoryDialogLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(addCategorysubmitButton))
                    .addGroup(addCategoryDialogLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addCategoryDialogLayout.createSequentialGroup()
                                .addComponent(workyearsLabel7)
                                .addGap(25, 25, 25)
                                .addComponent(addNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addCategoryDialogLayout.createSequentialGroup()
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fileChoosenButton)))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        addCategoryDialogLayout.setVerticalGroup(
            addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategoryDialogLayout.createSequentialGroup()
                .addGroup(addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCategoryDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton8))
                    .addGroup(addCategoryDialogLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(tilteLabel8)))
                .addGap(42, 42, 42)
                .addGroup(addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCategoryDialogLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCategoryDialogLayout.createSequentialGroup()
                        .addGroup(addCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addNameCategoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workyearsLabel7))
                        .addGap(65, 65, 65)
                        .addComponent(fileChoosenButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(addCategorysubmitButton)
                .addGap(52, 52, 52))
        );

        updateCategoryDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        updateCategoryDialog.setModal(true);

        backButton10.setText("Trở về");
        backButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton10ActionPerformed(evt);
            }
        });

        updateConfirmCategoryButton1.setText("Xác nhận");
        updateConfirmCategoryButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateConfirmCategoryButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Category ID");

        tilteLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel9.setText("Cập nhật thể loại");

        categoryIDtextField.setEditable(false);
        categoryIDtextField.setEnabled(false);

        salaryLabel8.setText("Tên thể loại");

        categoryNameTextfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryNameTextfield1ActionPerformed(evt);
            }
        });

        updateChooenImageButton.setText("Chọn hình");
        updateChooenImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateChooenImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updateCategoryDialogLayout = new javax.swing.GroupLayout(updateCategoryDialog.getContentPane());
        updateCategoryDialog.getContentPane().setLayout(updateCategoryDialogLayout);
        updateCategoryDialogLayout.setHorizontalGroup(
            updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateCategoryDialogLayout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addComponent(backButton10)
                .addGap(34, 34, 34))
            .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel8)
                    .addComponent(imageCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryNameTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryIDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(updateChooenImageButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                    .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                            .addGap(205, 205, 205)
                            .addComponent(updateConfirmCategoryButton1))
                        .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                            .addGap(203, 203, 203)
                            .addComponent(tilteLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(194, Short.MAX_VALUE)))
        );
        updateCategoryDialogLayout.setVerticalGroup(
            updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backButton10)
                .addGap(48, 48, 48)
                .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryIDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryNameTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryLabel8))
                .addGap(25, 25, 25)
                .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(updateChooenImageButton)))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(updateCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(updateCategoryDialogLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(tilteLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                    .addComponent(updateConfirmCategoryButton1)
                    .addGap(106, 106, 106)))
        );

        addItemDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addItemDialog.setModal(true);

        addCategorysubmitButton1.setText("Xác nhận");
        addCategorysubmitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategorysubmitButton1ActionPerformed(evt);
            }
        });

        backButton9.setText("Trở lại");
        backButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton9ActionPerformed(evt);
            }
        });

        tilteLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel10.setText("Thêm sản phẩm");

        workyearsLabel8.setText("Tên sản phẩm");

        fileChoosenButton1.setText("Chọn thư mục");
        fileChoosenButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChoosenButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Thông tin sản phẩm");

        jLabel7.setText("Số lượng tồn kho");

        jLabel8.setText("Giá thành");

        jLabel9.setText("Thể loại");

        javax.swing.GroupLayout addItemDialogLayout = new javax.swing.GroupLayout(addItemDialog.getContentPane());
        addItemDialog.getContentPane().setLayout(addItemDialogLayout);
        addItemDialogLayout.setHorizontalGroup(
            addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemDialogLayout.createSequentialGroup()
                .addGap(0, 229, Short.MAX_VALUE)
                .addComponent(tilteLabel10)
                .addGap(170, 170, 170)
                .addComponent(backButton9)
                .addGap(23, 23, 23))
            .addGroup(addItemDialogLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(workyearsLabel8)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addItemDialogLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(fileChoosenButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(addItemDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(itemDetailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addNameItemTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(itemProductMinTextField)
                                .addComponent(itemPriceTextField))
                            .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(addItemDialogLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(addCategorysubmitButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addItemDialogLayout.setVerticalGroup(
            addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemDialogLayout.createSequentialGroup()
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addItemDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton9))
                    .addGroup(addItemDialogLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(tilteLabel10)))
                .addGap(42, 42, 42)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNameItemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workyearsLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(itemDetailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(itemProductMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(itemPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addItemDialogLayout.createSequentialGroup()
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addItemDialogLayout.createSequentialGroup()
                        .addComponent(fileChoosenButton1)
                        .addGap(51, 51, 51)
                        .addComponent(addCategorysubmitButton1)
                        .addContainerGap())))
        );

        updateItemDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        updateItemDialog.setModal(true);

        jLabel10.setText("Thông tin sản phẩm");

        jLabel11.setText("Số lượng tồn kho");

        jLabel12.setText("Giá thành");

        jLabel13.setText("Thể loại");

        updateCategorysubmitButton2.setText("Xác nhận");
        updateCategorysubmitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCategorysubmitButton2ActionPerformed(evt);
            }
        });

        backButton11.setText("Trở lại");
        backButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton11ActionPerformed(evt);
            }
        });

        tilteLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel11.setText("Cập nhật sản phẩm");

        workyearsLabel9.setText("Tên sản phẩm");

        fileChoosenButton2.setText("Chọn thư mục");
        fileChoosenButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChoosenButton2ActionPerformed(evt);
            }
        });

        itemIDTextField.setEditable(false);

        jLabel14.setText("ID sản phẩm");

        javax.swing.GroupLayout updateItemDialogLayout = new javax.swing.GroupLayout(updateItemDialog.getContentPane());
        updateItemDialog.getContentPane().setLayout(updateItemDialogLayout);
        updateItemDialogLayout.setHorizontalGroup(
            updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateItemDialogLayout.createSequentialGroup()
                .addGap(0, 229, Short.MAX_VALUE)
                .addComponent(tilteLabel11)
                .addGap(163, 163, 163)
                .addComponent(backButton11)
                .addGap(23, 23, 23))
            .addGroup(updateItemDialogLayout.createSequentialGroup()
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateItemDialogLayout.createSequentialGroup()
                        .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateItemDialogLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(workyearsLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateItemDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))
                        .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileChoosenButton2)
                            .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(itemDetailTextField1)
                                .addComponent(addNameItemTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(itemProductMinTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(itemPriceTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(itemComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(itemIDTextField))))
                    .addGroup(updateItemDialogLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(updateCategorysubmitButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        updateItemDialogLayout.setVerticalGroup(
            updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateItemDialogLayout.createSequentialGroup()
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateItemDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton11))
                    .addGroup(updateItemDialogLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(tilteLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(8, 8, 8)
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNameItemTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workyearsLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(itemDetailTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(itemProductMinTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(itemPriceTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(itemComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(updateItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateItemDialogLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updateItemDialogLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(fileChoosenButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(updateCategorysubmitButton2)
                .addGap(20, 20, 20))
        );

        addTransactionDialog.setMinimumSize(new java.awt.Dimension(700, 700));
        addTransactionDialog.setModal(true);

        submitButton3.setText("Xác nhận");
        submitButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton3ActionPerformed(evt);
            }
        });

        backButton12.setText("Trở lại");
        backButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton12ActionPerformed(evt);
            }
        });

        tilteLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel12.setText("Tạo hóa đơn");

        nameLabel8.setText("Mã khách hàng");

        CustomerIDTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerIDTextfieldActionPerformed(evt);
            }
        });

        salaryLabel9.setText("Loại thanh toán");

        jLabel15.setText("Trạng thái thanh toán");

        jLabel16.setText("Ngày tạo");

        nameLabel9.setText("Mã đơn hàng");

        jLabel17.setText("Tiêu đề");

        TransactionbuttonGroup.add(PaidRadioButton);
        PaidRadioButton.setText("Đã thanh toán");

        TransactionbuttonGroup.add(PendingRadioButton);
        PendingRadioButton.setText("Chưa thanh toán");

        transactionSpinner.setModel(new javax.swing.SpinnerDateModel());

        CardorCashbuttonGroup.add(CardRadioButton);
        CardRadioButton.setText("Thẻ");

        CardorCashbuttonGroup.add(CashRadioButton);
        CashRadioButton.setText("Tiền mặt");

        javax.swing.GroupLayout addTransactionDialogLayout = new javax.swing.GroupLayout(addTransactionDialog.getContentPane());
        addTransactionDialog.getContentPane().setLayout(addTransactionDialogLayout);
        addTransactionDialogLayout.setHorizontalGroup(
            addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTransactionDialogLayout.createSequentialGroup()
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTransactionDialogLayout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salaryLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tracsactionByOrderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contentTransactionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addTransactionDialogLayout.createSequentialGroup()
                                .addComponent(PaidRadioButton)
                                .addGap(27, 27, 27)
                                .addComponent(PendingRadioButton))
                            .addComponent(transactionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addTransactionDialogLayout.createSequentialGroup()
                                .addComponent(CardRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CashRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTransactionDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tilteLabel12)
                        .addGap(134, 134, 134)))
                .addComponent(backButton12)
                .addGap(23, 23, 23))
            .addGroup(addTransactionDialogLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(submitButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addTransactionDialogLayout.setVerticalGroup(
            addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTransactionDialogLayout.createSequentialGroup()
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTransactionDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton12))
                    .addGroup(addTransactionDialogLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(tilteLabel12)))
                .addGap(18, 18, 18)
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryLabel9)
                    .addComponent(CardRadioButton)
                    .addComponent(CashRadioButton))
                .addGap(13, 13, 13)
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(PaidRadioButton)
                    .addComponent(PendingRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(transactionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel9)
                    .addComponent(tracsactionByOrderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(addTransactionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contentTransactionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitButton3)
                .addGap(15, 15, 15))
        );

        addOrderDialog.setMinimumSize(new java.awt.Dimension(700, 700));
        addOrderDialog.setModal(true);

        tilteLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tilteLabel13.setText("Tạo yêu cầu");

        jLabel18.setText("Table ID");

        jLabel19.setText("Mã số khách hàng");

        jLabel20.setText("Giá");

        jLabel21.setText("Thông tin");

        TableIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CustomerIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        choosenProductButton.setText("Chọn món");
        choosenProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosenProductButtonActionPerformed(evt);
            }
        });

        orderPriceTextField.setEditable(false);

        orderSubmitButton.setText("Xác nhận");
        orderSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderSubmitButtonActionPerformed(evt);
            }
        });

        backButton13.setText("Trở về");
        backButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addOrderDialogLayout = new javax.swing.GroupLayout(addOrderDialog.getContentPane());
        addOrderDialog.getContentPane().setLayout(addOrderDialogLayout);
        addOrderDialogLayout.setHorizontalGroup(
            addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderDialogLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21))
                .addGap(30, 30, 30)
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentOrderTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addOrderDialogLayout.createSequentialGroup()
                        .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addOrderDialogLayout.createSequentialGroup()
                                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TableIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(addOrderDialogLayout.createSequentialGroup()
                                .addComponent(orderPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(choosenProductButton)))
                .addGap(42, 42, 42))
            .addGroup(addOrderDialogLayout.createSequentialGroup()
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderDialogLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(tilteLabel13))
                    .addGroup(addOrderDialogLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(orderSubmitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addOrderDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton13)
                .addContainerGap())
        );
        addOrderDialogLayout.setVerticalGroup(
            addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton13)
                .addGap(1, 1, 1)
                .addComponent(tilteLabel13)
                .addGap(18, 18, 18)
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TableIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(CustomerIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(choosenProductButton)
                    .addComponent(orderPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(addOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(contentOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(orderSubmitButton)
                .addGap(38, 38, 38))
        );

        addProductForOrderDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        addProductForOrderDialog.setModal(true);

        backButton14.setText("Trở về");
        backButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton14ActionPerformed(evt);
            }
        });

        addProductForOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(addProductForOrderTable);

        submitOrderItemButton.setText("Xác nhận");
        submitOrderItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitOrderItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addProductForOrderDialogLayout = new javax.swing.GroupLayout(addProductForOrderDialog.getContentPane());
        addProductForOrderDialog.getContentPane().setLayout(addProductForOrderDialogLayout);
        addProductForOrderDialogLayout.setHorizontalGroup(
            addProductForOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductForOrderDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addProductForOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductForOrderDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton14))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(addProductForOrderDialogLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(submitOrderItemButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addProductForOrderDialogLayout.setVerticalGroup(
            addProductForOrderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductForOrderDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitOrderItemButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager");

        managerTablePane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(customerTable);

        refreshCustomerButton.setText("Tải lại");
        refreshCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCustomerButtonActionPerformed(evt);
            }
        });

        addCustomerButton.setText("Thêm mới");
        addCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerButtonActionPerformed(evt);
            }
        });

        deleteCustomerButton.setText("Xóa");
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
            }
        });

        updateCustomerButton.setText("Sửa");
        updateCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                        .addComponent(addCustomerButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateCustomerButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCustomerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshCustomerButton)
                        .addContainerGap())))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshCustomerButton)
                    .addComponent(addCustomerButton)
                    .addComponent(deleteCustomerButton)
                    .addComponent(updateCustomerButton))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Khách hàng", customerPanel);

        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(accountTable);

        addAccountButton.setText("Thêm mới");
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountButtonActionPerformed(evt);
            }
        });

        refreshAccountButton.setText("Tải lại");
        refreshAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAccountButtonActionPerformed(evt);
            }
        });

        deleteAccountButton.setText("Xóa");
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountButtonActionPerformed(evt);
            }
        });

        updateAccountButton.setText("Sửa");
        updateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(accountPanelLayout.createSequentialGroup()
                        .addComponent(addAccountButton)
                        .addGap(13, 13, 13)
                        .addComponent(updateAccountButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteAccountButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshAccountButton)
                        .addGap(22, 22, 22))))
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAccountButton)
                    .addComponent(refreshAccountButton)
                    .addComponent(deleteAccountButton)
                    .addComponent(updateAccountButton))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Tài khoản", accountPanel);

        refreshButton.setBackground(new java.awt.Color(204, 204, 204));
        refreshButton.setText("Tải lại");
        refreshButton.setPreferredSize(new java.awt.Dimension(83, 23));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(51, 255, 51));
        updateButton.setText("Sửa");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addStaffButton.setBackground(new java.awt.Color(0, 255, 255));
        addStaffButton.setText("Thêm mới");
        addStaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffButtonActionPerformed(evt);
            }
        });

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staffTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        staffTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        staffTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(staffTable);

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addComponent(addStaffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStaffButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Nhân viên", staffPanel);

        tableTop_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTop_Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableTop_Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tableTop_Table);

        addTableButton.setBackground(new java.awt.Color(0, 255, 255));
        addTableButton.setText("Thêm mới");
        addTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTableButtonActionPerformed(evt);
            }
        });

        updateTableButton.setBackground(new java.awt.Color(51, 255, 51));
        updateTableButton.setText("Sửa");
        updateTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTableButtonActionPerformed(evt);
            }
        });

        deleteTableButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteTableButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteTableButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteTableButton.setText("Xóa");
        deleteTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTableButtonActionPerformed(evt);
            }
        });

        refreshTableButton.setBackground(new java.awt.Color(204, 204, 204));
        refreshTableButton.setText("Tải lại");
        refreshTableButton.setPreferredSize(new java.awt.Dimension(83, 23));
        refreshTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(updateTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTableButton)
                    .addComponent(updateTableButton)
                    .addComponent(deleteTableButton)
                    .addComponent(refreshTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Bàn ăn", tablePanel);

        CategoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(categoryTable);

        categoryRefreshButton.setText("Tải lại");
        categoryRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryRefreshButtonActionPerformed(evt);
            }
        });

        deleteCategoryButton.setText("Xóa");
        deleteCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryButtonActionPerformed(evt);
            }
        });

        addCategoryButton.setText("Thêm");
        addCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryButtonActionPerformed(evt);
            }
        });

        updateCategoryButton.setText("Sửa");
        updateCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CategoryPanelLayout = new javax.swing.GroupLayout(CategoryPanel);
        CategoryPanel.setLayout(CategoryPanelLayout);
        CategoryPanelLayout.setHorizontalGroup(
            CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryPanelLayout.createSequentialGroup()
                .addComponent(addCategoryButton)
                .addGap(12, 12, 12)
                .addComponent(updateCategoryButton)
                .addGap(18, 18, 18)
                .addComponent(deleteCategoryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                .addComponent(categoryRefreshButton)
                .addContainerGap())
            .addComponent(jScrollPane5)
        );
        CategoryPanelLayout.setVerticalGroup(
            CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryRefreshButton)
                    .addComponent(deleteCategoryButton)
                    .addComponent(addCategoryButton)
                    .addComponent(updateCategoryButton))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        deleteCategoryButton.getAccessibleContext().setAccessibleName("");

        managerTablePane.addTab("Thể loại", CategoryPanel);

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(itemTable);

        refreshButton11.setText("Tải lại");
        refreshButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButton11ActionPerformed(evt);
            }
        });

        addItemButton.setText("Thêm");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        deleteItemButton.setText("Xóa");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        updateItemButton.setText("Sửa");
        updateItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(itemPanel);
        itemPanel.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addComponent(addItemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateItemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteItemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshButton11)
                .addContainerGap())
        );
        itemPanelLayout.setVerticalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton11)
                    .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addItemButton)
                        .addComponent(deleteItemButton)
                        .addComponent(updateItemButton)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Thực phẩm", itemPanel);

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(transactionTable);

        refreshTransactionButton.setText("Tải lại");
        refreshTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTransactionButtonActionPerformed(evt);
            }
        });

        addTransactionButton.setText("Thêm");
        addTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransactionButtonActionPerformed(evt);
            }
        });

        deleteTransactionButton.setText("Xóa");
        deleteTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTransactionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransactionPanelLayout = new javax.swing.GroupLayout(TransactionPanel);
        TransactionPanel.setLayout(TransactionPanelLayout);
        TransactionPanelLayout.setHorizontalGroup(
            TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(TransactionPanelLayout.createSequentialGroup()
                .addComponent(addTransactionButton)
                .addGap(93, 93, 93)
                .addComponent(deleteTransactionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshTransactionButton)
                .addContainerGap())
        );
        TransactionPanelLayout.setVerticalGroup(
            TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TransactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshTransactionButton)
                    .addComponent(addTransactionButton)
                    .addComponent(deleteTransactionButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Hóa đơn", TransactionPanel);

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(orderTable);

        refreshOrderButton.setText("Tải lại");
        refreshOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshOrderButtonActionPerformed(evt);
            }
        });

        addOrderButton.setText("Tạo đơn hàng");
        addOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderButtonActionPerformed(evt);
            }
        });

        deleteOrderButton.setText("Xóa");
        deleteOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderButtonActionPerformed(evt);
            }
        });

        submitPaymentOrderButton.setText("Thanh toán");
        submitPaymentOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPaymentOrderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addOrderButton)
                .addGap(31, 31, 31)
                .addComponent(submitPaymentOrderButton)
                .addGap(33, 33, 33)
                .addComponent(deleteOrderButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshOrderButton)
                .addContainerGap())
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshOrderButton)
                    .addComponent(addOrderButton)
                    .addComponent(deleteOrderButton)
                    .addComponent(submitPaymentOrderButton))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        managerTablePane.addTab("Đơn hàng", orderPanel);

        javax.swing.GroupLayout statisticalPanelLayout = new javax.swing.GroupLayout(statisticalPanel);
        statisticalPanel.setLayout(statisticalPanelLayout);
        statisticalPanelLayout.setHorizontalGroup(
            statisticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        statisticalPanelLayout.setVerticalGroup(
            statisticalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        managerTablePane.addTab("Thống kê", statisticalPanel);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 51, 153));
        TitleLabel.setText("Quản lý nhà hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(TitleLabel)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(managerTablePane)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(managerTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffButtonActionPerformed
        // TODO add your handling code here:
        addAccountDialog.setVisible(true);
    }//GEN-LAST:event_addStaffButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int row = staffTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this,"Vui long chon nhan vien", "loi", JOptionPane.ERROR_MESSAGE);
        } else{
            int staffID = Integer.parseInt(String.valueOf(staffTable.getValueAt(row, 0)));
            
            staff = staffBLL.getStaffById(staffID);
            idStaffTextflied.setText(String.valueOf(staff.getStaffID()));
            nameTextfield.setText(staff.getStaffName());
            salaryTextField1.setText(String.valueOf(staff.getSalary()));
            workyearsTextField1.setText(String.valueOf(staff.getWorkYears()));
            jobTextField1.setText(staff.getJob());
            
            updateStaffDialog.setVisible(true);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int row = staffTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui long chon staff truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Ban co chac chan muon xoa khong?");
            if(confirm==JOptionPane.YES_OPTION){
                int staffID = Integer.parseInt(String.valueOf(staffTable.getValueAt(row, 0)));
                accountBLL.deleteAccountByStaffID(staffID);
                staffBLL.deleteStaff(staffID);
                
                staffTableModel.setRowCount(0);
                setTableDataStaff(staffBLL.getAllStaff());
                
                accountTableModel.setRowCount(0);
                setTableDataAccount(accountBLL.getAllAccount());
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        staffTableModel.setRowCount(0);
        setTableDataStaff(staffBLL.getAllStaff());
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountButtonActionPerformed
        // TODO add your handling code here:
        int row = accountTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui long chon truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Ban co chac chan muon xoa khong?");
            if(confirm==JOptionPane.YES_OPTION){
                int accountID = Integer.parseInt(String.valueOf(accountTable.getValueAt(row, 0)));
                account = accountBLL.getAccountByID(accountID);
                int staffID = account.getStaffID();
                accountBLL.deleteAccount(accountID);
                staffBLL.deleteStaff(staffID);

                accountTableModel.setRowCount(0);
                setTableDataAccount(accountBLL.getAllAccount());
                
                staffTableModel.setRowCount(0);
                setTableDataStaff(staffBLL.getAllStaff());
            }
        }
    }//GEN-LAST:event_deleteAccountButtonActionPerformed

    private void refreshAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAccountButtonActionPerformed
        // TODO add your handling code here:
        accountTableModel.setRowCount(0);
        setTableDataAccount(accountBLL.getAllAccount());
    }//GEN-LAST:event_refreshAccountButtonActionPerformed

    private void addAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountButtonActionPerformed
        // TODO add your handling code here:
        addAccountDialog.setVisible(true);
    }//GEN-LAST:event_addAccountButtonActionPerformed

    private void updateCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCustomerButtonActionPerformed
        // TODO add your handling code here:
        int row = customerTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this,"Vui long chon", "loi", JOptionPane.ERROR_MESSAGE);
        } else{
            int customerID = Integer.parseInt(String.valueOf(customerTable.getValueAt(row, 0)));
            
            customer = customerBLL.getCustomerById(customerID);
            
            updateIdCustomerTextflied.setText(String.valueOf(customer.getCustomerID()));
            updateFirstnameCustomerTextfield.setText(customer.getFirstName());
            updateLastNameCustomerTextField.setText(customer.getLastName());
            updateCustomerPhoneTextField.setText(customer.getPhone());
            updateCustomerDialog.setVisible(true);
            
        }
    }//GEN-LAST:event_updateCustomerButtonActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
        // TODO add your handling code here:
        int row = customerTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui long chon truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Ban co chac chan muon xoa khong?");
            if(confirm==JOptionPane.YES_OPTION){
                int customerID = Integer.parseInt(String.valueOf(customerTable.getValueAt(row, 0)));
                customerBLL.deleteCustomer(customerID);

                customerTableModel.setRowCount(0);
                setTableDataCustomer(customerBLL.getAllCustomer());
            }
        }
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed

    private void addCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerButtonActionPerformed
        // TODO add your handling code here:
        addCustomerDialog.setVisible(true);
    }//GEN-LAST:event_addCustomerButtonActionPerformed

    private void refreshCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCustomerButtonActionPerformed
        // TODO add your handling code here:
        customerTableModel.setRowCount(0);
        setTableDataCustomer(customerBLL.getAllCustomer());
    }//GEN-LAST:event_refreshCustomerButtonActionPerformed

    private void updateAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAccountButtonActionPerformed
        // TODO add your handling code here:
        int row = accountTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this,"Vui long chon tai khoan", "loi", JOptionPane.ERROR_MESSAGE);
        } else{
            int accountID = Integer.parseInt(String.valueOf(accountTable.getValueAt(row, 0)));
            updateIdAccountTextflied.setText(String.valueOf(accountID));
            account = accountBLL.getAccountByID(accountID);
            updateUserNameAccountTextfield.setText(account.getUsername());
            updatePasswordAccountTextField.setText(account.getPassword());
            updateAccountDialog.setVisible(true);
            

        }
    }//GEN-LAST:event_updateAccountButtonActionPerformed

    private void addTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTableButtonActionPerformed
        // TODO add your handling code here:
        addTableDialog.setVisible(true);
    }//GEN-LAST:event_addTableButtonActionPerformed

    private void updateTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTableButtonActionPerformed
        // TODO add your handling code here:
        int row = tableTop_Table.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this,"Vui long chon", "loi", JOptionPane.ERROR_MESSAGE);
        } else{
            int tableID = Integer.parseInt(String.valueOf(tableTop_Table.getValueAt(row, 0)));
            
            table = tableBLL.getTableByID(tableID);
            
            tableIDtextField.setText(String.valueOf(table.getTableID()));
            if (table.getCustomerID() == null) {
                customerIDTableTextField.setText(String.valueOf(0));
            }
            else{
                customerIDTableTextField.setText(String.valueOf(table.getCustomerID()));
            }
            
            
            tableCodeTextfield.setText(table.getTableCode());
            
            String status = table.getStatus();
            if ("Available".equals(status)) {
                statusAvailableTableRadioButton.setSelected(true);
            }else if ("Occupied".equals(status)) {
                statusOccupiedTableRadioButton.setSelected(true);
            }
            
            CapicityTextField.setText(String.valueOf(table.getCapacity()));
            
            updateTableDialog.setVisible(true);
            
        }
    }//GEN-LAST:event_updateTableButtonActionPerformed

    private void deleteTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTableButtonActionPerformed
        // TODO add your handling code here:
        int row = tableTop_Table.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui long chon truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Ban co chac chan muon xoa khong?");
            if(confirm==JOptionPane.YES_OPTION){
                int tableID = Integer.parseInt(String.valueOf(tableTop_Table.getValueAt(row, 0)));
                tableBLL.deleteTable(tableID);

                tableTop_TableModel.setRowCount(0);
                setTableDataTableTop(tableBLL.getAllTables());
            }
        }
    }//GEN-LAST:event_deleteTableButtonActionPerformed

    private void refreshTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableButtonActionPerformed
        // TODO add your handling code here:
        tableTop_TableModel.setRowCount(0);
        setTableDataTableTop(tableBLL.getAllTables());
    }//GEN-LAST:event_refreshTableButtonActionPerformed

    private void passwordAccountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordAccountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordAccountTextFieldActionPerformed

    private void ManagerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManagerRadioButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:

        String Role = "";
        Integer StaffID = 0;
        account.setUsername(nameAccountTextfield.getText());
        account.setPassword(passwordAccountTextField.getText());
        if(ManagerRadioButton.isSelected()){
            Role += "manager";
            StaffID = null;
            
        }
        else if (StaffRadioButton.isSelected()) {
        addStaffDialog.setVisible(true);
            
        }
        account.setRole(Role);
        accountBLL.addAccount(account);
        
        accountTableModel.setRowCount(0);
        setTableDataAccount(accountBLL.getAllAccount());
        
        addAccountDialog.dispose();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        addAccountDialog.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void nameAccountTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameAccountTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameAccountTextfieldActionPerformed

    private void jobTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTextFieldActionPerformed

    private void submitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButton1ActionPerformed
        // TODO add your handling code here:
        
        staff.setStaffName(nameStaffTextfield.getText());
        staff.setSalary(Double.parseDouble(salaryTextField.getText()));
        staff.setWorkYears(Integer.parseInt(workyearsTextField.getText()));
        staff.setJob(jobTextField.getText());
        staffBLL.addStaff(staff);
        
//        account.setUsername(nameAccountTextfield.getText());
//        account.setPassword(passwordAccountTextField.getText());
        account.setRole("staff");
        account.setStaffID(staff.getStaffID());
        accountBLL.addAccount(account);
        
        // Close both dialogs
        addStaffDialog.dispose();
        addAccountDialog.dispose();

        // Refresh the tables
        staffTableModel.setRowCount(0);
        setTableDataStaff(staffBLL.getAllStaff());

        accountTableModel.setRowCount(0);
        setTableDataAccount(accountBLL.getAllAccount());
        
    }//GEN-LAST:event_submitButton1ActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        addStaffDialog.dispose();
    }//GEN-LAST:event_backButton1ActionPerformed

    private void nameStaffTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameStaffTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameStaffTextfieldActionPerformed

    private void salaryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTextFieldActionPerformed

    private void updateUserNameAccountTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserNameAccountTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateUserNameAccountTextfieldActionPerformed

    private void updatePasswordAccountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePasswordAccountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatePasswordAccountTextFieldActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
        updateIdAccountTextflied.setText(String.valueOf(account.getAccountID()));
//        updateUserNameAccountTextfield.setTex
//        updatePasswordAccountTextField
        account.setAccountID(Integer.parseInt(updateIdAccountTextflied.getText()));
        account.setUsername(updateUserNameAccountTextfield.getText());
        account.setPassword(updatePasswordAccountTextField.getText());
        account.setStaffID(account.getStaffID());
        accountBLL.updateAccount(account);

        updateAccountDialog.dispose();
        
        accountTableModel.setRowCount(0);
        setTableDataAccount(accountBLL.getAllAccount());
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        // TODO add your handling code here:
        updateAccountDialog.dispose();
    }//GEN-LAST:event_backButton2ActionPerformed

    private void LastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameTextFieldActionPerformed

    private void backButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton3ActionPerformed
        // TODO add your handling code here:
        addCustomerDialog.dispose();
    }//GEN-LAST:event_backButton3ActionPerformed

    private void firstNameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextfieldActionPerformed

    private void submitButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButton2ActionPerformed
        // TODO add your handling code here:
        customer.setFirstName(firstNameTextfield.getText());
        customer.setLastName(LastNameTextField.getText());
        customer.setPhone(PhoneTextField.getText());

        customerBLL.addCustomer(customer);
        
        addCustomerDialog.dispose();
        
        customerTableModel.setRowCount(0);
        setTableDataCustomer(customerBLL.getAllCustomer());
        
        
    }//GEN-LAST:event_submitButton2ActionPerformed

    private void updateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton2ActionPerformed
        // TODO add your handling code here:
        customer.setCustomerID(Integer.parseInt(updateIdCustomerTextflied.getText()));
        customer.setFirstName(updateFirstnameCustomerTextfield.getText());
        customer.setLastName(updateLastNameCustomerTextField.getText());
        customer.setPhone(updateCustomerPhoneTextField.getText());

        customerBLL.updateCustomer(customer);

        customerTableModel.setRowCount(0);
        setTableDataCustomer(customerBLL.getAllCustomer());
        
        updateCustomerDialog.dispose();
    }//GEN-LAST:event_updateButton2ActionPerformed

    private void backButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton4ActionPerformed
        // TODO add your handling code here:
        updateCustomerDialog.dispose();
    }//GEN-LAST:event_backButton4ActionPerformed

    private void updateIdCustomerTextfliedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateIdCustomerTextfliedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateIdCustomerTextfliedActionPerformed

    private void updateFirstnameCustomerTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFirstnameCustomerTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFirstnameCustomerTextfieldActionPerformed

    private void updateLastNameCustomerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLastNameCustomerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateLastNameCustomerTextFieldActionPerformed

    private void updateButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton3ActionPerformed
        // TODO add your handling code here:
        staff.setStaffID(Integer.parseInt(idStaffTextflied.getText()));
        staff.setStaffName(nameTextfield.getText());
        staff.setSalary(Double.parseDouble(salaryTextField1.getText()));
        staff.setWorkYears(Integer.parseInt(workyearsTextField1.getText()));
        staff.setJob(jobTextField1.getText());

        staffBLL.updateStaff(staff);
        
        staffTableModel.setRowCount(0);
        setTableDataStaff(staffBLL.getAllStaff());
        
        updateStaffDialog.dispose();
    }//GEN-LAST:event_updateButton3ActionPerformed

    private void backButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton5ActionPerformed
        // TODO add your handling code here:
        updateStaffDialog.dispose();
    }//GEN-LAST:event_backButton5ActionPerformed

    private void jobTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTextField1ActionPerformed

    private void nameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextfieldActionPerformed

    private void salaryTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTextField1ActionPerformed

    private void addTableCapicityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTableCapicityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTableCapicityTextFieldActionPerformed

    private void addTablesubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTablesubmitButtonActionPerformed
        // TODO add your handling code here:
        table.setTableCode(addTableIDTextField.getText());
        table.setStatus("Available");
        table.setCapacity(Integer.valueOf(addTableCapicityTextField.getText()));
        tableBLL.addTable(table);
        
        addTableDialog.dispose();
        
        tableTop_TableModel.setRowCount(0);
        setTableDataTableTop(tableBLL.getAllTables());
    }//GEN-LAST:event_addTablesubmitButtonActionPerformed

    private void backButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton6ActionPerformed
        // TODO add your handling code here:
        addTableDialog.dispose();
    }//GEN-LAST:event_backButton6ActionPerformed

    private void addTableCustomerIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTableCustomerIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTableCustomerIDTextFieldActionPerformed

    private void customerIDTableTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDTableTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDTableTextFieldActionPerformed

    private void tableCodeTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableCodeTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableCodeTextfieldActionPerformed

    private void updateButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton4ActionPerformed
        // TODO add your handling code here:
        table.setTableID(Integer.parseInt(tableIDtextField.getText()));
        table.setCustomerID(Integer.valueOf(customerIDTableTextField.getText()));
        table.setTableCode(tableCodeTextfield.getText());
        String status = "";
        if (statusAvailableTableRadioButton.isSelected()) {
            status = "Available";
        }else if (statusOccupiedTableRadioButton.isSelected()) {
            status = "Occupied";
        }
        table.setStatus(status);
        table.setCapacity(Integer.valueOf(CapicityTextField.getText()));

        tableBLL.updateTable(table);
        
        updateTableDialog.dispose();
        
        tableTop_TableModel.setRowCount(0);
        setTableDataTableTop(tableBLL.getAllTables());
    }//GEN-LAST:event_updateButton4ActionPerformed

    private void backButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton7ActionPerformed
        // TODO add your handling code here:
        updateTableDialog.dispose();
    }//GEN-LAST:event_backButton7ActionPerformed

    private void CapicityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapicityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CapicityTextFieldActionPerformed

    private void categoryRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryRefreshButtonActionPerformed
        // TODO add your handling code here:
        categoryTableModel.setRowCount(0);
        setTableDataCategory(categoryBLL.getAllCategories());
    }//GEN-LAST:event_categoryRefreshButtonActionPerformed

    private void deleteCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryButtonActionPerformed
        // TODO add your handling code here:
        
        int row = categoryTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui lòng chọn trước", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Bạn có chắc chắn muốn xóa không?");
            if (confirm == JOptionPane.YES_OPTION) {
                int categoryID = Integer.parseInt(String.valueOf(categoryTable.getValueAt(row, 0)));

                // Lấy danh sách tất cả category để tìm đối tượng cần xóa
                ArrayList<CategoryDTO> allCategories = categoryBLL.getAllCategories();
                CategoryDTO categoryToDelete = null;
                for (CategoryDTO cat : allCategories) {
                    if (cat.getCategoryID() == categoryID) {
                        categoryToDelete = cat;
                        break;
                    }
                }

                // Nếu tìm được category cần xóa
                if (categoryToDelete != null) {
                    String imagePath = categoryToDelete.getImageCategory(); // ví dụ: "images/123456789.jpg"
                    if (imagePath != null && !imagePath.isEmpty()) {
                        File imageFile = new File(imagePath);
                        if (imageFile.exists()) {
                            if (imageFile.delete()) {
                                System.out.println("Đã xóa ảnh: " + imageFile.getAbsolutePath());
                            } else {
                                System.out.println("Không thể xóa ảnh: " + imageFile.getAbsolutePath());
                            }
                        }
                    }

                    // Xóa category trong DB
                    categoryBLL.deleteCategory(categoryID);

                    // Làm mới bảng
                    categoryTableModel.setRowCount(0);
                    setTableDataCategory(categoryBLL.getAllCategories());
                }
            }
        }

    }//GEN-LAST:event_deleteCategoryButtonActionPerformed

    private void addCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryButtonActionPerformed
        // TODO add your handling code here:
        addCategoryDialog.setVisible(true);
    }//GEN-LAST:event_addCategoryButtonActionPerformed

    private void addCategorysubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategorysubmitButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (selectedImageFile != null) {
                // 1. Copy ảnh vào thư mục src/images (đường dẫn tương đối trong dự án)
                File destDir = new File("src/images/");
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }

                // 2. Tạo tên ảnh mới để tránh trùng
                String extension = selectedImageFile.getName().substring(selectedImageFile.getName().lastIndexOf("."));
                String uniqueImageName = System.currentTimeMillis() + extension;
                File destFile = new File(destDir, uniqueImageName);

                // 3. Copy ảnh từ nơi người dùng chọn về src/images
                Files.copy(selectedImageFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // 4. Gán đường dẫn ảnh tương đối (từ thư mục src) vào DTO
                category.setImageCategory("src/images/" + uniqueImageName);
            }

            // 5. Thêm dữ liệu khác và lưu vào DB
            category.setCategoryName(addNameCategoryTextField.getText());
            categoryBLL.addCategory(category);

            // 6. Đóng form, làm mới bảng
            addCategoryDialog.dispose();
            categoryTableModel.setRowCount(0);
            setTableDataCategory(categoryBLL.getAllCategories());

            // 7. Debug đường dẫn ảnh
            System.out.println("Ảnh đã lưu tại: " + category.getImageCategory());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi copy ảnh: " + e.getMessage());
        }
    }//GEN-LAST:event_addCategorysubmitButtonActionPerformed

    private void backButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton8ActionPerformed
        // TODO add your handling code here:
        addCategoryDialog.dispose();
    }//GEN-LAST:event_backButton8ActionPerformed

    private void fileChoosenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChoosenButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);

        int x = fileChooser.showDialog(this, "Chọn ảnh");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();

            // Lưu file đã chọn vào biến toàn cục
            selectedImageFile = f;

            // Resize và hiển thị lên label
            int labelWidth = imageLabel.getWidth();
            int labelHeight = imageLabel.getHeight();
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        }

    }//GEN-LAST:event_fileChoosenButtonActionPerformed

    private void updateCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCategoryButtonActionPerformed
        // TODO add your handling code here:
        int row = categoryTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui lòng chọn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int categoryID = Integer.parseInt(String.valueOf(categoryTable.getValueAt(row, 0)));
            category = categoryBLL.getCategoryByID(categoryID);
            categoryIDtextField.setText(String.valueOf(category.getCategoryID()));
            categoryNameTextfield1.setText(category.getCategoryName());

            String relativePath = category.getImageCategory();
            File imageFile = new File(relativePath);

            if (imageFile.exists()) {
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();

                // Lấy kích thước JLabel, nếu bằng 0 thì dùng kích thước mặc định
                int labelWidth = imageCategoryLabel.getWidth();
                int labelHeight = imageCategoryLabel.getHeight();

                // Nếu JLabel chưa có kích thước (width hoặc height = 0) thì dùng kích thước ảnh gốc hoặc kích thước mặc định
                if (labelWidth <= 0 || labelHeight <= 0) {

                    labelWidth = 200;
                    labelHeight = 200;
                }

                // Scale ảnh với kích thước đã xác định
                Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                imageCategoryLabel.setIcon(new ImageIcon(resizedImage));
                updateCategoryDialog.setVisible(true);

            } else {
                System.out.println("Không tìm thấy ảnh tại: " + imageFile.getAbsolutePath());
                imageCategoryLabel.setIcon(null); // Xóa icon nếu không có ảnh
            }
        }
        
    }//GEN-LAST:event_updateCategoryButtonActionPerformed

    private void backButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton10ActionPerformed
        // TODO add your handling code here:
        updateCategoryDialog.dispose();
    }//GEN-LAST:event_backButton10ActionPerformed

    private void updateConfirmCategoryButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateConfirmCategoryButton1ActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ form
        int categoryId = Integer.parseInt(categoryIDtextField.getText());
        String newCategoryName = categoryNameTextfield1.getText();

        try {
            // Lấy đối tượng cũ để lấy đường dẫn ảnh cũ
            CategoryDTO oldCategory = categoryBLL.getCategoryByID(categoryId); // cần hàm này trong BLL
            String oldImagePath = (oldCategory != null) ? oldCategory.getImageCategory() : null;

            String finalImagePath = oldImagePath; // Mặc định giữ ảnh cũ

            if (selectedImageFile != null) {
                // 1. Tạo thư mục nếu chưa có
                File destDir = new File("src/images/");
                if (!destDir.exists()) {
                    JOptionPane.showMessageDialog(this, "Thư mục lưu ảnh 'src/images/' không tồn tại. Vui lòng tạo trước.");
                    return; // Dừng lại nếu không có thư mục
                }

                // 2. Tạo tên file mới duy nhất
                String extension = selectedImageFile.getName().substring(selectedImageFile.getName().lastIndexOf("."));
                String uniqueImageName = System.currentTimeMillis() + extension;

                // 3. Copy ảnh mới
                File destFile = new File(destDir, uniqueImageName);
                Files.copy(selectedImageFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // 4. Gán đường dẫn ảnh mới
                finalImagePath = "src/images/" + uniqueImageName;

                // 5. Xóa ảnh cũ nếu khác với ảnh mới
                if (oldImagePath != null && !oldImagePath.isEmpty()) {
                    File oldFile = new File(oldImagePath);
                    if (oldFile.exists() && oldFile.delete()) {
                        System.out.println("Đã xóa ảnh cũ: " + oldFile.getAbsolutePath());
                    }
                }
            }

            // 6. Gán lại dữ liệu cho đối tượng cần cập nhật
            category.setCategoryID(categoryId);
            category.setCategoryName(newCategoryName);
            category.setImageCategory(finalImagePath);

            // 7. Cập nhật vào DB
            categoryBLL.updateCategory(category);

            // 8. Đóng form và refresh bảng
            updateCategoryDialog.dispose();
            categoryTableModel.setRowCount(0);
            setTableDataCategory(categoryBLL.getAllCategories());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xử lý ảnh: " + e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }

    }//GEN-LAST:event_updateConfirmCategoryButton1ActionPerformed

    private void categoryNameTextfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryNameTextfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryNameTextfield1ActionPerformed

    private void updateChooenImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateChooenImageButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);

        int x = fileChooser.showDialog(this, "Chọn ảnh");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            selectedImageFile = f; // <-- Biến toàn cục

            // Resize ảnh và hiển thị lên label
            int labelWidth = imageCategoryLabel.getWidth();
            int labelHeight = imageCategoryLabel.getHeight();
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            imageCategoryLabel.setIcon(new ImageIcon(resizedImage));

            // Optional: hiển thị tên file
            System.out.println("Đã chọn ảnh mới: " + f.getName());
        }
    }//GEN-LAST:event_updateChooenImageButtonActionPerformed

    private void refreshButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButton11ActionPerformed
        // TODO add your handling code here:
        itemTableModel.setRowCount(0);
        setTableDataItem(itemBLL.getAllItems());
    }//GEN-LAST:event_refreshButton11ActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        itemComboBox.removeAllItems();

        // Lấy danh sách tất cả category từ BLL
        ArrayList<CategoryDTO> categories = categoryBLL.getAllCategories();

        // Thêm từng category vào combobox bằng tên
        for (CategoryDTO category : categories) {
            itemComboBox.addItem(category.getCategoryName());
        }
        
        addItemDialog.setVisible(true);
        
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void addCategorysubmitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategorysubmitButton1ActionPerformed
        // TODO add your handling code here:\
        try {
            if (selectedImageFile != null) {
                // 1. Copy ảnh vào thư mục src/images (đường dẫn tương đối trong dự án)
                File destDir = new File("src/images/");
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }

                // 2. Tạo tên ảnh mới để tránh trùng
                String extension = selectedImageFile.getName().substring(selectedImageFile.getName().lastIndexOf("."));
                String uniqueImageName = System.currentTimeMillis() + extension;
                File destFile = new File(destDir, uniqueImageName);

                // 3. Copy ảnh từ nơi người dùng chọn về src/images
                Files.copy(selectedImageFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // 4. Gán đường dẫn ảnh tương đối (từ thư mục src) vào DTO
                item.setImageItem("src/images/" + uniqueImageName);
            }

            // 5. Thêm dữ liệu khác và lưu vào DB
            item.setItemName(addNameItemTextField.getText());
            item.setItemDetail(itemDetailTextField.getText());
            item.setProductMin(Integer.parseInt(itemProductMinTextField.getText()));
            item.setItemPrice(Integer.parseInt(itemPriceTextField.getText()));
            
            Object selected = itemComboBox.getSelectedItem();

            if (selected != null) {
                String categoryName = selected.toString(); // Chuyển sang String

                // Bước 2: Gọi BLL/DAL để lấy ID từ tên
                category = categoryBLL.getCategoryByName(categoryName);

                if (category != null) {
                    item.setCategoryID(category.getCategoryID()); // Ánh xạ thành công
                } else {
                    System.out.println("Không tìm thấy category: " + categoryName);
                }
            }


            itemBLL.addItem(item);

            // 6. Đóng form, làm mới bảng
            addItemDialog.dispose();
            itemTableModel.setRowCount(0);
            setTableDataItem(itemBLL.getAllItems());

            // 7. Debug đường dẫn ảnh
            System.out.println("Ảnh đã lưu tại: " + item.getImageItem());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi copy ảnh: " + e.getMessage());
        }
    }//GEN-LAST:event_addCategorysubmitButton1ActionPerformed

    private void backButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton9ActionPerformed
        // TODO add your handling code here:
        addItemDialog.dispose();
    }//GEN-LAST:event_backButton9ActionPerformed

    private void fileChoosenButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChoosenButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);

        int x = fileChooser.showDialog(this, "Chọn ảnh");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();

            // Lưu file đã chọn vào biến toàn cục
            selectedImageFile = f;

            // Resize và hiển thị lên label
            int labelWidth = imageLabel1.getWidth();
            int labelHeight = imageLabel1.getHeight();
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            imageLabel1.setIcon(new ImageIcon(resizedImage));
        }
    }//GEN-LAST:event_fileChoosenButton1ActionPerformed

    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        // TODO add your handling code here:
        int row = itemTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui lòng chọn trước", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Bạn có chắc chắn muốn xóa không?");
            if (confirm == JOptionPane.YES_OPTION) {
                int itemID = Integer.parseInt(String.valueOf(itemTable.getValueAt(row, 0)));

                // Lấy danh sách tất cả category để tìm đối tượng cần xóa
                ArrayList<ItemDTO> allItems = itemBLL.getAllItems();
                ItemDTO itemToDelete = null;
                for (ItemDTO item : allItems) {
                    if (item.getItemID() == itemID) {
                        itemToDelete = item;
                        break;
                    }
                }

                // Nếu tìm được category cần xóa
                if (itemToDelete != null) {
                    String imagePath = itemToDelete.getImageItem(); // ví dụ: "images/123456789.jpg"
                    if (imagePath != null && !imagePath.isEmpty()) {
                        File imageFile = new File(imagePath);
                        if (imageFile.exists()) {
                            if (imageFile.delete()) {
                                System.out.println("Đã xóa ảnh: " + imageFile.getAbsolutePath());
                            } else {
                                System.out.println("Không thể xóa ảnh: " + imageFile.getAbsolutePath());
                            }
                        }
                    }

                    // Xóa category trong DB
                    itemBLL.deleteItem(itemID);

                    // Làm mới bảng
                    itemTableModel.setRowCount(0);
                    setTableDataItem(itemBLL.getAllItems());
                }
            }
        }
    }//GEN-LAST:event_deleteItemButtonActionPerformed

    private void updateItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemButtonActionPerformed
        
        int row = itemTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui lòng chọn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int itemID = Integer.parseInt(String.valueOf(itemTable.getValueAt(row, 0)));
            item = itemBLL.getItemByID(itemID);
            itemIDTextField.setText(String.valueOf(item.getItemID()));
            addNameItemTextField1.setText(item.getItemName());
            itemDetailTextField1.setText(item.getItemDetail());
            itemProductMinTextField1.setText(String.valueOf(item.getProductMin()));
            itemPriceTextField1.setText(String.valueOf(item.getItemPrice()));
            
            ArrayList<CategoryDTO> categoryList = categoryBLL.getAllCategories();
            itemComboBox1.removeAllItems();
            for (CategoryDTO category : categoryList) {
                itemComboBox1.addItem(category.getCategoryName());
            }

            String relativePath = item.getImageItem();
            File imageFile = new File(relativePath);

            if (imageFile.exists()) {
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();

                // Lấy kích thước JLabel, nếu bằng 0 thì dùng kích thước mặc định
                int labelWidth = imageLabel2.getWidth();
                int labelHeight = imageLabel2.getHeight();

                // Nếu JLabel chưa có kích thước (width hoặc height = 0) thì dùng kích thước ảnh gốc hoặc kích thước mặc định
                if (labelWidth <= 0 || labelHeight <= 0) {

                    labelWidth = 80;
                    labelHeight = 80;
                }

                // Scale ảnh với kích thước đã xác định
                Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                imageLabel2.setIcon(new ImageIcon(resizedImage));
                updateItemDialog.setVisible(true);

            } else {
                System.out.println("Không tìm thấy ảnh tại: " + imageFile.getAbsolutePath());
                imageLabel2.setIcon(null); // Xóa icon nếu không có ảnh
            }
        }
    }//GEN-LAST:event_updateItemButtonActionPerformed

    private void updateCategorysubmitButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCategorysubmitButton2ActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ form
        int itemId = Integer.parseInt(itemIDTextField.getText());
        String newItemName = addNameItemTextField1.getText();

        try {
            // Lấy đối tượng cũ để lấy đường dẫn ảnh cũ
            ItemDTO oldItem = itemBLL.getItemByID(itemId); // cần hàm này trong BLL
            String oldImagePath = (oldItem != null) ? oldItem.getImageItem(): null;

            String finalImagePath = oldImagePath; // Mặc định giữ ảnh cũ

            if (selectedImageFile != null) {
                // 1. Tạo thư mục nếu chưa có
                File destDir = new File("src/images/");
                if (!destDir.exists()) {
                    JOptionPane.showMessageDialog(this, "Thư mục lưu ảnh 'src/images/' không tồn tại. Vui lòng tạo trước.");
                    return; // Dừng lại nếu không có thư mục
                }

                // 2. Tạo tên file mới duy nhất
                String extension = selectedImageFile.getName().substring(selectedImageFile.getName().lastIndexOf("."));
                String uniqueImageName = System.currentTimeMillis() + extension;

                // 3. Copy ảnh mới
                File destFile = new File(destDir, uniqueImageName);
                Files.copy(selectedImageFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // 4. Gán đường dẫn ảnh mới
                finalImagePath = "src/images/" + uniqueImageName;

                // 5. Xóa ảnh cũ nếu khác với ảnh mới
                if (oldImagePath != null && !oldImagePath.isEmpty()) {
                    File oldFile = new File(oldImagePath);
                    if (oldFile.exists() && oldFile.delete()) {
                        System.out.println("Đã xóa ảnh cũ: " + oldFile.getAbsolutePath());
                    }
                }
            }

            //Tìm kiếm category ID theo tên trong combobox
            String categoryName = (String) itemComboBox1.getSelectedItem();
            category = categoryBLL.getCategoryByName(categoryName);
            int categoryID = category.getCategoryID();
            
            // 6. Gán lại dữ liệu cho đối tượng cần cập nhật
            item.setItemID(itemId);
            item.setItemName(newItemName);
            item.setImageItem(finalImagePath);
            item.setItemDetail(itemDetailTextField1.getText());
            item.setProductMin(Integer.parseInt(itemProductMinTextField1.getText()));
            item.setItemPrice(Double.parseDouble(itemPriceTextField1.getText()));
            item.setCategoryID(categoryID);

            // 7. Cập nhật vào DB
            itemBLL.updateItem(item);

            // 8. Đóng form và refresh bảng
            updateItemDialog.dispose();
            itemTableModel.setRowCount(0);
            setTableDataItem(itemBLL.getAllItems());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xử lý ảnh: " + e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_updateCategorysubmitButton2ActionPerformed

    private void backButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton11ActionPerformed
        // TODO add your handling code here:
        updateItemDialog.setVisible(false);
    }//GEN-LAST:event_backButton11ActionPerformed

    private void fileChoosenButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChoosenButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);

        int x = fileChooser.showDialog(this, "Chọn ảnh");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            selectedImageFile = f; // <-- Biến toàn cục

            // Resize ảnh và hiển thị lên label
            int labelWidth = imageLabel2.getWidth();
            int labelHeight = imageLabel2.getHeight();
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            imageLabel2.setIcon(new ImageIcon(resizedImage));

            // Optional: hiển thị tên file
            System.out.println("Đã chọn ảnh mới: " + f.getName());
        }
    }//GEN-LAST:event_fileChoosenButton2ActionPerformed

    private void refreshTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTransactionButtonActionPerformed
        // TODO add your handling code here:
        transactionTableModel.setRowCount(0);
        setTableDataTransaction(transactionBLL.getAllTransactions());
    }//GEN-LAST:event_refreshTransactionButtonActionPerformed

    private void addTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTransactionButtonActionPerformed
        // TODO add your handling code here:
        addTransactionDialog.setVisible(true);
    }//GEN-LAST:event_addTransactionButtonActionPerformed

    private void submitButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButton3ActionPerformed

        transaction.setCustomerID(Integer.valueOf(CustomerIDTextfield.getText()));
        if (CardRadioButton.isSelected()) {
            transaction.setType("Card");
        }else if (CashRadioButton.isSelected()) {
            transaction.setType("Cash");
        }
        
        
        String statusTransaction = "";
        if (PaidRadioButton.isSelected()) {
            statusTransaction = "Paid";
        } else if (PendingRadioButton.isSelected()) {
            statusTransaction = "Pending";
        }
        transaction.setStatus(statusTransaction);
        
        Date selectedDate = (Date) transactionSpinner.getValue();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(selectedDate.getTime());
        transaction.setCreateAt(sqlTimestamp);
        
        transaction.setOrderID(Integer.valueOf(tracsactionByOrderIDTextField.getText()));
        transaction.setContent(contentTransactionTextField.getText());
        
        transactionBLL.addTransaction(transaction);
        
        transactionTableModel.setRowCount(0);
        setTableDataTransaction(transactionBLL.getAllTransactions());
        
        addTransactionDialog.dispose();
    }//GEN-LAST:event_submitButton3ActionPerformed

    private void backButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton12ActionPerformed
        // TODO add your handling code here:
        addTransactionDialog.dispose();
    }//GEN-LAST:event_backButton12ActionPerformed

    private void CustomerIDTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerIDTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerIDTextfieldActionPerformed

    private void deleteTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTransactionButtonActionPerformed
        
        int row = transactionTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui lòng chọn dòng trước", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Bạn có chắc chắn muốn xóa không?", 
                                                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Lấy giá trị TransactionID từ bảng
                    Object value = transactionTable.getValueAt(row, 0);

                    // Kiểm tra và chuyển đổi sang int
                    int transactionID;
                    if (value instanceof Integer integer) {
                        transactionID = integer;
                    } else {
                        transactionID = Integer.parseInt(value.toString());
                    }

                    // Gọi phương thức xóa
                    transactionBLL.deleteTransaction(transactionID);

                    // Cập nhật lại bảng
                    transactionTableModel.setRowCount(0);
                    setTableDataTransaction(transactionBLL.getAllTransactions());

                    JOptionPane.showMessageDialog(ManagerMainForm.this, "Xóa thành công!", 
                                               "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(ManagerMainForm.this, "ID giao dịch không hợp lệ", 
                                               "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(ManagerMainForm.this, "Lỗi khi xóa: " + e.getMessage(), 
                                               "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_deleteTransactionButtonActionPerformed

    private void refreshOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshOrderButtonActionPerformed
        // TODO add your handling code here:
        orderTableModel.setRowCount(0);
        setTableDataOrder(orderBLL.getAllOrders());
    }//GEN-LAST:event_refreshOrderButtonActionPerformed

    private void addOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderButtonActionPerformed
        // TODO add your handling code here:
        TableIDComboBox.removeAllItems();
        CustomerIDComboBox.removeAllItems();
        // Lấy danh sách tất cả category từ BLL
        ArrayList<TabletopDTO> tables = tableBLL.getAllTables();
        ArrayList<CustomerDTO> customers = customerBLL.getAllCustomer();

        // Thêm từng category vào combobox bằng tên
        for (TabletopDTO tab : tables) {
            TableIDComboBox.addItem(String.valueOf(tab.getTableID()));
        }
        
        for (CustomerDTO cus : customers) {
            CustomerIDComboBox.addItem(String.valueOf(cus.getCustomerID()));
        }
        
        addOrderDialog.setVisible(true);
    }//GEN-LAST:event_addOrderButtonActionPerformed

    private void backButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton13ActionPerformed
        // TODO add your handling code here:
        addOrderDialog.dispose();
    }//GEN-LAST:event_backButton13ActionPerformed

    private void choosenProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosenProductButtonActionPerformed
        // TODO add your handling code here:
        addProductForOrderDialog.setVisible(true);
        
    }//GEN-LAST:event_choosenProductButtonActionPerformed

    private void backButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton14ActionPerformed
        // TODO add your handling code here:
        addProductForOrderDialog.dispose();
    }//GEN-LAST:event_backButton14ActionPerformed

    private void submitOrderItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitOrderItemButtonActionPerformed
        TableModel model = addProductForOrderTable.getModel();
        double total = 0.0;
        boolean hasError = false; // Cờ báo lỗi

        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                // Lấy giá trị từ cột 5 (index 4) và cột 8 (index 7)
                Object value5 = model.getValueAt(i, 4);
                Object value8 = model.getValueAt(i, 7);
                Object value3 = model.getValueAt(i, 3);

                // Chuyển đổi sang số
                double num5 = Double.parseDouble(value5.toString());
                double num8 = Double.parseDouble(value8.toString());
                int num3 = Integer.parseInt(value3.toString());

                // Kiểm tra số lượng (cột 8) phải ≤ 4
                if (num8 > num3) {
                    JOptionPane.showMessageDialog(addProductForOrderDialog,
                        "Lỗi tại dòng " + (i+1) + ": Số lượng không được vượt quá " + num3,
                        "Lỗi số lượng",
                        JOptionPane.ERROR_MESSAGE);
                    hasError = true;
                    break; // Dừng vòng lặp nếu gặp lỗi
                }

                // Nhân và cộng vào tổng
                total += num5 * num8;
            } catch (NumberFormatException e) {
                System.err.println("Lỗi chuyển đổi số tại dòng " + i);
                hasError = true;
            }
        }

        if (!hasError) {
            orderPriceTextField.setText(String.valueOf(total));
            addProductForOrderDialog.dispose();
        }
    }//GEN-LAST:event_submitOrderItemButtonActionPerformed

    private void orderSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderSubmitButtonActionPerformed
        // TODO add your handling code here:
        try {
            order.setTableID(Integer.parseInt(TableIDComboBox.getSelectedItem().toString()));
            order.setCustomerID(Integer.parseInt(CustomerIDComboBox.getSelectedItem().toString()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID phải là số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            BigDecimal totalPrice = new BigDecimal(orderPriceTextField.getText().trim());
            order.setTotalPrice(totalPrice);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            orderPriceTextField.requestFocus();
            return;
        }
        if (contentOrderTextField != null) {
            order.setContent(contentOrderTextField.getText());
        } else {
            order.setContent("");
        }
        
        if (orderBLL != null) {
            try {
                orderBLL.addOrder(order);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm đơn hàng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        orderTableModel.setRowCount(0);
        setTableDataOrder(orderBLL.getAllOrders());
        
        addOrderDialog.dispose();
    }//GEN-LAST:event_orderSubmitButtonActionPerformed

    private void deleteOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderButtonActionPerformed
        // TODO add your handling code here:
        int row = orderTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this, "Vui long chon truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(ManagerMainForm.this, "Ban co chac chan muon xoa khong?");
            if(confirm==JOptionPane.YES_OPTION){
                int orderID = Integer.parseInt(String.valueOf(orderTable.getValueAt(row, 0)));
                orderBLL.deleteOrder(orderID);

                orderTableModel.setRowCount(0);
                setTableDataOrder(orderBLL.getAllOrders());
            }
        }
    }//GEN-LAST:event_deleteOrderButtonActionPerformed

    private void submitPaymentOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPaymentOrderButtonActionPerformed
        // TODO add your handling code here:
        int row = orderTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ManagerMainForm.this,"Vui long chon", "loi", JOptionPane.ERROR_MESSAGE);
        } else{
            int orderTableID = Integer.parseInt(String.valueOf(orderTable.getValueAt(row, 0)));
            
            order = orderBLL.getOrderByID(orderTableID);
            
            transaction.setCustomerID(order.getCustomerID());
            
            transaction.setType("Cash");

            transaction.setStatus("Paid");

            Timestamp sqlTimestamp = new Timestamp(System.currentTimeMillis());
            transaction.setCreateAt(sqlTimestamp);

            transaction.setOrderID(order.getOrderID());
            transaction.setContent("No need");

            transactionBLL.addTransaction(transaction);

            transactionTableModel.setRowCount(0);
            setTableDataTransaction(transactionBLL.getAllTransactions());
            
        }
    }//GEN-LAST:event_submitPaymentOrderButtonActionPerformed


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CapicityTextField;
    private javax.swing.JRadioButton CardRadioButton;
    private javax.swing.ButtonGroup CardorCashbuttonGroup;
    private javax.swing.JRadioButton CashRadioButton;
    private javax.swing.JPanel CategoryPanel;
    private javax.swing.JComboBox<String> CustomerIDComboBox;
    private javax.swing.JTextField CustomerIDTextfield;
    private javax.swing.JTextField LastNameTextField;
    private javax.swing.JRadioButton ManagerRadioButton;
    private javax.swing.JRadioButton PaidRadioButton;
    private javax.swing.JRadioButton PendingRadioButton;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JRadioButton StaffRadioButton;
    private javax.swing.JComboBox<String> TableIDComboBox;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TransactionPanel;
    private javax.swing.ButtonGroup TransactionbuttonGroup;
    private javax.swing.JPanel accountPanel;
    private javax.swing.JTable accountTable;
    private javax.swing.JButton addAccountButton;
    private javax.swing.JDialog addAccountDialog;
    private javax.swing.JButton addCategoryButton;
    private javax.swing.JDialog addCategoryDialog;
    private javax.swing.JButton addCategorysubmitButton;
    private javax.swing.JButton addCategorysubmitButton1;
    private javax.swing.JButton addCustomerButton;
    private javax.swing.JDialog addCustomerDialog;
    private javax.swing.JButton addItemButton;
    private javax.swing.JDialog addItemDialog;
    private javax.swing.JTextField addNameCategoryTextField;
    private javax.swing.JTextField addNameItemTextField;
    private javax.swing.JTextField addNameItemTextField1;
    private javax.swing.JButton addOrderButton;
    private javax.swing.JDialog addOrderDialog;
    private javax.swing.JDialog addProductForOrderDialog;
    private javax.swing.JTable addProductForOrderTable;
    private javax.swing.JButton addStaffButton;
    private javax.swing.JDialog addStaffDialog;
    private javax.swing.JButton addTableButton;
    private javax.swing.JTextField addTableCapicityTextField;
    private javax.swing.JTextField addTableCustomerIDTextField;
    private javax.swing.JDialog addTableDialog;
    private javax.swing.JTextField addTableIDTextField;
    private javax.swing.JTextField addTableStatusTextfield;
    private javax.swing.JButton addTablesubmitButton;
    private javax.swing.JButton addTransactionButton;
    private javax.swing.JDialog addTransactionDialog;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton backButton10;
    private javax.swing.JButton backButton11;
    private javax.swing.JButton backButton12;
    private javax.swing.JButton backButton13;
    private javax.swing.JButton backButton14;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton backButton3;
    private javax.swing.JButton backButton4;
    private javax.swing.JButton backButton5;
    private javax.swing.JButton backButton6;
    private javax.swing.JButton backButton7;
    private javax.swing.JButton backButton8;
    private javax.swing.JButton backButton9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField categoryIDtextField;
    private javax.swing.JTextField categoryNameTextfield1;
    private javax.swing.JButton categoryRefreshButton;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton choosenProductButton;
    private javax.swing.JTextField contentOrderTextField;
    private javax.swing.JTextField contentTransactionTextField;
    private javax.swing.JTextField customerIDTableTextField;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteCategoryButton;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JButton deleteOrderButton;
    private javax.swing.JButton deleteTableButton;
    private javax.swing.JButton deleteTransactionButton;
    private javax.swing.JButton fileChoosenButton;
    private javax.swing.JButton fileChoosenButton1;
    private javax.swing.JButton fileChoosenButton2;
    private javax.swing.JTextField firstNameTextfield;
    private javax.swing.JTextField idStaffTextflied;
    private javax.swing.JLabel imageCategoryLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JComboBox<String> itemComboBox;
    private javax.swing.JComboBox<String> itemComboBox1;
    private javax.swing.JTextField itemDetailTextField;
    private javax.swing.JTextField itemDetailTextField1;
    private javax.swing.JTextField itemIDTextField;
    private javax.swing.JPanel itemPanel;
    private javax.swing.JTextField itemPriceTextField;
    private javax.swing.JTextField itemPriceTextField1;
    private javax.swing.JTextField itemProductMinTextField;
    private javax.swing.JTextField itemProductMinTextField1;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JLabel jobLabel1;
    private javax.swing.JLabel jobLabel2;
    private javax.swing.JLabel jobLabel3;
    private javax.swing.JTextField jobTextField;
    private javax.swing.JTextField jobTextField1;
    private javax.swing.JTabbedPane managerTablePane;
    private javax.swing.JTextField nameAccountTextfield;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel3;
    private javax.swing.JLabel nameLabel4;
    private javax.swing.JLabel nameLabel5;
    private javax.swing.JLabel nameLabel6;
    private javax.swing.JLabel nameLabel7;
    private javax.swing.JLabel nameLabel8;
    private javax.swing.JLabel nameLabel9;
    private javax.swing.JTextField nameStaffTextfield;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JTextField orderPriceTextField;
    private javax.swing.JButton orderSubmitButton;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField passwordAccountTextField;
    private javax.swing.JButton refreshAccountButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refreshButton11;
    private javax.swing.JButton refreshCustomerButton;
    private javax.swing.JButton refreshOrderButton;
    private javax.swing.JButton refreshTableButton;
    private javax.swing.JButton refreshTransactionButton;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JLabel salaryLabel1;
    private javax.swing.JLabel salaryLabel2;
    private javax.swing.JLabel salaryLabel3;
    private javax.swing.JLabel salaryLabel4;
    private javax.swing.JLabel salaryLabel5;
    private javax.swing.JLabel salaryLabel6;
    private javax.swing.JLabel salaryLabel7;
    private javax.swing.JLabel salaryLabel8;
    private javax.swing.JLabel salaryLabel9;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JTextField salaryTextField1;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JTable staffTable;
    private javax.swing.JPanel statisticalPanel;
    private javax.swing.JRadioButton statusAvailableTableRadioButton;
    private javax.swing.JRadioButton statusOccupiedTableRadioButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton submitButton1;
    private javax.swing.JButton submitButton2;
    private javax.swing.JButton submitButton3;
    private javax.swing.JButton submitOrderItemButton;
    private javax.swing.JButton submitPaymentOrderButton;
    private javax.swing.JTextField tableCodeTextfield;
    private javax.swing.JTextField tableIDtextField;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tableTop_Table;
    private javax.swing.ButtonGroup tablebuttonGroup;
    private javax.swing.JLabel tilteLabel;
    private javax.swing.JLabel tilteLabel1;
    private javax.swing.JLabel tilteLabel10;
    private javax.swing.JLabel tilteLabel11;
    private javax.swing.JLabel tilteLabel12;
    private javax.swing.JLabel tilteLabel13;
    private javax.swing.JLabel tilteLabel2;
    private javax.swing.JLabel tilteLabel3;
    private javax.swing.JLabel tilteLabel4;
    private javax.swing.JLabel tilteLabel5;
    private javax.swing.JLabel tilteLabel6;
    private javax.swing.JLabel tilteLabel7;
    private javax.swing.JLabel tilteLabel8;
    private javax.swing.JLabel tilteLabel9;
    private javax.swing.JTextField tracsactionByOrderIDTextField;
    private javax.swing.JSpinner transactionSpinner;
    private javax.swing.JTable transactionTable;
    private javax.swing.JButton updateAccountButton;
    private javax.swing.JDialog updateAccountDialog;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateButton1;
    private javax.swing.JButton updateButton2;
    private javax.swing.JButton updateButton3;
    private javax.swing.JButton updateButton4;
    private javax.swing.JButton updateCategoryButton;
    private javax.swing.JDialog updateCategoryDialog;
    private javax.swing.JButton updateCategorysubmitButton2;
    private javax.swing.JButton updateChooenImageButton;
    private javax.swing.JButton updateConfirmCategoryButton1;
    private javax.swing.JButton updateCustomerButton;
    private javax.swing.JDialog updateCustomerDialog;
    private javax.swing.JTextField updateCustomerPhoneTextField;
    private javax.swing.JTextField updateFirstnameCustomerTextfield;
    private javax.swing.JTextField updateIdAccountTextflied;
    private javax.swing.JTextField updateIdCustomerTextflied;
    private javax.swing.JButton updateItemButton;
    private javax.swing.JDialog updateItemDialog;
    private javax.swing.JTextField updateLastNameCustomerTextField;
    private javax.swing.JTextField updatePasswordAccountTextField;
    private javax.swing.JDialog updateStaffDialog;
    private javax.swing.JButton updateTableButton;
    private javax.swing.JDialog updateTableDialog;
    private javax.swing.JTextField updateUserNameAccountTextfield;
    private javax.swing.JLabel workyearsLabel;
    private javax.swing.JLabel workyearsLabel1;
    private javax.swing.JLabel workyearsLabel2;
    private javax.swing.JLabel workyearsLabel3;
    private javax.swing.JLabel workyearsLabel4;
    private javax.swing.JLabel workyearsLabel5;
    private javax.swing.JLabel workyearsLabel6;
    private javax.swing.JLabel workyearsLabel7;
    private javax.swing.JLabel workyearsLabel8;
    private javax.swing.JLabel workyearsLabel9;
    private javax.swing.JTextField workyearsTextField;
    private javax.swing.JTextField workyearsTextField1;
    // End of variables declaration//GEN-END:variables
}
