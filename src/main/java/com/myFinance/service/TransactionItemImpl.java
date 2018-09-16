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

    @Override
    public String makeTransaction(TransactionItem item) {

        log.info(">> [makeTransaction] - Access Granted for: {}");

        Date createDate = new Date();
        item.setDate(createDate);

        Random rand = new Random();
        int itemNumber = rand.nextInt(10000) + 1;
        item.setTransactionNumber(itemNumber);

        transactionRepository.save(item);

        return "saved";
    }

    @Override
    public String deleteTransaction(TransactionItem item) {
        log.info(">> [deleteTransaction] - Access Granted for: {}", item.getId() +" <> "+item.getTransactionNumber());

        return "deleted";
    }

    @Override
    public String modifyTransaction(TransactionItem item) {
        log.info(">> [modifyTransaction] - Access Granted for: {}", item.getId() +" <> "+item.getTransactionNumber());

        return "modified";
    }

    @Override
    public TransactionItem getTransactionbyId() {

        return transactionRepository.findById(1L);
    }

    @Override
    public List<TransactionItem> getAllTransaction() {
        return (List<TransactionItem>) transactionRepository.findAll();
    }

}
