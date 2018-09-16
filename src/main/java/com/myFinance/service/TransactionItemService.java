package com.myFinance.service;

import com.myFinance.entity.TransactionItem;

import java.util.List;

public interface TransactionItemService {

    String makeTransaction (TransactionItem item);

    String deleteTransaction (TransactionItem item);

    String modifyTransaction (TransactionItem item);

    TransactionItem getTransactionbyId ();

    List<TransactionItem> getAllTransaction ();
}
