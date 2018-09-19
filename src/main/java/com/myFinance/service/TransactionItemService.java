package com.myFinance.service;

import com.myFinance.entity.TransactionItem;

import java.util.List;

public interface TransactionItemService {

    /**
     * Transactions
     * */
    Boolean makeTransaction (TransactionItem item);

    List<TransactionItem> getAllTransaction ();

    Integer getAllIncome ();

    Integer getAllExpense ();

    String deleteTransaction (TransactionItem item);

    String modifyTransaction (TransactionItem item);
}
