package com.myFinance.service;

import com.myFinance.entity.TransactionItem;
import com.myFinance.repository_dao.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionItemImpl implements TransactionItemService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TransactionRepository transactionRepository;

    private List<TransactionItem> items;

    @Autowired
    public TransactionItemImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.items = this.getAllTransaction();
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

        int quantity = Integer.parseInt(item.getQuantity());

        if(quantity <= 0){
            log.error(">> [Impl|makeTransaction] - Item quantity cannot be ZERO or less.");
            return false;
        }

        if (item.getDirection().equals("Expense")){
            quantity = quantity * -1;
            log.info("Quantity: "+quantity);
        }

        item.setQuantity(String.valueOf(quantity));

        Date createDate = new Date();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(createDate);

        item.setCreationDate(modifiedDate);
        item.setItemCreationDate(createDate);

        log.info(">> [Impl|makeTransaction] - Item creation date: {}", createDate);

        item.setCurrency("Huf");
        log.info(">> [Impl|makeTransaction] - Item Currency: {}", item.getCurrency());

        Random rand = new Random();
        int itemNumber = rand.nextInt(10000) + 1;
        item.setTransactionNumber(itemNumber);

        transactionRepository.save(item);
        log.info(">> [Impl|makeTransaction] - Transaction created with the following number: {}", item.getTransactionNumber());

        items = getAllTransaction();

        return true;
    }

    /**
     * Get All Income this will getting the summarise of the incomes.
     * */
    @Override
    public Integer getAllIncome() {

        log.info(">> [Impl|getAllIncome] - Getting a Sum about the Incomes.");

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

        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getDirection().equals("Expense")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getAllExpense] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /*********************************************************
     *
     * TODO NEED TO REFACTOR THE WHOLE SECTOR - SECTOR START
     *
     * *******************************************************/

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getkBudge() {
        log.info(">> [Impl|getkBudge] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getCards().equals("Kriszti")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getkBudge] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getZBudge() {
        log.info(">> [Impl|getZBudge] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getCards().equals("Zoli")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getZBudge] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getcBudge() {
        log.info(">> [Impl|getcBudge] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getCards().equals("Credit")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getcBudge] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getsBudge() {
        log.info(">> [Impl|getsBudge] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : items) {
            if(item.getCards().equals("Savings")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getsBudge] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getkBudgeLast() {
        log.info(">> [Impl|getkBudgeLast] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : getLasMonthItems()) {
            if(item.getCards().equals("Kriszti")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getkBudgeLast] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getZBudgeLast() {
        log.info(">> [Impl|getZBudgeLast] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : getLasMonthItems()) {
            if(item.getCards().equals("Zoli")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getZBudgeLast] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getcBudgeLast() {
        log.info(">> [Impl|getcBudgeLast] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : getLasMonthItems()) {
            if(item.getCards().equals("Credit")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getcBudgeLast] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * Todo Need to be refactored these sections.
     * */
    @Override
    public Integer getsBudgeLast() {
        log.info(">> [Impl|getsBudgeLast] - Getting a Sum about the Expenses.");

        int sum = 0;

        for (TransactionItem item : getLasMonthItems()) {
            if(item.getCards().equals("Savings")){
                sum = sum + Integer.parseInt(item.getQuantity());
            }
        }

        log.info(">> [Impl|getsBudgeLast] - The summarized quantity is: -{}", sum);

        return sum;
    }

    /**
     * This method get back with a filtered Item list which contains the actual MONTH
     * transactions only.
     * */
    private List<TransactionItem> getLasMonthItems(){

        log.info(">> [Impl|getLasMonthItems] - Getting the last month transactions from all the transactions.");

        String containedDate = getActualYearAndMonth();

        log.info(">> [Impl|getLasMonthItems] - Getting transactions by the actual date: "+containedDate);

        return items.stream().filter(myitem -> myitem.getCreationDate().contains(containedDate)).collect(Collectors.toList());
    }

    /*********************************************************
     *
     * TODO NEED TO REFACTOR THE WHOLE SECTOR - SECTOR END
     *
     * *******************************************************/

    /**
     * Get back the Actual Year and Month
     * */
    public String getActualYearAndMonth(){

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        return year+"-"+((month >= 10) ? month : "0"+month);
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

        List<TransactionItem> myList = transactionRepository.findAll();
        Collections.reverse(myList);

        log.info(">> [Impl|getAllTransaction] - All transaction counts: [" + myList.size()+"] elements.");
        return myList;
    }

    @Override
    public List<TransactionItem> getLastXTransaction() {
        log.info(">> [Impl|getLastXTransaction] - Getting All the transaction... it can take time.");

        List<TransactionItem> myList = transactionRepository.getLastHundredElements();

        for (TransactionItem item : myList) {
            System.out.println("\n"+item.toString());
        }

        log.info(">> [Impl|getLastXTransaction] - All transaction counts: [" + myList.size()+"] elements.");
        return myList;
    }

}
