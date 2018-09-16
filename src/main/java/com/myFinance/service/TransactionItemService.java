package com.myFinance.service;

import com.myFinance.entity.TransactionItem;

import java.util.List;

public interface TransactionItemService {

    String makeTransaction (TransactionItem item);

    Integer getAllIncome ();

    Integer getAllExpense ();

    String deleteTransaction (TransactionItem item);

    String modifyTransaction (TransactionItem item);

    TransactionItem getTransactionbyId ();

    List<TransactionItem> getAllTransaction ();
}
