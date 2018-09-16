package com.myFinance.service;

import com.myFinance.entity.TransactionItem;
import com.myFinance.repository_dao.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TransactionItemImpl implements TransactionItemService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionItemImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Make Transaction this will create the transaction itself.
     * @item this is the object which contains all the data about a transaction.
     * */
    @Override
    public String makeTransaction(TransactionItem item) {

        log.info(">> [makeTransaction] - Access Granted for: {}");

        Date createDate = new Date();

        item.setDate(createDate);
        item.setCurrency("Huf");

        Random rand = new Random();
        int itemNumber = rand.nextInt(10000) + 1;
        item.setTransactionNumber(itemNumber);

        transactionRepository.save(item);

        return "saved";
    }

    @Override
    public Integer getAllIncome() {
        List<TransactionItem> items = getAllTransaction();
        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getDirection().equals("Income")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info("Sum: "+ sum);

        return sum;
    }

    @Override
    public Integer getAllExpense() {
        List<TransactionItem> items = getAllTransaction();
        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getDirection().equals("Expense")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info("Sum: "+ sum);

        return sum;
    }

    /**
     * Delete Transaction this will delete the transaction.
     * @item this is the object which contains all the data about a transaction.
     * */
    @Override
    public String deleteTransaction(TransactionItem item) {
        log.info(">> [deleteTransaction] - Access Granted for: {}", item.getId() +" <> "+item.getTransactionNumber());

        return "deleted";
    }

    /**
     * Modify the Transaction this will modify the transaction data.
     * @item this is the object which contains all the data about a transaction.
     * */
    @Override
    public String modifyTransaction(TransactionItem item) {
        log.info(">> [modifyTransaction] - Access Granted for: {}", item.getId() +" <> "+item.getTransactionNumber());

        return "modified";
    }

    /**
     *
     * */
    @Override
    public TransactionItem getTransactionbyId() {
        return transactionRepository.findById(1L);
    }

    /**
     *
     * */
    @Override
    public List<TransactionItem> getAllTransaction() {
        return (List<TransactionItem>) transactionRepository.findAll();
    }

}
