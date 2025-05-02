package BLL;

import DAL.TransactionDAO;
import DTO.TransactionDTO;
import java.util.ArrayList;

public class TransactionBLL {

    private final TransactionDAO transactionDAO;

    public TransactionBLL() {
        this.transactionDAO = new TransactionDAO();
    }

    public boolean addTransaction(TransactionDTO transaction) {
        return transactionDAO.insertTransaction(transaction);
    }

    public ArrayList<TransactionDTO> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    public TransactionDTO getTransactionByID(int id) {
        return transactionDAO.getTransactionByID(id);
    }

    public boolean updateTransaction(TransactionDTO transaction) {
        return transactionDAO.updateTransaction(transaction);
    }

    public boolean deleteTransaction(int transactionID) {
        return transactionDAO.deleteTransaction(transactionID);
    }
}
