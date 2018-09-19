package com.myFinance.service;

import com.myFinance.entity.TransactionItem;
import com.myFinance.repository_dao.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public Boolean makeTransaction(TransactionItem item) {

        log.info(">> [Impl|makeTransaction] - Creating transaction...");

        // Cut out the splitter from the quantity.
        item.setQuantity(item.getQuantity().replace(",",""));

        if(Integer.parseInt(item.getQuantity()) <= 0){
            log.error(">> [Impl|makeTransaction] - Item quantity cannot be ZERO or less.");
            return false;
        }

        Date createDate = new Date();
        item.setCreationDate(createDate);
        log.info(">> [Impl|makeTransaction] - Item creation date: {}", createDate);

        item.setCurrency("Huf");
        log.info(">> [Impl|makeTransaction] - Item Currency: {}", item.getCurrency());

        Random rand = new Random();
        int itemNumber = rand.nextInt(10000) + 1;
        item.setTransactionNumber(itemNumber);

        transactionRepository.save(item);
        log.info(">> [Impl|makeTransaction] - Transaction created with the following number: {}", item.getTransactionNumber());

        return true;
    }

    /**
     * Get All Income this will getting the summarise of the incomes.
     * */
    @Override
    public Integer getAllIncome() {

        log.info(">> [Impl|getAllIncome] - Getting a Sum about the Incomes.");

        List<TransactionItem> items = getAllTransaction();
        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getDirection().equals("Income")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getAllIncome] - The summarized quantity is: {}", sum);

        return sum;
    }

    /**
     * Get All Expense this will getting the summarise of the expenses.
     * */
    @Override
    public Integer getAllExpense() {

        log.info(">> [Impl|getAllExpense] - Getting a Sum about the Expenses.");

        List<TransactionItem> items = getAllTransaction();
        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getDirection().equals("Expense")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getAllExpense] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Delete Transaction this will delete the transaction.
     * @item this is the object which contains all the data about a transaction.
     * */
    @Override
    public String deleteTransaction(TransactionItem item) {
        log.info(">> [Impl|deleteTransaction] - Access Granted for: {}", item.getId() +" <> "+item.getTransactionNumber());

        return "deleted";
    }

    /**
     * Modify the Transaction this will modify the transaction data.
     * @item this is the object which contains all the data about a transaction.
     * */
    @Override
    public String modifyTransaction(TransactionItem item) {
        log.info(">> [Impl|modifyTransaction] - Access Granted for: {}", item.getId() +" <> "+item.getTransactionNumber());

        return "modified";
    }

    /**
     * Get All Transaction this will getting all the transactions.
     * */
    @Override
    public List<TransactionItem> getAllTransaction() {
        log.info(">> [Impl|getAllTransaction] - Getting All the transaction... it can take time.");

        List<TransactionItem> myList = (List<TransactionItem>) transactionRepository.findAll();
        Collections.reverse(myList);

        log.info(">> [Impl|getAllTransaction] - All transaction counts: [" + myList.size()+"] elements.");
        return myList;
    }

}
